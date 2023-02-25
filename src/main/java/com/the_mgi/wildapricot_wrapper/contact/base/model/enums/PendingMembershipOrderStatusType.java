package com.the_mgi.wildapricot_wrapper.contact.base.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.the_mgi.wildapricot_wrapper.exception.InvalidEnumValueException;

public enum PendingMembershipOrderStatusType {
    INVISIBLE("Invisible"),
    PENDING_NO_CORRESPONDING_INVOICE("PendingNoCorrespondingInvoice"),
    PENDING_NOT_PAID_YET("PendingNotPaidYet"),
    INVOICE_PAID_MANUAL_APPROVAL_REQUIRED("InvoicePaidManualApprovalRequired"),
    FREE_ORDER_MANUAL_APPROVAL_REQUIRED("FreeOrderManualApprovalRequired"),
    INVOICE_NOT_PAID_BUT_OPERATION_APPROVED("InvoiceNotPaidButOperationApproved"),
    MULTIPLE_INVOICE_NOT_PAID_MEMBER_ACTIVATED("MultipleInvoiceNotPaidMemberActivated"),
    MULTIPLE_INVOICE_NOT_PAID_MEMBER_PENDING("MultipleInvoiceNotPaidMemberPending");

    private final String value;

    PendingMembershipOrderStatusType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    public static PendingMembershipOrderStatusType getEnumTypeFromString(String value) {
        for (PendingMembershipOrderStatusType type : PendingMembershipOrderStatusType.values()) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }
        throw new InvalidEnumValueException("Invalid Enum value provided", PendingMembershipOrderStatusType.class);
    }

    @JsonCreator
    public static PendingMembershipOrderStatusType create(String value) {
        return getEnumTypeFromString(value);
    }

    @Override
    public String toString() {
        return "PendingMembershipOrderStatusType{" +
               "value='" + value + '\'' +
               "} " + super.toString();
    }
}
