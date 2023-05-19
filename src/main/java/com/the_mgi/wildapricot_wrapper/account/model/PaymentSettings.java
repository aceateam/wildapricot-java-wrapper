package com.the_mgi.wildapricot_wrapper.account.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentSettings {
    /**
     * General payment instructions (shown on the Invoices & Payments page and Manual invoices)
     */
    @JsonProperty("GeneralPaymentInstructions")
    private String generalPaymentInstructions;

    /**
     * For event registrations (can be changed for each event)
     */
    @JsonProperty("EventPaymentInstructions")
    private String eventPaymentInstruction;

    /**
     * For membership applications, renewals and level changes
     */
    @JsonProperty("MembershipPaymentInstructions")
    private String membershipPaymentInstructions;

    public PaymentSettings setGeneralPaymentInstructions(String generalPaymentInstructions) {
        this.generalPaymentInstructions = generalPaymentInstructions;
        return this;
    }

    public PaymentSettings setEventPaymentInstruction(String eventPaymentInstruction) {
        this.eventPaymentInstruction = eventPaymentInstruction;
        return this;
    }

    public PaymentSettings setMembershipPaymentInstructions(String membershipPaymentInstructions) {
        this.membershipPaymentInstructions = membershipPaymentInstructions;
        return this;
    }

    @Override
    public String toString() {
        return "PaymentSettings{" +
               "generalPaymentInstructions='" + generalPaymentInstructions + '\'' +
               ", eventPaymentInstruction='" + eventPaymentInstruction + '\'' +
               ", membershipPaymentInstructions='" + membershipPaymentInstructions + '\'' +
               '}';
    }
}
