package com.the_mgi.wildapricot_wrapper.contact.base.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Objects;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FieldValue {
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
    private Object value;

    public FieldValue setFieldName(String fieldName) {
        this.fieldName = fieldName;
        return this;
    }

    public FieldValue setSystemCode(String systemCode) {
        this.systemCode = systemCode;
        return this;
    }

    public FieldValue setValue(Object value) {
        this.value = value;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FieldValue that = (FieldValue) o;

        if (!Objects.equals(fieldName, that.fieldName)) return false;
        return Objects.equals(systemCode, that.systemCode);
    }

    @Override
    public int hashCode() {
        int result = fieldName != null ? fieldName.hashCode() : 0;
        result = 31 * result + (systemCode != null ? systemCode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FieldValue{" +
               "fieldName='" + fieldName + '\'' +
               ", systemCode='" + systemCode + '\'' +
               ", value=" + value +
               '}';
    }
}
