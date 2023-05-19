package com.the_mgi.wildapricot_wrapper.events.base.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.the_mgi.wildapricot_wrapper.base.GenericEnum;

public enum Kind implements GenericEnum<Kind, String> {
    COMMON("Common"),
    CUSTOM("Custom");

    private final String value;

    Kind(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @JsonCreator
    public static Kind create(String value) {
        return GenericEnum.getEnumTypeFromString(Kind.class, value);
    }

    @Override
    public String toString() {
        return "Kind{" +
               "value='" + value + '\'' +
               "} " + super.toString();
    }
}
