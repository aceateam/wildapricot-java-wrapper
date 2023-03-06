package com.the_mgi.wildapricot_wrapper.base.util;

public class UtilFunctions {
    public static String convertBooleanToString(Boolean b) {
        return b == null ? null : b.toString();
    }

    public static String convertIntegerToString(Integer integer) {
        return integer == null ? null : integer.toString();
    }
}
