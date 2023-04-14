package com.the_mgi.wildapricot_wrapper.events.base.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.the_mgi.wildapricot_wrapper.contact.base.converters.DateConverter;
import com.the_mgi.wildapricot_wrapper.events.base.model.enums.EventAccessLevel;
import com.the_mgi.wildapricot_wrapper.events.base.model.enums.EventType;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Event {
    /**
     * Unique event identifier
     */
    @JsonProperty("Id")
    private String id;

    /**
     * Permanent resource URL in API.
     */
    @JsonProperty("Url")
    private String url;

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
     * Date and time when the event is scheduled to start.
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

    /**
     * Location where the event will take place.
     */
    @JsonProperty("Location")
    private String location;

    /**
     * Indicates whether registration to this event is enabled
     */
    @JsonProperty("RegistrationEnabled")
    private Boolean registrationEnabled	;

    /**
     * Indicates that at least one registration type is enabled for this event.
     */
    @JsonProperty("HasEnabledRegistrationTypes")
    private Boolean hasEnabledRegistrationTypes;

    /**
     * Event AccessLevel
     */
    @JsonProperty("AccessLevel")
    private EventAccessLevel accessLevel;

    /**
     * A collection of tags associated with the event.
     */
    @JsonProperty("Tags")
    private List<String> tags;

    /**
     * Event Details
     */
    @JsonProperty("Details")
    private EventDetails details;

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

    /**
     * Statistics related to invitees to RSVP events.
     */
    @JsonProperty("InviteeStat")
    private InviteeStat inviteeStat;

    /**
     * Number of participants already registered for this event but not confirmed yet.
     */
    @JsonProperty("PendingRegistrationsCount")
    private Integer pendingRegistrationsCount;

    /**
     * Number of participants already registered for this event and already confirmed.
     */
    @JsonProperty("ConfirmedRegistrationsCount")
    private Integer confirmedRegistrationsCount;

    /**
     * Number of attendees already checked in on this event.
     */
    @JsonProperty("CheckedInAttendeesNumber")
    private Integer checkedInAttendeesNumber;

    public Event setId(String id) {
        this.id = id;
        return this;
    }

    public Event setUrl(String url) {
        this.url = url;
        return this;
    }

    public Event setName(String name) {
        this.name = name;
        return this;
    }

    public Event setEventType(EventType eventType) {
        this.eventType = eventType;
        return this;
    }

    public Event setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Event setStartTimeSpecified(Boolean startTimeSpecified) {
        this.startTimeSpecified = startTimeSpecified;
        return this;
    }

    public Event setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public Event setEndTimeSpecified(Boolean endTimeSpecified) {
        this.endTimeSpecified = endTimeSpecified;
        return this;
    }

    public Event setLocation(String location) {
        this.location = location;
        return this;
    }

    public Event setRegistrationEnabled(Boolean registrationEnabled) {
        this.registrationEnabled = registrationEnabled;
        return this;
    }

    public Event setHasEnabledRegistrationTypes(Boolean hasEnabledRegistrationTypes) {
        this.hasEnabledRegistrationTypes = hasEnabledRegistrationTypes;
        return this;
    }

    public Event setAccessLevel(EventAccessLevel accessLevel) {
        this.accessLevel = accessLevel;
        return this;
    }

    public Event setTags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public Event setDetails(EventDetails details) {
        this.details = details;
        return this;
    }

    public Event setSessions(List<Session> sessions) {
        this.sessions = sessions;
        return this;
    }

    public Event setRegistrationsLimit(Integer registrationsLimit) {
        this.registrationsLimit = registrationsLimit;
        return this;
    }

    public Event setInviteeStat(InviteeStat inviteeStat) {
        this.inviteeStat = inviteeStat;
        return this;
    }

    public Event setPendingRegistrationsCount(Integer pendingRegistrationsCount) {
        this.pendingRegistrationsCount = pendingRegistrationsCount;
        return this;
    }

    public Event setConfirmedRegistrationsCount(Integer confirmedRegistrationsCount) {
        this.confirmedRegistrationsCount = confirmedRegistrationsCount;
        return this;
    }

    public Event setCheckedInAttendeesNumber(Integer checkedInAttendeesNumber) {
        this.checkedInAttendeesNumber = checkedInAttendeesNumber;
        return this;
    }

    @Override
    public String toString() {
        return "Event{" +
            "id='" + id + '\'' +
            ", url='" + url + '\'' +
            ", name='" + name + '\'' +
            ", eventType=" + eventType +
            ", startDate=" + startDate +
            ", startTimeSpecified=" + startTimeSpecified +
            ", endDate=" + endDate +
            ", endTimeSpecified=" + endTimeSpecified +
            ", location='" + location + '\'' +
            ", registrationEnabled=" + registrationEnabled +
            ", hasEnabledRegistrationTypes=" + hasEnabledRegistrationTypes +
            ", accessLevel=" + accessLevel +
            ", tags=" + tags +
            ", details=" + details +
            ", sessions=" + sessions +
            ", registrationsLimit=" + registrationsLimit +
            ", inviteeStat=" + inviteeStat +
            ", pendingRegistrationsCount=" + pendingRegistrationsCount +
            ", confirmedRegistrationsCount=" + confirmedRegistrationsCount +
            ", checkedInAttendeesNumber=" + checkedInAttendeesNumber +
            '}';
    }
}
