package com.the_mgi.wildapricot_wrapper.base.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UtilFunctions {
    public static String convertBooleanToString(Boolean b) {
        return b == null ? null : b.toString();
    }

    public static String convertIntegerToString(Integer integer) {
        return integer == null ? null : integer.toString();
    }

    public static String toJsonString(Object object) throws JsonProcessingException {
        if (object == null) return "";
        ObjectMapper mapper = ObjectMapperSingleton.getObjectMapper();
        return mapper.writeValueAsString(object);
    }
}
