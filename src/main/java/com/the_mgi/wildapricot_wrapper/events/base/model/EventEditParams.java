package com.the_mgi.wildapricot_wrapper.events.base.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.the_mgi.wildapricot_wrapper.contact.base.converters.DateConverter;
import com.the_mgi.wildapricot_wrapper.events.base.model.enums.EventType;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventEditParams {
    /**
     * Unique identifier of event. This field should be provided only when updating existing event.
     */
    @JsonProperty("Id")
    private Integer id;

    /**
     * Event title
     */
    @JsonProperty("Name")
    private String name;

    /**
     * Indicates if event is simple (RSVP) or regular.
     */
    @JsonProperty("EventType")
    private EventType eventType;

    /**
     * Date and time when the event is scheduled to start. If no time offset is specified, counts as UTC and will be converted into event timezone.
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
     * Date and time when the event is scheduled to end. Could be empty. If no time offset is specified, counts as UTC and will be converted into event timezone.
     */
    @JsonProperty("EndDate")
    @JsonDeserialize(converter = DateConverter.class)
    private Date endDate;

    /**
     * Indicates if event end time is specified. False means that EndDate contains only date component.
     */
    @JsonProperty("EndTimeSpecified")
    private Boolean endTimeSpecified;

    /**
     * Location where the event will take place.
     */
    @JsonProperty("Location")
    private String location;

    /**
     * Indicates whether registration to this event is enabled
     */
    @JsonProperty("RegistrationEnabled")
    private Boolean registrationEnabled;

    /**
     * A collection of tags associated with the event.
     */
    @JsonProperty("Tags")
    private List<String> tags;

    /**
     * Event details
     */
    @JsonProperty("Details")
    private EventDetailsEditParams details;

    /**
     * Collection of event sessions. Exist in multisessions events only.
     */
    @JsonProperty("Sessions")
    private List<Session> sessions;

    /**
     * Maximum number of registrations for this event.
     */
    @JsonProperty("RegistrationsLimit")
    private Integer registrationsLimit;

}
