package com.the_mgi.wildapricot_wrapper.contact.custom_fields.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.the_mgi.wildapricot_wrapper.exception.InvalidEnumValueException;

public enum MultiplierType {
    ITEM_PRICE("ItemPrice"),
    PERCENTAGE("Percentage");

    private final String value;

    MultiplierType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    public static MultiplierType getEnumTypeFromString(String value) {
        for (MultiplierType multiplierType : MultiplierType.values()) {
            if (multiplierType.getValue().equals(value)) {
                return multiplierType;
            }
        }
        throw new InvalidEnumValueException("Invalid Enum value provided", MultiplierType.class);
    }

    @JsonCreator
    public static MultiplierType create(String value) {
        return getEnumTypeFromString(value);
    }

    @Override
    public String toString() {
        return "MultipleType{" +
               "value='" + value + '\'' +
               "} " + super.toString();
    }
}
