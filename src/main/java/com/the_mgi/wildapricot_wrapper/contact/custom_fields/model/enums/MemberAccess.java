package com.the_mgi.wildapricot_wrapper.contact.custom_fields.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.the_mgi.wildapricot_wrapper.exception.InvalidEnumValueException;

public enum MemberAccess {
    EDIT_IN_PROFILE_AND_IN_APPLICATION("EditInProfileAndInApplicationForm"),
    EDIT_IN_PROFILE("EditInProfile"),
    EDIT_IN_APPLICATION_FORM("EditInApplicationForm"),
    VIEW_ONLY("ViewOnly"),
    NOBODY("Nobody");

    private final String value;

    MemberAccess(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    public static MemberAccess getEnumTypeFromString(String value) {
        for (MemberAccess memberAccess : MemberAccess.values()) {
            if (memberAccess.getValue().equals(value)) {
                return memberAccess;
            }
        }
        throw new InvalidEnumValueException("Invalid Enum value provided", MemberAccess.class);
    }

    @JsonCreator
    public static MemberAccess create(String value) {
        return getEnumTypeFromString(value);
    }

    @Override
    public String toString() {
        return "MemberAccess{" +
               "value='" + value + '\'' +
               "} " + super.toString();
    }
}
