package com.the_mgi.wildapricot_wrapper.contact.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.the_mgi.wildapricot_wrapper.contact.converters.PendingMembershipOrderStatusTypeConverter;
import com.the_mgi.wildapricot_wrapper.contact.model.enums.PendingMembershipOrderStatusType;
import lombok.Getter;

import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExtendedMembershipInfo {
    @JsonProperty("PendingMembershipOrderStatusType")
    @JsonDeserialize(converter = PendingMembershipOrderStatusTypeConverter.class)
    private PendingMembershipOrderStatusType type;

    /**
     * Link to unpaid invoice, related to pending membership application.
     */
    @JsonProperty("PendingMembershipInvoice")
    private PendingMembershipInvoice pendingMembershipInvoice;

    /**
     * List of allowed actions related to contact. Each action is described with title and URL, which should be used in POST request.
     */
    @JsonProperty("AllowedActions")
    private List<LinkedResourceWithName> allowedActions;

    public ExtendedMembershipInfo setType(PendingMembershipOrderStatusType type) {
        this.type = type;
        return this;
    }

    public ExtendedMembershipInfo setPendingMembershipInvoice(PendingMembershipInvoice pendingMembershipInvoice) {
        this.pendingMembershipInvoice = pendingMembershipInvoice;
        return this;
    }

    public ExtendedMembershipInfo setAllowedActions(List<LinkedResourceWithName> allowedActions) {
        this.allowedActions = allowedActions;
        return this;
    }

    @Override
    public String toString() {
        return "ExtendedMembershipInfo{" +
               "type=" + type +
               ", pendingMembershipInvoice=" + pendingMembershipInvoice +
               ", allowedActions=" + allowedActions +
               '}';
    }
}
