package com.the_mgi.wildapricot_wrapper.events.base.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.the_mgi.wildapricot_wrapper.account.model.Timezone;
import com.the_mgi.wildapricot_wrapper.base.util.IdAndUrl;
import com.the_mgi.wildapricot_wrapper.events.base.model.enums.EventPaymentMethodType;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventDetailsEditParams {
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

    @JsonProperty("WaitlistSettings")
    private EventWaitlistSettings waitlistSettings;

    /**
     * Indicates if multiple registrations are allowed for the same contact.
     */
    @JsonProperty("MultipleRegistrationAllowed")
    private Boolean multipleRegistrationAllowed;

    /**
     * Settings for section "List of event registrants" on UI.
     */
    @JsonProperty("AttendeesDisplaySettings")
    private EventAttendeeDisplaySettings attendeesDisplaySettings;

    public EventDetailsEditParams setDescriptionHtml(String descriptionHtml) {
        this.descriptionHtml = descriptionHtml;
        return this;
    }

    public EventDetailsEditParams setPaymentInstructions(String paymentInstructions) {
        this.paymentInstructions = paymentInstructions;
        return this;
    }

    public EventDetailsEditParams setTimeZone(Timezone timeZone) {
        this.timeZone = timeZone;
        return this;
    }

    public EventDetailsEditParams setAccessControl(EventAccessControl accessControl) {
        this.accessControl = accessControl;
        return this;
    }

    public EventDetailsEditParams setGuestRegistrationSettings(EventGuestRegistrationSettings guestRegistrationSettings) {
        this.guestRegistrationSettings = guestRegistrationSettings;
        return this;
    }

    public EventDetailsEditParams setOrganizer(IdAndUrl organizer) {
        this.organizer = organizer;
        return this;
    }

    public EventDetailsEditParams setPaymentMethod(EventPaymentMethodType paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    public EventDetailsEditParams setRegistrationConfirmationExtraInfo(String registrationConfirmationExtraInfo) {
        this.registrationConfirmationExtraInfo = registrationConfirmationExtraInfo;
        return this;
    }

    public EventDetailsEditParams setRegistrationMessage(String registrationMessage) {
        this.registrationMessage = registrationMessage;
        return this;
    }

    public EventDetailsEditParams setSendEmailCopy(Boolean sendEmailCopy) {
        this.sendEmailCopy = sendEmailCopy;
        return this;
    }

    public EventDetailsEditParams setWaitlistEnabled(Boolean waitlistEnabled) {
        isWaitlistEnabled = waitlistEnabled;
        return this;
    }

    public EventDetailsEditParams setWaitlistSettings(EventWaitlistSettings waitlistSettings) {
        this.waitlistSettings = waitlistSettings;
        return this;
    }

    public EventDetailsEditParams setMultipleRegistrationAllowed(Boolean multipleRegistrationAllowed) {
        this.multipleRegistrationAllowed = multipleRegistrationAllowed;
        return this;
    }

    public EventDetailsEditParams setAttendeesDisplaySettings(EventAttendeeDisplaySettings attendeesDisplaySettings) {
        this.attendeesDisplaySettings = attendeesDisplaySettings;
        return this;
    }

    @Override
    public String toString() {
        return "EventDetailsEditParams{" +
            "descriptionHtml='" + descriptionHtml + '\'' +
            ", paymentInstructions='" + paymentInstructions + '\'' +
            ", timeZone=" + timeZone +
            ", accessControl=" + accessControl +
            ", guestRegistrationSettings=" + guestRegistrationSettings +
            ", organizer=" + organizer +
            ", paymentMethod=" + paymentMethod +
            ", registrationConfirmationExtraInfo='" + registrationConfirmationExtraInfo + '\'' +
            ", registrationMessage='" + registrationMessage + '\'' +
            ", sendEmailCopy=" + sendEmailCopy +
            ", isWaitlistEnabled=" + isWaitlistEnabled +
            ", waitlistSettings=" + waitlistSettings +
            ", multipleRegistrationAllowed=" + multipleRegistrationAllowed +
            ", attendeesDisplaySettings=" + attendeesDisplaySettings +
            '}';
    }
}
