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

    public EventDetails setDescriptionHtml(String descriptionHtml) {
        this.descriptionHtml = descriptionHtml;
        return this;
    }

    public EventDetails setPaymentInstructions(String paymentInstructions) {
        this.paymentInstructions = paymentInstructions;
        return this;
    }

    public EventDetails setTimeZone(Timezone timeZone) {
        this.timeZone = timeZone;
        return this;
    }

    public EventDetails setRegistrationTypes(List<EventRegistrationType> registrationTypes) {
        this.registrationTypes = registrationTypes;
        return this;
    }

    public EventDetails setEventRegistrationFields(List<EventRegistrationFieldDescription> eventRegistrationFields) {
        this.eventRegistrationFields = eventRegistrationFields;
        return this;
    }

    public EventDetails setTotalPaid(Double totalPaid) {
        this.totalPaid = totalPaid;
        return this;
    }

    public EventDetails setTotalDue(Double totalDue) {
        this.totalDue = totalDue;
        return this;
    }

    public EventDetails setAccessControl(EventAccessControl accessControl) {
        this.accessControl = accessControl;
        return this;
    }

    public EventDetails setGuestRegistrationSettings(EventGuestRegistrationSettings guestRegistrationSettings) {
        this.guestRegistrationSettings = guestRegistrationSettings;
        return this;
    }

    public EventDetails setOrganizer(IdAndUrl organizer) {
        this.organizer = organizer;
        return this;
    }

    public EventDetails setPaymentMethod(EventPaymentMethodType paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    public EventDetails setRegistrationConfirmationExtraInfo(String registrationConfirmationExtraInfo) {
        this.registrationConfirmationExtraInfo = registrationConfirmationExtraInfo;
        return this;
    }

    public EventDetails setRegistrationMessage(String registrationMessage) {
        this.registrationMessage = registrationMessage;
        return this;
    }

    public EventDetails setSendEmailCopy(Boolean sendEmailCopy) {
        this.sendEmailCopy = sendEmailCopy;
        return this;
    }

    public EventDetails setWaitlistEnabled(Boolean waitlistEnabled) {
        isWaitlistEnabled = waitlistEnabled;
        return this;
    }

    public EventDetails setWaitlistSettings(EventWaitlistSettings waitlistSettings) {
        this.waitlistSettings = waitlistSettings;
        return this;
    }

    public EventDetails setMultipleRegistrationAllowed(Boolean multipleRegistrationAllowed) {
        this.multipleRegistrationAllowed = multipleRegistrationAllowed;
        return this;
    }

    public EventDetails setAttendeesDisplaySettings(EventAttendeeDisplaySettings attendeesDisplaySettings) {
        this.attendeesDisplaySettings = attendeesDisplaySettings;
        return this;
    }

    @Override
    public String toString() {
        return "EventDetails{" +
            "descriptionHtml='" + descriptionHtml + '\'' +
            ", paymentInstructions='" + paymentInstructions + '\'' +
            ", timeZone=" + timeZone +
            ", registrationTypes=" + registrationTypes +
            ", eventRegistrationFields=" + eventRegistrationFields +
            ", totalPaid=" + totalPaid +
            ", totalDue=" + totalDue +
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
