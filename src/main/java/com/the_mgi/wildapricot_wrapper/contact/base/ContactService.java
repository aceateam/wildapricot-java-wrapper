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
import com.the_mgi.wildapricot_wrapper.contact.base.model.ContactsMe;
import com.the_mgi.wildapricot_wrapper.contact.base.model.ContactsResponse;
import com.the_mgi.wildapricot_wrapper.exception.HttpException;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.the_mgi.wildapricot_wrapper.base.util.UtilFunctions.convertBooleanToString;
import static com.the_mgi.wildapricot_wrapper.base.util.UtilFunctions.convertIntegerToString;

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

    /**
     * Retrieve information about the current contact
     *
     * @param accountId Your account identifier (pathVariable)
     * @return information about current contact
     * @throws HttpException provides exception descriptions
     *                       <ul>
     *                          <li>401 oAuth token was not provided, invalid or does not provide access to requested URL</li>
     *                          <li>404 Requested item not found</li>
     *                          <li>429 Too many requests from same account. Wait for a minute and try again, however this exception is handled, will automatically wait for 1 minutes, and then do another call.</li>
     *                       </ul>
     */
    public ContactsMe getInformationForCurrentContact(
        Integer accountId
    ) throws HttpException {
        return this.applicationService.execute(
            "accounts/" + accountId + "/contacts/me",
            new TypeReference<>() {
            }
        );
    }

    /**
     * Contacts search can be executed in synchronous and asynchronous manner. It depends on $async query string parameters.
     *
     * <h2>Synchronous call</h2>
     * <p>When API call is processing synchronously, then response is just an array of contacts.</p>
     * <p>To make a synchronous contacts search, client application should make a request with query string parameter $async=false.</p>
     * <p><a href="https://api.wildapricot.org/v2/accounts/{account_id}/contacts?$async=false&OTHER_QUERY_PARAMS">See Here</a></p>
     *
     * <h2>ASynchronous call</h2>
     * <p>Contacts search is processed asynchronously by default. So if client application specifies $async=true, or does not specify this parameter at all, the request is processed as described below. In this case contacts search is a two-step action.</p>
     * <ul>
     *     <li><strong>Search request: </strong>Client specifies search conditions and receives resultId. See $filter and $select parameters for filtering.</li>
     *     <li><strong>Retrieve result: </strong>Client passes resultId and receives request processing status and contacts list if request is already processed</li>
     * </ul>
     *
     * @param accountId   Your account identifier (pathVariable)
     * @param $async      Controls whether the API call is perform asynchronously. Default value if true. (query)
     * @param resultId    This parameter is used on a second step of asynchronous search. It should equal to the value of ResultId in response to the first step of asynchronous search. (query)
     * @param $filter     Filters the results of the Contacts API call so that only those records that match the filter criteria are included. (query)
     *                    see <a href="http://gethelp.wildapricot.com/en/articles/502#filtering">Filtering the results</a> for details (query)
     * @param $select     Controls which fields are returned in the Contacts API call. The field names correspond to the fields returned by the ContactFields API call, not the field names that appear in Wild Apricot. Multiple field names are separated by commas, and field names with spaces or special characters are enclosed in single quotation marks. (query)
     * @param $sort       Ordering expression. There are 2 sorting options - Name and MemberSince. And also 2 direction modifiers - asc and desc. (query)
     *                    Example of valid expression - MemberSince asc (query)
     * @param simpleQuery simpleQuery is a parameter which allows you to search for contacts by matching a substring in first name, last name, organization, email or phone. This is simpler than using $filter parameter. (query)
     * @param $skip       Specifies the number of records to skip (not include in a result set). For example if you expect about 300 records in result set and want to get them in small portions, you could make do so with 3 calls:' (query)
     *                    <ul> (query)
     *                        <li>...&$top=100 - will return records from 0 to 99 - ...?$skip=100&top=100' - will return records from 100 to 199 - ...?$skip=200' - will return records from 199 to the end</li>
     *                    </ul>
     * @param $top        this parameter specifies the maximum number of entries to be returned (query)
     * @param $count      Specifies that the result should contain only a total number of records matching criteria. Requests with specified $count parameter are always processed as synchronous. (query)
     * @param idsOnly     When idsOnly specified, the API returns only a list of identifiers matching criteria. (query)
     * @return A wrapper object, which contains a list of contacts, contact identifiers, contacts count or information about asynchronous search request.
     * @throws HttpException provides exception descriptions
     *                       <ul>
     *                          <li>400 On invalid parameters. See error details in response body.</li>
     *                          <li>401 oAuth token was not provided, invalid or does not provide access to requested URL</li>
     *                          <li>429 Too many requests from same account. Wait for a minute and try again, however this exception is handled, will automatically wait for 1 minutes, and then do another call.</li>
     *                       </ul>
     */
    public ContactsResponse getContactList(
        Integer accountId,
        Boolean $async,
        String resultId,
        String $filter,
        String $select,
        String $sort,
        String simpleQuery,
        Integer $skip,
        Integer $top,
        Boolean $count,
        Boolean idsOnly
    ) throws HttpException {
        return this.applicationService.execute(
            "accounts/" + accountId + "/contacts",
            new TypeReference<>() {
            },
            List.of(
                new Pair<>("$async", convertBooleanToString($async)),
                new Pair<>("resultId", resultId),
                new Pair<>("$filter", $filter),
                new Pair<>("$select", $select),
                new Pair<>("$sort", $sort),
                new Pair<>("simpleQuery", simpleQuery),
                new Pair<>("$skip", convertIntegerToString($skip)),
                new Pair<>("$top", convertIntegerToString($top)),
                new Pair<>("$count", convertBooleanToString($count)),
                new Pair<>("idsOnly", convertBooleanToString(idsOnly))
            )
        );
    }
}
