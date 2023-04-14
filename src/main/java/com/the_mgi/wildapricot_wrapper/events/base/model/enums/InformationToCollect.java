package com.the_mgi.wildapricot_wrapper.events.base.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.the_mgi.wildapricot_wrapper.base.GenericEnum;

public enum InformationToCollect implements GenericEnum<InformationToCollect, String> {
    NONE("None"),
    NAME_AND_EMAIL("NameAndEmail"),
    CONTACT_INFORMATION("ContactInformation"),
    REGISTRATION_INFORMATION("RegistrationInformation");

    private final String value;

    InformationToCollect(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @JsonCreator
    public static InformationToCollect create(String value) {
        return GenericEnum.getEnumTypeFromString(InformationToCollect.class, value);
    }

    @Override
    public String toString() {
        return "InformationToCollect{" +
            "value='" + value + '\'' +
            "} " + super.toString();
    }
}
