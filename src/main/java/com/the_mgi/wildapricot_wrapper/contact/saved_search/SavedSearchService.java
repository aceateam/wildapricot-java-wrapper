package com.the_mgi.wildapricot_wrapper.contact.saved_search;

import com.fasterxml.jackson.core.type.TypeReference;
import com.the_mgi.wildapricot_wrapper.ApplicationService;
import com.the_mgi.wildapricot_wrapper.WildApricot;
import com.the_mgi.wildapricot_wrapper.base.model.Pair;
import com.the_mgi.wildapricot_wrapper.contact.saved_search.models.SavedSearch;
import com.the_mgi.wildapricot_wrapper.contact.saved_search.models.SavedSearchListItem;
import com.the_mgi.wildapricot_wrapper.exception.HttpException;

import java.util.Arrays;
import java.util.List;

public class SavedSearchService {
    private final ApplicationService applicationService;

    public SavedSearchService(WildApricot wildApricot) {
        this.applicationService = ApplicationService.getInstance(wildApricot);
    }

    /**
     * List of Saved Searches
     *
     * @param accountId your account identifier (pathVariable)
     * @return An array of saved search descriptions
     * @throws HttpException provides exception descriptions
     *                       <ul>
     *                          <li>401 oAuth token was not provided, invalid or does not provide access to requested URL</li>
     *                          <li>429 Too many requests from same account. Wait for a minute and try again, however this exception is handled, will automatically wait for 1 minutes, and then do another call.</li>
     *                       </ul>
     */
    public List<SavedSearchListItem> listSavedSearches(Integer accountId) throws HttpException {
        return this.applicationService.execute(
            "accounts/" + accountId + "/savedsearches",
            new TypeReference<>() {
            }
        );
    }

    /**
     * Saved Search and found contacts
     *
     * @param accountId       your account identifier (pathVariable)
     * @param savedSearchId   Saved Search Identifier (pathVariable)
     * @param excludeArchived exclude archived contacts from found ContactIDs, Default value: false (query)
     * @param $filter         Filters the results of the Contacts API call so that only those records that match the filter criteria are included. See <a href="http://gethelp.wildapricot.com/en/articles/502#filtering">Filtering the results</a> for details.
     * @return Saved Search description and found contact IDs
     * @throws HttpException provides exception descriptions
     *                       <ul>
     *                          <li>401 oAuth token was not provided, invalid or does not provide access to requested URL</li>
     *                          <li>404 Requested item not found</li>
     *                          <li>429 Too many requests from same account. Wait for a minute and try again, however this exception is handled, will automatically wait for 1 minutes, and then do another call.</li>
     *                       </ul>
     */
    public SavedSearch listContactIDsInSavedSearch(
        Integer accountId,
        Integer savedSearchId,
        Boolean excludeArchived,
        String $filter
    ) throws HttpException {
        if (excludeArchived == null) excludeArchived = false;
        return this.applicationService.execute(
            "accounts/" + accountId + "/savedsearches/" + savedSearchId,
            new TypeReference<>() {
            },
            Arrays.asList(
                new Pair<>("excludeArchived", Boolean.toString(excludeArchived)),
                new Pair<>("$filter", $filter)
            )
        );
    }
}
