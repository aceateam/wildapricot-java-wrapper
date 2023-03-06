package com.the_mgi.wildapricot_wrapper.contact.base.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.the_mgi.wildapricot_wrapper.base.GenericEnum;

import static com.the_mgi.wildapricot_wrapper.base.GenericEnum.getEnumTypeFromString;

public enum ProcessingState implements GenericEnum<ProcessingState, String> {
    WAITING("Waiting"),
    PROCESSING("Processing"),
    COMPLETE("Complete"),
    FAILED("Failed");

    private final String value;

    ProcessingState(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @JsonCreator
    public static ProcessingState create(String value) {
        return getEnumTypeFromString(ProcessingState.class, value);
    }

    @Override
    public String toString() {
        return "ProcessingState{" +
               "value='" + value + '\'' +
               "} " + super.toString();
    }
}
