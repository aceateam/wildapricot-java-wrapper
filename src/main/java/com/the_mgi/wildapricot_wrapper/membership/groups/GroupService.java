package com.the_mgi.wildapricot_wrapper.membership.groups;

import com.fasterxml.jackson.core.type.TypeReference;
import com.the_mgi.wildapricot_wrapper.ApplicationService;
import com.the_mgi.wildapricot_wrapper.WildApricot;
import com.the_mgi.wildapricot_wrapper.base.model.Pair;
import com.the_mgi.wildapricot_wrapper.exception.HttpException;
import com.the_mgi.wildapricot_wrapper.membership.groups.model.MembershipGroup;
import com.the_mgi.wildapricot_wrapper.membership.groups.model.MembershipGroupListItem;

import java.util.List;

public class GroupService {
    private final ApplicationService applicationService;

    public GroupService(WildApricot wildApricot) {
        this.applicationService = ApplicationService.getInstance(wildApricot);
    }

    /**
     * @param accountId Your account identifier (pathVariable)
     * @return An array of member group descriptions
     * @throws HttpException provides exception descriptions
     *                       <ul>
     *                          <li>401 oAuth token was not provided, invalid or does not provide access to requested URL</li>
     *                          <li>429 Too many requests from same account. Wait for a minute and try again, however this exception is handled, will automatically wait for 1 minutes, and then do another call.</li>
     *                       </ul>
     */
    public List<MembershipGroupListItem> getListOfAdHocMemberGroups(
        Integer accountId
    ) throws HttpException {
        return this.applicationService.execute(
            "accounts/" + accountId + "/membergroups",
            new TypeReference<List<MembershipGroupListItem>>() {
            }
        );
    }

    /**
     * @param accountId              Your account identifier (pathVariable)
     * @param membergroupId          member group identifier (pathVariable)
     * @param includeArchivedMembers include archived contacts in ContactIds list. Default - true. (query)
     * @return member group description
     * @throws HttpException provides exception descriptions
     *                       <ul>
     *                          <li>401 oAuth token was not provided, invalid or does not provide access to requested URL</li>
     *                          <li>Requested item not found.</li>
     *                          <li>429 Too many requests from same account. Wait for a minute and try again, however this exception is handled, will automatically wait for 1 minutes, and then do another call.</li>
     *                       </ul>
     */
    public MembershipGroup getAdHocMemberGroupDetails(
        Integer accountId,
        Integer membergroupId,
        Boolean includeArchivedMembers
    ) throws HttpException {
        return this.applicationService.execute(
            "accounts/" + accountId + "/membergroups/" + membergroupId,
            new TypeReference<>() {
            },
            List.of(new Pair<>("includeArchivedMembers", includeArchivedMembers == null ? null : Boolean.toString(includeArchivedMembers)))
        );
    }
}
