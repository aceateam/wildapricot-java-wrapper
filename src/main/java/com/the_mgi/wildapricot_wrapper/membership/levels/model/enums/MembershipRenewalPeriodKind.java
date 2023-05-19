package com.the_mgi.wildapricot_wrapper.membership.levels.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.the_mgi.wildapricot_wrapper.exception.InvalidEnumValueException;

public enum MembershipRenewalPeriodKind {
    NEVER("Never"),
    MONTHLY("Monthly"),
    QUARTERLY("Quarterly"),
    TWICE_A_YEAR("TwiceAYear"),
    EVERY_N_YEARS("EveryNYears");

    private final String value;

    MembershipRenewalPeriodKind(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    public static MembershipRenewalPeriodKind getEnumTypeFromString(String value) {
        for (MembershipRenewalPeriodKind membershipRenewalPeriodKind : MembershipRenewalPeriodKind.values()) {
            if (membershipRenewalPeriodKind.getValue().equals(value)) {
                return membershipRenewalPeriodKind;
            }
        }
        throw new InvalidEnumValueException("Invalid Enum value provided", MembershipRenewalPeriodKind.class);
    }

    @JsonCreator
    public static MembershipRenewalPeriodKind create(String value) {
        return getEnumTypeFromString(value);
    }

    @Override
    public String toString() {
        return "MembershipRenewalPeriodKind{" +
               "value='" + value + '\'' +
               "} " + super.toString();
    }
}
