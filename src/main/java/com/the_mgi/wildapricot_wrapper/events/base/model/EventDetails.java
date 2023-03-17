package com.the_mgi.wildapricot_wrapper.events.base.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.the_mgi.wildapricot_wrapper.account.model.Timezone;
import com.the_mgi.wildapricot_wrapper.base.util.IdAndUrl;
import com.the_mgi.wildapricot_wrapper.events.base.model.enums.EventPaymentMethodType;
import lombok.Getter;

import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventDetails {
    /**
     * Full event description in HTML format. Important - Links to images can be relative.
     */
    @JsonProperty("DescriptionHtml")
    private String descriptionHtml;

    /**
     * A description how registrant can pay for attendance to this event. Payment instructions for this event only.
     */
    @JsonProperty("PaymentInstructions")
    private String paymentInstructions;

    /**
     * Details about account time zone
     */
    @JsonProperty("TimeZone")
    private Timezone timeZone;

    /**
     * Collection of configured registration types for the event.
     */
    @JsonProperty("RegistrationTypes")
    private List<EventRegistrationType> registrationTypes;

    /**
     * Collection of fields registrant should fill during registration process.
     */
    @JsonProperty("EventRegistrationFields")
    private List<EventRegistrationFieldDescription> eventRegistrationFields;

    /**
     * Total sum paid for all registrations to this event. This is a read-only property.
     */
    @JsonProperty("TotalPaid")
    private Double totalPaid;

    /**
     * Total sum due, but not necessarily paid yet for all registrations related to this event. This is a read-only property.
     */
    @JsonProperty("TotalDue")
    private Double totalDue;

    /**
     * Describes event availability.
     */
    @JsonProperty("AccessControl")
    private EventAccessControl accessControl;

    /**
     * Control how system works with guest registrations for specific event.
     */
    @JsonProperty("GuestRegistrationSettings")
    private EventGuestRegistrationSettings guestRegistrationSettings;

    /**
     * Link to contact who is designated as organizer for this event.
     */
    @JsonProperty("Organizer")
    private IdAndUrl organizer;

    /**
     * How attendees can pay for the ticket.
     */
    @JsonProperty("PaymentMethod")
    private EventPaymentMethodType paymentMethod;

    /**
     * Additional event information to be inserted in registration confirmation email
     */
    @JsonProperty("RegistrationConfirmationExtraInfo")
    private String registrationConfirmationExtraInfo;

    /**
     * This text will be shown above Register button on Event details
     */
    @JsonProperty("RegistrationMessage")
    private String registrationMessage;

    /**
     * Indicates if email copy should be sent according to email routing settings.
     */
    @JsonProperty("SendEmailCopy")
    private Boolean sendEmailCopy;

    /**
     * Indicates if waitlist feature is enabled for the event.
     */
    @JsonProperty("IsWaitlistEnabled")
    private Boolean isWaitlistEnabled;
}
