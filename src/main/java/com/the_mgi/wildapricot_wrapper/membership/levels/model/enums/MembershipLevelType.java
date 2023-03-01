package com.the_mgi.wildapricot_wrapper.membership.levels.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.the_mgi.wildapricot_wrapper.exception.InvalidEnumValueException;

public enum MembershipLevelType {
    INDIVIDUAL("Individual"),
    BUNDLE("Bundle");

    private final String value;

    MembershipLevelType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    public static MembershipLevelType getEnumTypeFromString(String value) {
        for (MembershipLevelType membershipLevelType : MembershipLevelType.values()) {
            if (membershipLevelType.getValue().equals(value)) {
                return membershipLevelType;
            }
        }
        throw new InvalidEnumValueException("Invalid Enum value provided", MembershipLevelType.class);
    }

    @JsonCreator
    public static MembershipLevelType create(String value) {
        return getEnumTypeFromString(value);
    }

    @Override
    public String toString() {
        return "MembershipLevelType{" +
               "value='" + value + '\'' +
               "} " + super.toString();
    }
}
