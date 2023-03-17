package com.the_mgi.wildapricot_wrapper.events.base.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.the_mgi.wildapricot_wrapper.contact.custom_fields.model.LinkedResource;
import com.the_mgi.wildapricot_wrapper.events.base.model.enums.EventAccessLevel;
import lombok.Getter;

import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventAccessControl {
    /**
     * Event accessibility. for details please see {@link EventAccessLevel here}
     */
    @JsonProperty("AccessLevel")
    private EventAccessLevel accessLevel;

    /**
     * If AccessLevel is Restricted, then indicates if the event is available to any member on any level.
     */
    @JsonProperty("AvailableForAnyLevel")
    private Boolean availableForAnyLevel;

    /**
     * Event is available to members who are on these levels.
     * <br />
     * This field appears only if AccessLevel is Restricted and AvailableForAnyLevel is false.
     */
    @JsonProperty("AvailableForLevels")
    private List<LinkedResource> availableForLevels;

    /**
     * If AccessLevel is Restricted, then indicates if the event is available to any member in any membership group.
     */
    @JsonProperty("AvailableForAnyGroup")
    private Boolean availableForAnyGroup;

    /**
     * Event is available to members who are any of these groups.
     * <br />
     * This field appears only if AccessLevel is Restricted and AvailableForAnyGroup is false.
     */
    @JsonProperty("AvailableForGroups")
    private List<LinkedResource> availableForGroups;

    public EventAccessControl setAccessLevel(EventAccessLevel accessLevel) {
        this.accessLevel = accessLevel;
        return this;
    }

    public EventAccessControl setAvailableForAnyLevel(Boolean availableForAnyLevel) {
        this.availableForAnyLevel = availableForAnyLevel;
        return this;
    }

    public EventAccessControl setAvailableForLevels(List<LinkedResource> availableForLevels) {
        this.availableForLevels = availableForLevels;
        return this;
    }

    public EventAccessControl setAvailableForAnyGroup(Boolean availableForAnyGroup) {
        this.availableForAnyGroup = availableForAnyGroup;
        return this;
    }

    public EventAccessControl setAvailableForGroups(List<LinkedResource> availableForGroups) {
        this.availableForGroups = availableForGroups;
        return this;
    }

    @Override
    public String toString() {
        return "EventAccessControl{" +
               "accessLevel=" + accessLevel +
               ", availableForAnyLevel=" + availableForAnyLevel +
               ", availableForLevels=" + availableForLevels +
               ", availableForAnyGroup=" + availableForAnyGroup +
               ", availableForGroups=" + availableForGroups +
               '}';
    }
}
