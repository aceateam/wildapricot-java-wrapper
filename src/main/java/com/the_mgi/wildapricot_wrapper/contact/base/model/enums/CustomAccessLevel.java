package com.the_mgi.wildapricot_wrapper.contact.base.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import com.the_mgi.wildapricot_wrapper.exception.InvalidEnumValueException;

public enum CustomAccessLevel {
    PUBLIC("Public"),
    MEMBERS("Members"),
    NOBODY("Nobody");

    private final String value;

    CustomAccessLevel(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    public static CustomAccessLevel getEnumTypeFromString(String value) {
        for (CustomAccessLevel customAccessLevel: CustomAccessLevel.values()) {
            if (customAccessLevel.getValue().equals(value)) {
                return customAccessLevel;
            }
        }
        throw new InvalidEnumValueException("Invalid Enum value provided", CustomAccessLevel.class);
    }
}
