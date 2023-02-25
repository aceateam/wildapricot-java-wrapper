package com.the_mgi.wildapricot_wrapper.contact.custom_fields.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.the_mgi.wildapricot_wrapper.exception.InvalidEnumValueException;

public enum FieldType {
    STRING("String"),
    DATE_TIME("DateTime"),
    BOOLEAN("Boolean"),
    CHOICE("Choice"),
    MULTIPLE_CHOICE("MultipleChoice"),
    NUMBER("Number"),
    SECTION_DIVIDER("SectionDivider"),
    CALCULATED_EXTRA_CHARGE("CalculatedExtraCharge"),
    PICTURE("Picture"),

    /**
     * Field was not <a href="https://app.swaggerhub.com/apis-docs/WildApricot/wild-apricot_public_api/7.24.0#/ContactFieldDescription">here</a>,
     * but added here
     */
    MULTILINE_TEXT("MultilineText"),

    /**
     * Field was not <a href="https://app.swaggerhub.com/apis-docs/WildApricot/wild-apricot_public_api/7.24.0#/ContactFieldDescription">here</a>,
     * but added here
     */
    RULES_AND_TERMS("RulesAndTerms"),

    /**
     * Field was not <a href="https://app.swaggerhub.com/apis-docs/WildApricot/wild-apricot_public_api/7.24.0#/ContactFieldDescription">here</a>,
     * but added here
     */
    TEXT("Text"),

    /**
     * Field was not <a href="https://app.swaggerhub.com/apis-docs/WildApricot/wild-apricot_public_api/7.24.0#/ContactFieldDescription">here</a>,
     * but added here
     */
    RADIO_BUTTON("RadioButton"),

    /**
     * Field was not <a href="https://app.swaggerhub.com/apis-docs/WildApricot/wild-apricot_public_api/7.24.0#/ContactFieldDescription">here</a>,
     * but added here
     */
    RADIO_BUTTONS("RadioButtons"),

    /**
     * Field was not <a href="https://app.swaggerhub.com/apis-docs/WildApricot/wild-apricot_public_api/7.24.0#/ContactFieldDescription">here</a>,
     * but added here
     */
    MULTIPLE_CHOICE_W_EXTRA_CHARGE("MultipleChoiceWithExtraCharge"),

    /**
     * Field was not <a href="https://app.swaggerhub.com/apis-docs/WildApricot/wild-apricot_public_api/7.24.0#/ContactFieldDescription">here</a>,
     * but added here
     */
    DROPDOWN("Dropdown"),

    /**
     * Field was not <a href="https://app.swaggerhub.com/apis-docs/WildApricot/wild-apricot_public_api/7.24.0#/ContactFieldDescription">here</a>,
     * but added here
     */
    DATE("Date"),

    /**
     * Field was not <a href="https://app.swaggerhub.com/apis-docs/WildApricot/wild-apricot_public_api/7.24.0#/ContactFieldDescription">here</a>,
     * but added here
     */
    FILE_ATTACHMENT("FileAttachment");

    private final String value;

    FieldType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    public static FieldType getEnuTypeFromString(String value) {
        for (FieldType fieldType : FieldType.values()) {
            if (fieldType.getValue().equals(value)) {
                return fieldType;
            }
        }
        throw new InvalidEnumValueException("Invalid Enum value provided", FieldType.class);
    }

    @JsonCreator
    public static FieldType create(String value) {
        return getEnuTypeFromString(value);
    }

    @Override
    public String toString() {
        return "FieldType{" +
               "value='" + value + '\'' +
               "} " + super.toString();
    }
}
