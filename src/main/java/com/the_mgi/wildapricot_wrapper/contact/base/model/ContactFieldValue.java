package com.the_mgi.wildapricot_wrapper.contact.base.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.the_mgi.wildapricot_wrapper.contact.base.model.enums.CustomAccessLevel;
import lombok.Getter;

import java.util.Objects;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactFieldValue {
    /**
     * Field title. Custom field names are defined by account adinistrator. System field names are predefined by Wild Apricot system.
     */
    @JsonProperty("FieldName")
    private String fieldName;

    /**
     * The system code is a unique field identifier that can be used instead of the field name to identify the field. While field name could be changed by administrators, system codes are defined by the system and cannot be changed.
     */
    @JsonProperty("SystemCode")
    private String systemCode;

    /**
     * Field value could be an integer / string / date in ISO8601 format / boolean / an object consisting of Id and Label or array of such objects. The content format depends on custom field description.
     */
    @JsonProperty("Value")
    private Object Value;

    /**
     * Indicates who is allowed to view the field value. - Public - value is visible to anyone who has access to members directory - Members - value is visible only to members - *Nobody - value is visible only to account administrators
     */
    @JsonProperty("CustomAccessLevel")
    private CustomAccessLevel accessLevel;

    public ContactFieldValue setFieldName(String fieldName) {
        this.fieldName = fieldName;
        return this;
    }

    public ContactFieldValue setSystemCode(String systemCode) {
        this.systemCode = systemCode;
        return this;
    }

    public ContactFieldValue setValue(Object value) {
        Value = value;
        return this;
    }

    public ContactFieldValue setAccessLevel(CustomAccessLevel accessLevel) {
        this.accessLevel = accessLevel;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactFieldValue that = (ContactFieldValue) o;

        return Objects.equals(systemCode, that.systemCode);
    }

    @Override
    public int hashCode() {
        return systemCode != null ? systemCode.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ContactFieldValue{" +
               "fieldName='" + fieldName + '\'' +
               ", systemCode='" + systemCode + '\'' +
               ", Value=" + Value +
               ", accessLevel=" + accessLevel +
               '}';
    }
}
