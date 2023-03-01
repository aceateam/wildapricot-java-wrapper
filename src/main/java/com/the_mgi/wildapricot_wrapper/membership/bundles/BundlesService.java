package com.the_mgi.wildapricot_wrapper.membership.bundles;

import com.fasterxml.jackson.core.type.TypeReference;
import com.the_mgi.wildapricot_wrapper.ApplicationService;
import com.the_mgi.wildapricot_wrapper.WildApricot;
import com.the_mgi.wildapricot_wrapper.base.model.Pair;
import com.the_mgi.wildapricot_wrapper.exception.HttpException;
import com.the_mgi.wildapricot_wrapper.membership.bundles.model.Bundle;

import java.util.List;

public class BundlesService {
    private final ApplicationService applicationService;

    public BundlesService(WildApricot wildApricot) {
        this.applicationService = ApplicationService.getInstance(wildApricot);
    }

    /**
     * Get list of membership bundles
     *
     * @param accountId Your account identifier (pathVariable)
     * @param levelId   Provide this parameter to get only bundles related to specific membership level. (query)
     * @return List of bundles matching query parameters.
     * @throws HttpException provides exception descriptions
     *                       <ul>
     *                          <li>400 On invalid parameters. See error details in response body.</li>
     *                          <li>401 oAuth token was not provided, invalid or does not provide access to requested URL</li>
     *                          <li>429 Too many requests from same account. Wait for a minute and try again, however this exception is handled, will automatically wait for 1 minutes, and then do another call.</li>
     *                       </ul>
     */
    public List<Bundle> getListOfMembershipBundles(
        Integer accountId,
        Integer levelId
    ) throws HttpException {
        return this.applicationService.execute(
            "accounts/" + accountId + "/bundles",
            new TypeReference<>() {
            },
            List.of(new Pair<>("levelId", levelId == null ? null : Integer.toString(levelId)))
        );
    }

    /**
     * Get list of membership bundles
     *
     * @param accountId Your account identifier (pathVariable)
     * @return List of bundles matching query parameters.
     * @throws HttpException provides exception descriptions
     *                       <ul>
     *                          <li>400 On invalid parameters. See error details in response body.</li>
     *                          <li>401 oAuth token was not provided, invalid or does not provide access to requested URL</li>
     *                          <li>404 Requested item not found.</li>
     *                          <li>429 Too many requests from same account. Wait for a minute and try again, however this exception is handled, will automatically wait for 1 minutes, and then do another call.</li>
     *                       </ul>
     */
    public Bundle getMembershipBundleDetails(
        Integer accountId,
        Integer bundleId
    ) throws HttpException {
        return this.applicationService.execute(
            "accounts/" + accountId + "/bundles/" + bundleId,
            new TypeReference<>() {
            }
        );
    }
}
