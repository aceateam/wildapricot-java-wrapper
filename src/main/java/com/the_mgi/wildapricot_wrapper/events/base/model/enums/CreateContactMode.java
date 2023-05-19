package com.the_mgi.wildapricot_wrapper.events.base.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.the_mgi.wildapricot_wrapper.base.GenericEnum;

public enum CreateContactMode implements GenericEnum<CreateContactMode, String> {
    NEVER_CREATE_CONTACT("NeverCreateContact"),
    CREATE_CONTACT_FOR_ALL_GUESTS("CreateContactForAllGuests"),
    CREATE_CONTACT_FOR_GUEST_WITH_EMAIL("CreateContactForGuestsWithEmail");

    private final String value;

    CreateContactMode (String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @JsonCreator
    public static CreateContactMode create(String value) {
        return GenericEnum.getEnumTypeFromString(CreateContactMode.class, value);
    }

    @Override
    public String toString() {
        return "CreateContactMode{" +
               "value='" + value + '\'' +
               "} " + super.toString();
    }
}
