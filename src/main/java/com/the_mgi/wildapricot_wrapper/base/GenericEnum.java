package com.the_mgi.wildapricot_wrapper.base;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.the_mgi.wildapricot_wrapper.exception.InvalidEnumValueException;

import java.util.EnumSet;

public interface GenericEnum<T extends Enum<T>, R> {
    @JsonValue
    R getValue();

    @JsonCreator
    static <R, E extends Enum<E> & GenericEnum<E, R>> E getEnumTypeFromString(Class<E> aClass, R value) {
        for (E o : EnumSet.allOf(aClass)) {
            if (o.getValue().equals(value)) {
                return o;
            }
        }
        throw new InvalidEnumValueException("Invalid Enum value provided", aClass);
    }
}