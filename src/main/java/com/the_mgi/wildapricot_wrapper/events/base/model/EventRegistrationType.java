package com.the_mgi.wildapricot_wrapper.events.base.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.the_mgi.wildapricot_wrapper.contact.base.converters.DateConverter;
import com.the_mgi.wildapricot_wrapper.contact.custom_fields.model.LinkedResource;
import com.the_mgi.wildapricot_wrapper.events.base.model.enums.EventRegistrationCancellationBehavior;
import com.the_mgi.wildapricot_wrapper.events.base.model.enums.EventRegistrationPolicy;
import com.the_mgi.wildapricot_wrapper.events.base.model.enums.EventRegistrationTypeAvailability;
import com.the_mgi.wildapricot_wrapper.events.base.model.enums.EventRegistrationUnavailabilityPolicy;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventRegistrationType {
    /**
     * Unique event registration type identifier.
     */
    @JsonProperty("Id")
    private String id;

    /**
     * Permanent resource URL in API.
     */
    @JsonProperty("Url")
    private String url;

    /**
     * Indicates whether this registration type is enabled
     */
    @JsonProperty("IsEnabled")
    private Boolean isEnabled;

    /**
     * Identifier of event related to the registration type.
     */
    @JsonProperty("EventId")
    private Integer eventId;

    /**
     * Registration type title.
     */
    @JsonProperty("Name")
    private String name;

    /**
     * Plain text description for the event registration type.
     */
    @JsonProperty("Description")
    private String description;

    /**
     * Base price registrant pays for this registration type.
     */
    @JsonProperty("BasePrice")
    private Double basePrice;

    /**
     * Price for each additional guest.
     */
    @JsonProperty("GuestPrice")
    private Double guestPrice;

    /**
     * Indicates whether account tax scope settings should be used to calculate final price.
     */
    @JsonProperty("UseTaxScopeSettings")
    private Boolean useTaxScopeSettings;

    /**
     * Indicates who the registration type is available to.
     */
    @JsonProperty("Availability")
    private EventRegistrationTypeAvailability availability;

    /**
     * Registration code required to apply for event with this registration type. This property has value only if Availability is CodeRequired.
     */
    @JsonProperty("RegistrationCode")
    private String registrationCode;

    /**
     * Which membership levels can apply for event. This property has value only if Availability is MembersOnly.
     */
    @JsonProperty("AvailableForMembershipLevels")
    private List<LinkedResource> availableForMembershipLevels;

    /**
     * This registration type is available starting from this date. Can be null.
     */
    @JsonProperty("AvailableFrom")
    @JsonDeserialize(converter = DateConverter.class)
    private Date availableFrom;

    /**
     * This registration type is available until this date. Can be null.
     */
    @JsonProperty("AvailableThrough")
    @JsonDeserialize(converter = DateConverter.class)
    private Date availableThrough;

    /**
     * Maximum number of registrants for this registration type.
     */
    @JsonProperty("MaximumRegistrantsCount")
    private Integer maximumRegistrantsCount;

    /**
     * Current number of registrants for this registration type.
     */
    @JsonProperty("CurrentRegistrantsCount")
    private Integer currentRegistrantsCount;

    /**
     * Describes how guests are registered. Allowed values are
     * <ul>
     *     <li>Disabled - guest registration is not allowed - NumberOfGuests - number of guests should be specified. - CollectContactDetails - contact information should be collected for each guest. - CollectFullInfo - full registration info should be collected for each guest.</li>
     * </ul>
     */
    @JsonProperty("GuestRegistrationPolicy")
    private EventRegistrationPolicy guestRegistrationPolicy;

    /**
     * Indicates what is displayed if the registration type is not available for a particular visitor.
     */
    @JsonProperty("UnavailabilityPolicy")
    private EventRegistrationUnavailabilityPolicy unavailabilityPolicy;

    /**
     * Indicates if it is possible for attendee to self-cancel event registration.
     */
    @JsonProperty("CancellationBehaviour")
    private EventRegistrationCancellationBehavior cancellationBehaviour;

    /**
     * In case if CancellationBehaviour = AllowUpToPeriodBeforeEvent, this field indicates the minimum number of days before the event that cancellations are allowed.
     */
    @JsonProperty("CancellationDaysBeforeEvent")
    private Integer cancellationDaysBeforeEvent;

    /**
     * Indicated if registrant should be added to waitlist if registrations have reached their limit.
     */
    @JsonProperty("IsWaitlistEnabled")
    private Boolean isWaitlistEnabled;

    public EventRegistrationType setId(String id) {
        this.id = id;
        return this;
    }

    public EventRegistrationType setUrl(String url) {
        this.url = url;
        return this;
    }

    public EventRegistrationType setEnabled(Boolean enabled) {
        isEnabled = enabled;
        return this;
    }

    public EventRegistrationType setEventId(Integer eventId) {
        this.eventId = eventId;
        return this;
    }

    public EventRegistrationType setName(String name) {
        this.name = name;
        return this;
    }

    public EventRegistrationType setDescription(String description) {
        this.description = description;
        return this;
    }

    public EventRegistrationType setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
        return this;
    }

    public EventRegistrationType setGuestPrice(Double guestPrice) {
        this.guestPrice = guestPrice;
        return this;
    }

    public EventRegistrationType setUseTaxScopeSettings(Boolean useTaxScopeSettings) {
        this.useTaxScopeSettings = useTaxScopeSettings;
        return this;
    }

    public EventRegistrationType setAvailability(EventRegistrationTypeAvailability availability) {
        this.availability = availability;
        return this;
    }

    public EventRegistrationType setRegistrationCode(String registrationCode) {
        this.registrationCode = registrationCode;
        return this;
    }

    public EventRegistrationType setAvailableForMembershipLevels(List<LinkedResource> availableForMembershipLevels) {
        this.availableForMembershipLevels = availableForMembershipLevels;
        return this;
    }

    public EventRegistrationType setAvailableFrom(Date availableFrom) {
        this.availableFrom = availableFrom;
        return this;
    }

    public EventRegistrationType setAvailableThrough(Date availableThrough) {
        this.availableThrough = availableThrough;
        return this;
    }

    public EventRegistrationType setMaximumRegistrantsCount(Integer maximumRegistrantsCount) {
        this.maximumRegistrantsCount = maximumRegistrantsCount;
        return this;
    }

    public EventRegistrationType setCurrentRegistrantsCount(Integer currentRegistrantsCount) {
        this.currentRegistrantsCount = currentRegistrantsCount;
        return this;
    }

    public EventRegistrationType setGuestRegistrationPolicy(EventRegistrationPolicy guestRegistrationPolicy) {
        this.guestRegistrationPolicy = guestRegistrationPolicy;
        return this;
    }

    public EventRegistrationType setUnavailabilityPolicy(EventRegistrationUnavailabilityPolicy unavailabilityPolicy) {
        this.unavailabilityPolicy = unavailabilityPolicy;
        return this;
    }

    public EventRegistrationType setCancellationBehaviour(EventRegistrationCancellationBehavior cancellationBehaviour) {
        this.cancellationBehaviour = cancellationBehaviour;
        return this;
    }

    public EventRegistrationType setCancellationDaysBeforeEvent(Integer cancellationDaysBeforeEvent) {
        this.cancellationDaysBeforeEvent = cancellationDaysBeforeEvent;
        return this;
    }

    public EventRegistrationType setWaitlistEnabled(Boolean waitlistEnabled) {
        isWaitlistEnabled = waitlistEnabled;
        return this;
    }
}
