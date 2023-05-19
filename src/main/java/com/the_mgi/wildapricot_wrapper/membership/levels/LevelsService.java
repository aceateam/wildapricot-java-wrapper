package com.the_mgi.wildapricot_wrapper.membership.levels;

import com.fasterxml.jackson.core.type.TypeReference;
import com.the_mgi.wildapricot_wrapper.ApplicationService;
import com.the_mgi.wildapricot_wrapper.WildApricot;
import com.the_mgi.wildapricot_wrapper.exception.HttpException;
import com.the_mgi.wildapricot_wrapper.membership.levels.model.MembershipLevel;

import java.util.List;

public class LevelsService {
    private final ApplicationService applicationService;

    public LevelsService(WildApricot wildApricot) {
        this.applicationService = ApplicationService.getInstance(wildApricot);
    }

    /**
     * Get list of all membership levels.
     *
     * @param accountId Your account identifier (pathVariable)
     * @return Collection of membership levels.
     * @throws HttpException provides exception descriptions
     *                       <ul>
     *                          <li>400 On invalid parameters. See error details in response body.</li>
     *                          <li>401 oAuth token was not provided, invalid or does not provide access to requested URL</li>
     *                          <li>429 Too many requests from same account. Wait for a minute and try again, however this exception is handled, will automatically wait for 1 minutes, and then do another call.</li>
     *                       </ul>
     */
    public List<MembershipLevel> getAllMembershipLevels(
        Integer accountId
    ) throws HttpException {
        return this.applicationService.execute(
            "accounts/" + accountId + "/membershiplevels",
            new TypeReference<>() {
            }
        );
    }

    /**
     * Retrieve information about specific membership levels
     *
     * @param accountId Your account identifier (pathVariable)
     * @param levelId   Unique membership level identifier (pathVariable)
     * @return information about specific membership level
     * @throws HttpException provides exception descriptions
     *                       <ul>
     *                          <li>401 oAuth token was not provided, invalid or does not provide access to requested URL</li>
     *                           <li>404 Requested item not found</li>
     *                          <li>429 Too many requests from same account. Wait for a minute and try again, however this exception is handled, will automatically wait for 1 minutes, and then do another call.</li>
     *                       </ul>
     */
    public MembershipLevel getDetailsForMembershipLevel(
        Integer accountId,
        Integer levelId
    ) throws HttpException {
        return this.applicationService.execute(
            "accounts/" + accountId + "/membershiplevels/" + levelId,
            new TypeReference<>() {
            }
        );
    }
}
