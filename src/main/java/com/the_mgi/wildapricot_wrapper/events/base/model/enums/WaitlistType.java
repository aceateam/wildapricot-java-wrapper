package com.the_mgi.wildapricot_wrapper.events.base.model.enums;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.the_mgi.wildapricot_wrapper.base.GenericEnum;

/**
 * WaitlistType
 * <ul>
 *     <li>None - waitlist is not enabled</li>
 *     <li>Manual - people can be added to a waitlist and then automatically registered in the order they were added, as sufficient spaces open up</li>
 *     <li>Auto - people can be added to a waitlist and then manually registered by an administrator or by themselves once spaces become available</li>
 * </ul>
 */
public enum WaitlistType implements GenericEnum<WaitlistType, String> {
    NONE("None"),
    MANUAL("Manual"),
    AUTO("Auto");

    private final String value;

    WaitlistType(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @JsonCreator
    public static WaitlistType create(String value) {
        return GenericEnum.getEnumTypeFromString(WaitlistType.class, value);
    }

    @Override
    public String toString() {
        return "WaitlistType{" +
            "value='" + value + '\'' +
            "} " + super.toString();
    }
}
