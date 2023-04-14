package com.the_mgi.wildapricot_wrapper.events.base.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.the_mgi.wildapricot_wrapper.contact.base.converters.DateConverter;
import lombok.Getter;

import java.util.Date;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Session {
    /**
     * Unique event session identifier.
     */
    @JsonProperty("Id")
    private String id;

    /**
     * Automatically generated session title.
     */
    @JsonProperty("Title")
    private String title;

    /**
     * Date and time when the event session is scheduled to start.
     */
    @JsonProperty("StartDate")
    @JsonDeserialize(converter = DateConverter.class)
    private Date startDate;

    /**
     * Indicates if event start time is specified. False means that StartDate contains only date component.
     */
    @JsonProperty("StartTimeSpecified")
    private Boolean startTimeSpecified;

    /**
     * Date and time when the event is scheduled to end. Could be empty.
     */
    @JsonProperty("EndDate")
    @JsonDeserialize(converter = DateConverter.class)
    private Date endDate;

    /**
     * Indicates if event end time is specified. False means that EndDate contains only date component.
     */
    @JsonProperty("EndTimeSpecified")
    private Boolean endTimeSpecified;

    public Session setId(String id) {
        this.id = id;
        return this;
    }

    public Session setTitle(String title) {
        this.title = title;
        return this;
    }

    public Session setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Session setStartTimeSpecified(Boolean startTimeSpecified) {
        this.startTimeSpecified = startTimeSpecified;
        return this;
    }

    public Session setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public Session setEndTimeSpecified(Boolean endTimeSpecified) {
        this.endTimeSpecified = endTimeSpecified;
        return this;
    }

    @Override
    public String toString() {
        return "Session{" +
            "id='" + id + '\'' +
            ", title='" + title + '\'' +
            ", startDate=" + startDate +
            ", startTimeSpecified=" + startTimeSpecified +
            ", endDate=" + endDate +
            ", endTimeSpecified=" + endTimeSpecified +
            '}';
    }
}
