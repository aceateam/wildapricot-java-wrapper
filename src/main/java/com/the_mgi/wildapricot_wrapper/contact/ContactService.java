package com.the_mgi.wildapricot_wrapper.contact;

import com.fasterxml.jackson.core.type.TypeReference;
import com.the_mgi.wildapricot_wrapper.ApplicationService;
import com.the_mgi.wildapricot_wrapper.WildApricot;
import com.the_mgi.wildapricot_wrapper.base.model.Pair;
import com.the_mgi.wildapricot_wrapper.contact.model.ContactExtendedMembershipInfo;
import com.the_mgi.wildapricot_wrapper.exception.HttpException;

import java.util.List;

public class ContactService {
    private final ApplicationService applicationService;

    public ContactService(WildApricot wildapricot) {
        this.applicationService = ApplicationService.getInstance(wildapricot);
    }

    /**
     * @param accountId                Your account identifier (pathVariable)
     * @param contactId                Unique contact identifier (pathVariable)
     * @param isExtendedMembershipInfo When GetExtendedMembershipInfo specified the API returns the information about membership order status, membership invoice and allowed actions for current member status. (query)
     * @return Information about specific member or contact
     * @throws HttpException provides exception descriptions
     *                       <ul>
     *                          <li>401 oAuth token was not provided, invalid or does not provide access to requested URL</li>
     *                          <li>404 Requested item not found</li>
     *                          <li>429 Too many requests from same account. Wait for a minute and try again, however this exception is handled, will automatically wait for 1 minutes, and then do another call.</li>
     *                       </ul>
     */
    public ContactExtendedMembershipInfo getInformationAboutContact(
        Integer accountId,
        Integer contactId,
        Boolean isExtendedMembershipInfo
    ) throws HttpException {
        if (isExtendedMembershipInfo == null) isExtendedMembershipInfo = false;
        return this.applicationService.execute(
            "accounts/" + accountId + "/contacts/" + contactId,
            new TypeReference<>() {
            },
            List.of(new Pair<>("getExtendedMembershipInfo", Boolean.toString(isExtendedMembershipInfo)))
        );
    }

    /**
     * Serving as an overload function, for isExtendedMembershipInfo as false
     * See {@link #getInformationAboutContact(Integer, Integer, Boolean)}
     */
    public ContactExtendedMembershipInfo getInformationAboutContact(
        Integer accountId,
        Integer contactId
    ) throws HttpException {
        return this.getInformationAboutContact(accountId, contactId, false);
    }
}
