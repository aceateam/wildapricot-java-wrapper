package com.the_mgi.wildapricot_wrapper.contact.base.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.the_mgi.wildapricot_wrapper.contact.base.converters.DateConverter;
import com.the_mgi.wildapricot_wrapper.contact.base.model.enums.ProcessingState;
import lombok.Getter;

import java.util.Date;

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
}
