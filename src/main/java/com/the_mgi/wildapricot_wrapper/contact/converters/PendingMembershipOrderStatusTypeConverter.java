package com.the_mgi.wildapricot_wrapper.contact.converters;

import com.fasterxml.jackson.databind.util.StdConverter;
import com.the_mgi.wildapricot_wrapper.contact.model.enums.PendingMembershipOrderStatusType;

public class PendingMembershipOrderStatusTypeConverter extends StdConverter<String, PendingMembershipOrderStatusType> {
    @Override
    public PendingMembershipOrderStatusType convert(String s) {
        return PendingMembershipOrderStatusType.getEnumTypeFromString(s);
    }
}
