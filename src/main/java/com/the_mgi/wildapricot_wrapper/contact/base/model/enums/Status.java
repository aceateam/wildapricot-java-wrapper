package com.the_mgi.wildapricot_wrapper.contact.base.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.the_mgi.wildapricot_wrapper.base.GenericEnum;

public enum Status implements GenericEnum<Status, String> {
    ACTIVE("Active"),
    LAPSED("Lapsed"),
    PENDING_NEW("PendingNew"),
    PENDING_RENEWAL("PendingRenewal"),
    PENDING_UPGRADE("PendingUpgrade");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @JsonCreator
    public static Status create(String value) {
        return GenericEnum.getEnumTypeFromString(Status.class, value);
    }

    @Override
    public String toString() {
        return "Status{" +
               "value='" + value + '\'' +
               "} " + super.toString();
    }
}
