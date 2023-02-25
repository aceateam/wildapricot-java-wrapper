package com.the_mgi.wildapricot_wrapper.contact.base;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.the_mgi.wildapricot_wrapper.ApplicationService;
import com.the_mgi.wildapricot_wrapper.WildApricot;
import com.the_mgi.wildapricot_wrapper.base.annotation.FieldValue;
import com.the_mgi.wildapricot_wrapper.base.model.Pair;
import com.the_mgi.wildapricot_wrapper.base.util.ObjectMapperSingleton;
import com.the_mgi.wildapricot_wrapper.contact.base.model.ContactExtendedMembershipInfo;
import com.the_mgi.wildapricot_wrapper.contact.base.model.ContactFieldValue;
import com.the_mgi.wildapricot_wrapper.exception.HttpException;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public <T> T getInformationAboutContactParsed(
        Integer accountId,
        Integer contactId,
        Boolean isExtendedMembershipInfo,
        Class<T> aClass
    ) throws HttpException, IOException, IllegalAccessException {
        ContactExtendedMembershipInfo info = this.getInformationAboutContact(accountId, contactId, isExtendedMembershipInfo);
        ObjectMapper mapper = ObjectMapperSingleton.getObjectMapper();
        String jsonString = mapper.writeValueAsString(info);
        final Map<String, ContactFieldValue> map = new HashMap<>();
        info.getContactFieldValues().forEach(it -> map.put(it.getFieldName(), it));
        T finalObjectToReturn = mapper.readValue(jsonString, aClass);
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            FieldValue fieldValue = field.getAnnotation(FieldValue.class);
            if (fieldValue != null && map.containsKey(fieldValue.key())) {
                String mainKey = fieldValue.key();
                String nestedKey = fieldValue.nestedValueKey();
                Object value = map.get(mainKey).getValue();

                if (StringUtils.isNotBlank(nestedKey)) {
                    JsonNode node = mapper.readTree(mapper.writeValueAsString(value));
                    JsonNode nodeValue = node.get(nestedKey);
                    if (nodeValue != null) {
                        field.set(finalObjectToReturn, nodeValue.textValue());
                    }
                } else {
                    field.set(finalObjectToReturn, mapper.readValue(mapper.writeValueAsString(value), field.getType()));
                }
            }
        }

        return finalObjectToReturn;
    }
}
