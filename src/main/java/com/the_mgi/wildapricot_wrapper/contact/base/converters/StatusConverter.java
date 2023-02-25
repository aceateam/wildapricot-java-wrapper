package com.the_mgi.wildapricot_wrapper.contact.base.converters;

import com.fasterxml.jackson.databind.util.StdConverter;
import com.the_mgi.wildapricot_wrapper.contact.base.model.enums.Status;

public class StatusConverter extends StdConverter<String, Status> {
    @Override
    public Status convert(String s) {
        return Status.getEnumTypeFromString(s);
    }
}
