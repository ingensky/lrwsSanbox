<#--to use staticUtl, remove it from restricetedVariables https://stackoverflow.com/a/52662305 -->
<#assign userLocalServiceUtil = staticUtil['com.liferay.portal.kernel.service.UserLocalServiceUtil'] />


<table class="show-quick-actions-on-hover table table-autofit table-hover table-list table-nowrap">
    <thead>
        <tr>
            <th>Site Name</th>
            <th>Site URL</th>
            <th>Members</th>
        </tr>
    </thead>
    <tbody>
        <#if entries?has_content>
            <#list entries as currentSite>
                <tr>
                    <td> ${currentSite.name} </td>
                    <td><a href="${currentSite.getDisplayURL(themeDisplay)}">Go to pages</a></td>
                    <td>${userLocalServiceUtil.getGroupUsersCount(currentSite.groupId)}</td>
                </tr>
            </#list>
        </#if>
    </tbody>
</table>