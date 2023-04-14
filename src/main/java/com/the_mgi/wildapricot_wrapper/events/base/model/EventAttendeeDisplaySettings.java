package com.the_mgi.wildapricot_wrapper.events.base.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.the_mgi.wildapricot_wrapper.events.base.model.enums.VisibleTo;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventAttendeeDisplaySettings {
    /**
     * Indicates who is allowed to see list of event registrants.
     */
    @JsonProperty("VisibleTo")
    private VisibleTo visibleTo;

    /**
     * Indicates if pending registrants should be included in the list of registrants.
     */
    @JsonProperty("ShowPendingAttendees")
    private Boolean showPendingAttendees;

    public EventAttendeeDisplaySettings setVisibleTo(VisibleTo visibleTo) {
        this.visibleTo = visibleTo;
        return this;
    }

    public EventAttendeeDisplaySettings setShowPendingAttendees(Boolean showPendingAttendees) {
        this.showPendingAttendees = showPendingAttendees;
        return this;
    }

    @Override
    public String toString() {
        return "EventAttendeeDisplaySettings{" +
            "visibleTo=" + visibleTo +
            ", showPendingAttendees=" + showPendingAttendees +
            '}';
    }
}
