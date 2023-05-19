package com.the_mgi.wildapricot_wrapper.events.base.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.the_mgi.wildapricot_wrapper.base.GenericEnum;

public enum VisibleTo implements GenericEnum<VisibleTo, String> {
    PUBLIC("Public"),
    MEMBERS("Members"),
    NOBODY("Nobody");

    private final String value;

    VisibleTo(String value) {
        this.value = value;
    }


    @Override
    public String getValue() {
        return this.value;
    }

    @JsonCreator
    public static VisibleTo create(String value) {
        return GenericEnum.getEnumTypeFromString(VisibleTo.class, value);
    }

    @Override
    public String toString() {
        return "VisibleTo{" +
            "value='" + value + '\'' +
            "} " + super.toString();
    }
}