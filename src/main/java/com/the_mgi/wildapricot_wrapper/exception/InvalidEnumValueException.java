package com.the_mgi.wildapricot_wrapper.exception;

public class InvalidEnumValueException extends RuntimeException {
    private final Class<?> aClass;

    public InvalidEnumValueException(String message, Class<?> aClass) {
        super(message);
        this.aClass = aClass;
    }

    @Override
    public String toString() {
        return "InvalidEnumValueException{" +
               "aClass=" + aClass.getName() +
               "} " + super.toString();
    }
}
