package com.the_mgi.wildapricot_wrapper.events.base.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.the_mgi.wildapricot_wrapper.events.base.model.enums.CreateContactMode;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventGuestRegistrationSettings {
    /**
     * Indicates if guest registrations are allowed.
     */
    @JsonProperty("Enabled")
    private Boolean enabled;

    /**
     * Indicates whether guests are automatically added to database after the main registrant confirms the registration
     */
    @JsonProperty("CreateContactMode")
    private CreateContactMode createContactMode;

    public EventGuestRegistrationSettings setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public EventGuestRegistrationSettings setCreateContactMode(CreateContactMode createContactMode) {
        this.createContactMode = createContactMode;
        return this;
    }

    @Override
    public String toString() {
        return "EventGuestRegistrationSettings{" +
               "enabled=" + enabled +
               ", createContactMode=" + createContactMode +
               '}';
    }
}
