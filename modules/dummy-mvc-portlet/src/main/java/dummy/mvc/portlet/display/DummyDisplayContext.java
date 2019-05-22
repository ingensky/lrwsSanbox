package dummy.mvc.portlet.display;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.ViewTypeItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.ViewTypeItemList;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portlet.usersadmin.search.GroupSearch;
import com.liferay.portlet.usersadmin.search.GroupSearchTerms;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Configurates displaying context in portlet
 *
 */
public class DummyDisplayContext {
    private String displayStyle;
    private GroupSearch groupSearch;
    private final RenderRequest renderRequest;
    private final RenderResponse renderResponse;
    private final HttpServletRequest request;
    private ThemeDisplay themeDisplay;
    private Layout layout;
    private Company company;
    private String dummyField;

    public DummyDisplayContext(RenderRequest renderRequest,
                               RenderResponse renderResponse,
                               ThemeDisplay themeDisplay,
                               Layout layout, Company company, String dummyField) {
        this.renderRequest = renderRequest;
        this.renderResponse = renderResponse;
        this.request = PortalUtil.getHttpServletRequest(renderRequest);
        this.themeDisplay = themeDisplay;
        this.layout = layout;
        this.company = company;
        this.dummyField = dummyField;
    }

    /**
     * Create render url from renderResponse with display style
     *
     * @return
     */
    public PortletURL getPortletURL() {
        PortletURL portletURL = this.renderResponse.createRenderURL();
        portletURL.setParameter("displayStyle", this.getDisplayStyle());
        return portletURL;
    }

    /**
     * Attempt to get displayStyle from renderRequest, if displayStyle is null, or returns it
     * By default set to "icon" (card style)
     *
     * @return
     */
    public String getDisplayStyle() {
        if (Validator.isNotNull(this.displayStyle)) {
            return this.displayStyle;
        } else {
            this.displayStyle = ParamUtil.getString(this.renderRequest, "displayStyle", "icon");
            return this.displayStyle;
        }
    }


    /**
     * Returns PortletURL as string with cleared keywords
     * (for implementation with search form)
     *
     * @return
     */
    public String getClearResultsURL() {
        PortletURL clearResultsURL = this.getPortletURL();
        clearResultsURL.setParameter("keywords", "");
        return clearResultsURL.toString();
    }


    /**
     * Return number of founded by search items
     *
     * @return
     */
    public int getTotalItems() {
        GroupSearch groupSearch = this.getGroupSearchContainer();
        return groupSearch.getTotal();
    }

    /**
     * Returns displayStyles for rendering items
     *
     * @return
     */
    public List<ViewTypeItem> getViewTypeItems() {
        ViewTypeItemList viewTypeItems = new ViewTypeItemList(this.getPortletURL(), this.getDisplayStyle()) {
            {
                this.addCardViewTypeItem();
                this.addTableViewTypeItem();
            }
        };
        viewTypeItems.add(createADTViewTypeItem());
        return viewTypeItems;
    }


    /**
     * Constructs new ADTViewTypeItem
     *
     * @return
     */
    private ViewTypeItem createADTViewTypeItem() {
        ViewTypeItem viewTypeItem = new ViewTypeItem();

        if (Validator.isNotNull(displayStyle)) {
            viewTypeItem.setActive(
                    Objects.equals(displayStyle, "adt"));
        }

        PortletURL portletURL = this.getPortletURL();
        if (portletURL != null) {
            viewTypeItem.setHref(portletURL, "displayStyle", "adt");
        }

        viewTypeItem.setIcon("sun");
        viewTypeItem.setLabel(
                LanguageUtil.get(LocaleUtil.getMostRelevantLocale(), "ADT"));

        return viewTypeItem;
    }

    /**
     * Returns group search result
     *
     * @return
     */
    public GroupSearch getGroupSearchContainer() {
        GroupSearch groupSearch = new GroupSearch(this.renderRequest, this.getPortletURL());
        GroupSearchTerms searchTerms = (GroupSearchTerms) groupSearch.getSearchTerms();
        LinkedHashMap<String, Object> groupParams = new LinkedHashMap<>();

        groupSearch.setDelta(5);

        groupParams.put("site", Boolean.TRUE);

        List<Group> groups;
        int groupsCount;

        if (layout.getGroup().isOrganization()) {
            groupParams.put("active", Boolean.TRUE);
            long organizationId = layout.getGroup().getOrganizationId();
            groupsCount = GroupLocalServiceUtil.getOrganizationGroupsCount(organizationId);
            groups = GroupLocalServiceUtil.getOrganizationGroups(organizationId);
        } else {
            if (layout.getGroup().isUser()) {
                groupParams.put("usersGroups", layout.getGroup().getClassPK());
                groupParams.put("active", Boolean.TRUE);

            } else {
                List<Integer> types = new ArrayList<>();

                types.add(GroupConstants.TYPE_SITE_OPEN);
                types.add(GroupConstants.TYPE_SITE_RESTRICTED);

                groupParams.put("types", types);
                groupParams.put("active", Boolean.TRUE);
            }

            groupsCount = GroupLocalServiceUtil.searchCount(company.getCompanyId(), searchTerms.getKeywords(), groupParams);

            groups = GroupLocalServiceUtil.search(
                    company.getCompanyId(),
                    searchTerms.getKeywords(),
                    groupParams, groupSearch.getStart(),
                    groupSearch.getEnd(),
                    groupSearch.getOrderByComparator());

        }

        groupSearch.setTotal(groupsCount);


        long layoutId = Long.parseLong(dummyField);

        if (layoutId != 0) {
            groups = groups.stream().filter(group -> {
                try {
                    return (group.getPublicLayoutSet().getLayoutSetPrototypeId() == layoutId) ||
                            (group.getPrivateLayoutSet().getLayoutSetPrototypeId() == layoutId);
                } catch (PortalException e) {
                    e.printStackTrace();
                }
                return false;
            }).collect(Collectors.toList());

        }

        groupSearch.setResults(groups);


        this.groupSearch = groupSearch;

        return this.groupSearch;
    }

    public int getGroupUsersCounts(long groupId) {
        GroupSearch groupSearch = this.getGroupSearchContainer();
        long[] groupIds = ListUtil.toLongArray(groupSearch.getResults(), Group.GROUP_ID_ACCESSOR);
        Map<Long, Integer> groupUsersCounts = UserLocalServiceUtil.searchCounts(company.getCompanyId(), WorkflowConstants.STATUS_APPROVED, groupIds);
        return GetterUtil.getInteger(groupUsersCounts.get(groupId));

    }
}
