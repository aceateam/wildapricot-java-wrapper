package com.the_mgi.wildapricot_wrapper.events.base.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.the_mgi.wildapricot_wrapper.contact.custom_fields.model.ExtraChargeOptions;
import com.the_mgi.wildapricot_wrapper.contact.custom_fields.model.OptionsListItem;
import com.the_mgi.wildapricot_wrapper.contact.custom_fields.model.RulesAndTermsInfo;
import com.the_mgi.wildapricot_wrapper.contact.custom_fields.model.enums.FieldType;
import com.the_mgi.wildapricot_wrapper.events.base.model.enums.Kind;
import lombok.Getter;

import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventRegistrationFieldDescription {
    /**
     * Field name title, could be displayed in user interface. Field name could be changed by account administrator.
     */
    @JsonProperty("FieldName")
    private String fieldName;

    /**
     * System-defined code associated with field. It does not change even if FieldName is edited in admin backend.
     */
    @JsonProperty("SystemCode")
    private String systemCode;

    /**
     * Optional hint, which tells how to display and edit field. It appears for String and Choice fields.
     */
    @JsonProperty("DisplayType")
    private String DisplayType;

    /**
     * Field is system-defined and could not be deleted. However, field name could be changed by account administrator.
     */
    @JsonProperty("IsSystem")
    private Boolean isSystem;

    /**
     * System-defined description of the field. Empty for custom fields.
     */
    @JsonProperty("Description")
    private String description;

    /**
     * Admin-defined comment for the field. Shown as a tip when members or visitors fill in forms.
     */
    @JsonProperty("FieldInstructions")
    private String fieldInstructions;

    /**
     * If field value is limited to set of predefined values, this contains list of allowed values. Normally, AllowedValues appear for MultipleChoice and Choice fields.
     */
    @JsonProperty("AllowedValues")
    private List<OptionsListItem> allowedValues;

    /**
     * Sorting order to display the field in UI
     */
    @JsonProperty("Order")
    private Integer order;

    /**
     * Additional info for fields with rules / terms conditions. Not present for other field types.
     */
    @JsonProperty("RulesAndTermsInfo")
    private RulesAndTermsInfo rulesAndTermsInfo;

    /**
     * Custom field data type.
     */
    @JsonProperty("FieldType")
    private FieldType fieldType;

    /**
     * This property appears for CalculatedExtraCharge fields only.
     */
    @JsonProperty("ExtraCharge")
    private ExtraChargeOptions extraCharge;

    /**
     * Indicated is the field is common for all contacts or custom for the event.
     */
    @JsonProperty("Kind")
    private Kind kind;

    public EventRegistrationFieldDescription setFieldName(String fieldName) {
        this.fieldName = fieldName;
        return this;
    }

    public EventRegistrationFieldDescription setSystemCode(String systemCode) {
        this.systemCode = systemCode;
        return this;
    }

    public EventRegistrationFieldDescription setDisplayType(String displayType) {
        DisplayType = displayType;
        return this;
    }

    public EventRegistrationFieldDescription setSystem(Boolean system) {
        isSystem = system;
        return this;
    }

    public EventRegistrationFieldDescription setDescription(String description) {
        this.description = description;
        return this;
    }

    public EventRegistrationFieldDescription setFieldInstructions(String fieldInstructions) {
        this.fieldInstructions = fieldInstructions;
        return this;
    }

    public EventRegistrationFieldDescription setAllowedValues(List<OptionsListItem> allowedValues) {
        this.allowedValues = allowedValues;
        return this;
    }

    public EventRegistrationFieldDescription setOrder(Integer order) {
        this.order = order;
        return this;
    }

    public EventRegistrationFieldDescription setRulesAndTermsInfo(RulesAndTermsInfo rulesAndTermsInfo) {
        this.rulesAndTermsInfo = rulesAndTermsInfo;
        return this;
    }

    public EventRegistrationFieldDescription setFieldType(FieldType fieldType) {
        this.fieldType = fieldType;
        return this;
    }

    public EventRegistrationFieldDescription setExtraCharge(ExtraChargeOptions extraCharge) {
        this.extraCharge = extraCharge;
        return this;
    }

    public EventRegistrationFieldDescription setKind(Kind kind) {
        this.kind = kind;
        return this;
    }

    @Override
    public String toString() {
        return "EventRegistrationFieldDescription{" +
               "fieldName='" + fieldName + '\'' +
               ", systemCode='" + systemCode + '\'' +
               ", DisplayType='" + DisplayType + '\'' +
               ", isSystem=" + isSystem +
               ", description='" + description + '\'' +
               ", fieldInstructions='" + fieldInstructions + '\'' +
               ", allowedValues=" + allowedValues +
               ", order=" + order +
               ", rulesAndTermsInfo=" + rulesAndTermsInfo +
               ", fieldType=" + fieldType +
               ", extraCharge=" + extraCharge +
               ", kind=" + kind +
               '}';
    }
}
