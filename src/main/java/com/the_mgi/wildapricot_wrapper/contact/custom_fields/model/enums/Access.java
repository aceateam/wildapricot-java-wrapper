package com.the_mgi.wildapricot_wrapper.contact.custom_fields.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.the_mgi.wildapricot_wrapper.exception.InvalidEnumValueException;

public enum Access {
    PUBLIC("Public"),
    MEMBERS("Members"),
    NOBODY("Nobody");

    private final String value;

    Access(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    public static Access getEnumTypeFromString(String value) {
        for (Access access : Access.values()) {
            if (access.getValue().equals(value)) {
                return access;
            }
        }
        throw new InvalidEnumValueException("Invalid Enum value provided", Access.class);
    }

    @JsonCreator
    public static Access create(String value) {
        return getEnumTypeFromString(value);
    }

    @Override
    public String toString() {
        return "Access{" +
               "value='" + value + '\'' +
               "} " + super.toString();
    }
}
