package sunrise.sites.mvc.portlet.display;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.ViewTypeItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.ViewTypeItemList;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portlet.usersadmin.search.GroupSearch;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Configures displaying context in portlet jsp
 *
 * @author sky
 */
public class SitesDisplayContext {
    private String displayStyle;
    private final RenderRequest renderRequest;
    private final RenderResponse renderResponse;
    private Layout layout;
    private Company company;
    private String sitesTemplateId;

    public SitesDisplayContext(RenderRequest renderRequest, RenderResponse renderResponse,
                               Layout layout, Company company, String sitesTemplateId) {
        this.renderRequest = renderRequest;
        this.renderResponse = renderResponse;
        this.layout = layout;
        this.company = company;
        this.sitesTemplateId = sitesTemplateId;
    }

    /**
     * Create render url from renderResponse with display style
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
     * @return number of founded by search items
     */
    public int getTotalItems() {
        GroupSearch groupSearch = this.getGroupSearchContainer();
        return groupSearch.getTotal();
    }

    /**
     * @return  displayStyles for rendering items
     */
    public List<ViewTypeItem> getViewTypeItems() {
        return new ViewTypeItemList(SitesDisplayContext.this.getPortletURL(), SitesDisplayContext.this.getDisplayStyle()) {
            {
                this.addCardViewTypeItem();
                this.addTableViewTypeItem();
            }
        };
    }

    /**
     * Creates GroupSearch and sets its results and total
     *
     * @return group search
     */
    public GroupSearch getGroupSearchContainer() {
        GroupSearch groupSearch = new GroupSearch(this.renderRequest, this.getPortletURL());
        long siteTemplateId = Long.parseLong(sitesTemplateId);

        List<Group> groups;
        int groupsCount;
        int startSearch;
        int endSearch;


        if (siteTemplateId == 0) {
            startSearch = groupSearch.getStart();
            endSearch = groupSearch.getEnd();
        } else {
            startSearch = -1;
            endSearch = -1;
        }

        if (layout.getGroup().isOrganization()) {
            long organizationId = layout.getGroup().getOrganizationId();

            groupsCount = GroupLocalServiceUtil.getOrganizationGroupsCount(organizationId);

            groups = GroupLocalServiceUtil.getOrganizationGroups(
                    organizationId,
                    startSearch,
                    endSearch,
                    groupSearch.getOrderByComparator());

        } else {
            LinkedHashMap<String, Object> groupParams = prepareGroupParams();

            groupsCount = GroupLocalServiceUtil.searchCount(company.getCompanyId(), null, groupParams);

            groups = GroupLocalServiceUtil.search(
                    company.getCompanyId(),
                    null,
                    groupParams,
                    startSearch, endSearch,
                    groupSearch.getOrderByComparator());
        }


        setGroupSearchResultsAndTotal(groupSearch, siteTemplateId, groups, groupsCount);

        return groupSearch;
    }

    /**
     * Prepare group search parameters, based on portlet current layout
     * @return groupParams
     */
    private LinkedHashMap<String, Object> prepareGroupParams() {
        LinkedHashMap<String, Object> groupParams = new LinkedHashMap<>();

        groupParams.put("active", Boolean.TRUE);
        groupParams.put("site", Boolean.TRUE);


        if (layout.getGroup().isUser()) {
            groupParams.put("usersGroups", layout.getGroup().getClassPK());

        } else {
            List<Integer> types = new ArrayList<>();

            types.add(GroupConstants.TYPE_SITE_OPEN);
            types.add(GroupConstants.TYPE_SITE_RESTRICTED);

            groupParams.put("types", types);
        }
        return groupParams;
    }

    /**
     * Sets GroupSearch results and total properties, dependant on siteTemplateId
     */
    private void setGroupSearchResultsAndTotal(GroupSearch groupSearch, long siteTemplateId, List<Group> groups, int groupsCount) {
        if (siteTemplateId != 0) {
            groups = filterGroupsBySiteTemplateId(siteTemplateId, groups);

            groupSearch.setTotal(groups.size());

            groupSearch.setResults(groups
                    .subList(groupSearch.getStart(),
                            groupSearch.getEnd() < groups.size() ? groupSearch.getEnd() : groups.size()));

        } else {
            groupSearch.setTotal(groupsCount);
            groupSearch.setResults(groups);
        }
    }

    /**
     * @return sites filtered by siteTemplateId
     */
    private List<Group> filterGroupsBySiteTemplateId(long siteTemplateId, List<Group> groups) {
        return groups.stream().filter(group -> {
            try {
                return (group.getPublicLayoutSet().getLayoutSetPrototypeId() == siteTemplateId) ||
                        (group.getPrivateLayoutSet().getLayoutSetPrototypeId() == siteTemplateId);
            } catch (PortalException e) {
                e.printStackTrace();
            }
            return false;
        }).collect(Collectors.toList());
    }


    /**
     * @param groupId the primary key of the group
     * @return number of members of the group
     */
    public int getGroupUsersCounts(long groupId) {
        GroupSearch groupSearch = this.getGroupSearchContainer();
        long[] groupIds = ListUtil.toLongArray(groupSearch.getResults(), Group.GROUP_ID_ACCESSOR);
        Map<Long, Integer> groupUsersCounts = UserLocalServiceUtil.searchCounts(company.getCompanyId(), WorkflowConstants.STATUS_APPROVED, groupIds);
        return GetterUtil.getInteger(groupUsersCounts.get(groupId));

    }
}
