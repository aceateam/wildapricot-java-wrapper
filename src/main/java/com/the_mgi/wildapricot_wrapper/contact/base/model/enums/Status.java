package com.the_mgi.wildapricot_wrapper.contact.base.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.the_mgi.wildapricot_wrapper.exception.InvalidEnumValueException;

public enum Status {
    ACTIVE("Active"),
    LAPSED("Lapsed"),
    PENDING_NEW("PendingNew"),
    PENDING_RENEWAL("PendingRenewal"),
    PENDING_UPGRADE("PendingUpgrade");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    public static Status getEnumTypeFromString(String value) {
        for (Status status: Status.values()) {
            if (status.getValue().equals(value)) {
                return status;
            }
        }
        throw new InvalidEnumValueException("Invalid Enum value provided", Status.class);
    }

    @JsonCreator
    public static Status create(String value) {
        return getEnumTypeFromString(value);
    }

    @Override
    public String toString() {
        return "Status{" +
               "value='" + value + '\'' +
               "} " + super.toString();
    }
}
