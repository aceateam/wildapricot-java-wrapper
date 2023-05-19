package com.the_mgi.wildapricot_wrapper.contact.base.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.the_mgi.wildapricot_wrapper.contact.base.converters.DateConverter;
import com.the_mgi.wildapricot_wrapper.contact.base.model.enums.ProcessingState;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactsResponse {
    /**
     * Unique result identifier.
     */
    @JsonProperty("ResultId")
    private String resultId;

    /**
     * URL to check async result availability. We expect that client application will check this URL with some small delay (every 5 sec) until API returns a list of contacts or ProcessingState==Failed.
     */
    @JsonProperty("ResultUrl")
    private String resultUrl;

    /**
     * Date and time when the request was queued for processing.
     */
    @JsonProperty("Requested")
    @JsonDeserialize(converter = DateConverter.class)
    private Date requested;

    /**
     * Date and time when the request was processed.
     */
    @JsonProperty("Processed")
    @JsonDeserialize(converter = DateConverter.class)
    private Date processed;

    /**
     * Asynchronous request state. It starts from Waiting, then server process it. Request may end in one of final states: Complete or Failed.
     */
    @JsonProperty("ProcessingState")
    private ProcessingState processingState;

    @JsonProperty("InitialQuery")
    private InitialQuery initialQuery;

    /**
     * In case of error, provides description of error occured.
     */
    @JsonProperty("ErrorDetails")
    private String errorDetails;

    /**
     * List of contact identifiers that match request criteria. The field appears only if idsOnly parameter was passed in request.
     */
    @JsonProperty("ContactIdentifiers")
    private List<Integer> contactIdentifiers;

    /**
     * Number of contacts that match request criteria. This field appears only if $count parameter was passed in request.
     */
    @JsonProperty("Count")
    private Integer count;

    /**
     * List of contacts that match request criteria.
     */
    @JsonProperty("Contacts")
    private List<Contact> contacts;

    public ContactsResponse setResultId(String resultId) {
        this.resultId = resultId;
        return this;
    }

    public ContactsResponse setResultUrl(String resultUrl) {
        this.resultUrl = resultUrl;
        return this;
    }

    public ContactsResponse setRequested(Date requested) {
        this.requested = requested;
        return this;
    }

    public ContactsResponse setProcessed(Date processed) {
        this.processed = processed;
        return this;
    }

    public ContactsResponse setProcessingState(ProcessingState processingState) {
        this.processingState = processingState;
        return this;
    }

    public ContactsResponse setInitialQuery(InitialQuery initialQuery) {
        this.initialQuery = initialQuery;
        return this;
    }

    public ContactsResponse setErrorDetails(String errorDetails) {
        this.errorDetails = errorDetails;
        return this;
    }

    public ContactsResponse setContactIdentifiers(List<Integer> contactIdentifiers) {
        this.contactIdentifiers = contactIdentifiers;
        return this;
    }

    public ContactsResponse setCount(Integer count) {
        this.count = count;
        return this;
    }

    public ContactsResponse setContacts(List<Contact> contacts) {
        this.contacts = contacts;
        return this;
    }

    @Override
    public String toString() {
        return "ContactsResponse{" +
               "resultId='" + resultId + '\'' +
               ", resultUrl='" + resultUrl + '\'' +
               ", requested=" + requested +
               ", processed=" + processed +
               ", processingState=" + processingState +
               ", initialQuery=" + initialQuery +
               ", errorDetails='" + errorDetails + '\'' +
               ", contactIdentifiers=" + contactIdentifiers +
               ", count=" + count +
               ", contacts=" + contacts +
               '}';
    }
}
