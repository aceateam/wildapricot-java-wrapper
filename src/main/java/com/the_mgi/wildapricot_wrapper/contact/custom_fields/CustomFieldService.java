package com.the_mgi.wildapricot_wrapper.contact.custom_fields;

import com.fasterxml.jackson.core.type.TypeReference;
import com.the_mgi.wildapricot_wrapper.ApplicationService;
import com.the_mgi.wildapricot_wrapper.WildApricot;
import com.the_mgi.wildapricot_wrapper.base.model.Pair;
import com.the_mgi.wildapricot_wrapper.contact.custom_fields.model.ContactFieldDescription;
import com.the_mgi.wildapricot_wrapper.exception.HttpException;

import java.util.List;

public class CustomFieldService {
    private final ApplicationService applicationService;

    public CustomFieldService(WildApricot wildApricot) {
        this.applicationService = ApplicationService.getInstance(wildApricot);
    }

    /**
     * This list contains a list of fields of 2 different types.
     *
     * <ul>
     *     <li>System fields are defined by Wild Apricot system and cannot be removed.</li>
     *     <li>Custom fields can be defined by administrator to store some data specific to your account.</li>
     * </ul>
     *
     * @param accountId           Your account identifier (pathVariable)
     * @param showSectionDividers Default value is false. Specifies whether section dividers also should be included in the response.
     * @return An array of contact field descriptions
     * @throws HttpException provides exception descriptions
     *                       <ul>
     *                          <li>401 oAuth token was not provided, invalid or does not provide access to requested URL</li>
     *                          <li>429 Too many requests from same account. Wait for a minute and try again, however this exception is handled, will automatically wait for 1 minutes, and then do another call.</li>
     *                       </ul>
     */
    public List<ContactFieldDescription> getAllCustomFields(
        Integer accountId,
        Boolean showSectionDividers
    ) throws HttpException {
        if (showSectionDividers == null) showSectionDividers = false;
        return this.applicationService.execute(
            "accounts/" + accountId + "/contactfields",
            new TypeReference<>() {
            },
            List.of(new Pair<>("showSectionDividers", showSectionDividers.toString()))
        );
    }

}
