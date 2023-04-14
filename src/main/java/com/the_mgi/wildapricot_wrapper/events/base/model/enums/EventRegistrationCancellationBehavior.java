package com.the_mgi.wildapricot_wrapper.events.base.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.the_mgi.wildapricot_wrapper.base.GenericEnum;

public enum EventRegistrationCancellationBehavior implements GenericEnum<EventRegistrationCancellationBehavior, String> {
    DO_NOT_ALLOW("DoNotAllow"),
    ALLOW_UP_O_PERIOD_BEFORE_EVENT("AllowUpToPeriodBeforeEvent"),
    ALLOW("Allow");

    private final String value;

    EventRegistrationCancellationBehavior(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @JsonCreator
    public static EventRegistrationCancellationBehavior create(String value) {
        return GenericEnum.getEnumTypeFromString(EventRegistrationCancellationBehavior.class, value);
    }

    @Override
    public String toString() {
        return "EventRegistrationCancellationBehavior{" +
               "value='" + value + '\'' +
               "} " + super.toString();
    }
}
