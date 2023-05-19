package com.the_mgi.wildapricot_wrapper.events.base.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.the_mgi.wildapricot_wrapper.base.GenericEnum;

public enum EventPaymentMethodType implements GenericEnum<EventPaymentMethodType, String> {
    UNDEFINED("Undefined"),
    ONLINE_AND_OFFLINE("OnlineAndOffline"),
    OFFLINE("Offline"),
    ONLINE("Online");

    private final String value;

    EventPaymentMethodType (String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @JsonCreator
    public static EventPaymentMethodType create(String value) {
        return GenericEnum.getEnumTypeFromString(EventPaymentMethodType.class, value);
    }

    @Override
    public String toString() {
        return "EventPaymentMethodType{" +
               "value='" + value + '\'' +
               "} " + super.toString();
    }
}
