package com.the_mgi.wildapricot_wrapper.contact.custom_fields.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.the_mgi.wildapricot_wrapper.contact.custom_fields.model.enums.Access;
import com.the_mgi.wildapricot_wrapper.contact.custom_fields.model.enums.FieldType;
import com.the_mgi.wildapricot_wrapper.contact.custom_fields.model.enums.MemberAccess;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactFieldDescription {
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
    private String displayType;

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
     * Unique search identifier
     */
    @JsonProperty("Id")
    private Integer id;

    /**
     * ContactFieldAccessLevel
     * <p>Indicates who is allowed to view the field value. - Public - value is visible to anyone who has access to members directory - Members - value is visible only to members - *Nobody - value is visible only to account administrators</p>
     */
    @JsonProperty("Access")
    private Access access;

    /**
     * Indicates that the field is accessible only by administrators.
     */
    @JsonProperty("AdminOnly")
    private Boolean adminOnly;

    /**
     * If field is defined for specific levels only, this contains list of membership levels.
     */
    @JsonProperty("ExistsInLevels")
    private List<LinkedResource> existsInLevels;

    /**
     * Controls whether the member is allowed to view or modify this field. Only for member fields.
     */
    @JsonProperty("MemberAccess")
    private MemberAccess memberAccess;

    /**
     * Indicates whether the field is a membership field.
     */
    @JsonProperty("MemberOnly")
    private Boolean memberOnly;

    /**
     * The field is a built-in system field, it cannot be edited or deleted.
     */
    @JsonProperty("IsBuiltIn")
    private Boolean isBuiltIn;

    /**
     * Indicates that this field can be used in $filter expression in contact search.
     */
    @JsonProperty("SupportSearch")
    private Boolean supportSearch;

    /**
     * Indicates that the field's value can be changed with create/update requests. Otherwise value canâ€™t be edited through API. If non-editable field value is provided in create/update contact request, the value is ignored by API.
     */
    @JsonProperty("IsEditable")
    private Boolean isEditable;

    /**
     * Defines how system manages field during renewal process. Used only by multichoice fields with an associated cost.
     */
    @JsonProperty("RenewalPolicy")
    private RenewalPolicy renewalPolicy;

    /**
     * If the field has associated cost, this indicates if the cost should be prorated over a partial period of time.
     */
    @JsonProperty("ProrateInApplication")
    private Boolean prorateInApplication;

    public ContactFieldDescription setFieldName(String fieldName) {
        this.fieldName = fieldName;
        return this;
    }

    public ContactFieldDescription setSystemCode(String systemCode) {
        this.systemCode = systemCode;
        return this;
    }

    public ContactFieldDescription setDisplayType(String displayType) {
        this.displayType = displayType;
        return this;
    }

    public ContactFieldDescription setSystem(Boolean system) {
        isSystem = system;
        return this;
    }

    public ContactFieldDescription setDescription(String description) {
        this.description = description;
        return this;
    }

    public ContactFieldDescription setFieldInstructions(String fieldInstructions) {
        this.fieldInstructions = fieldInstructions;
        return this;
    }

    public ContactFieldDescription setAllowedValues(List<OptionsListItem> allowedValues) {
        this.allowedValues = allowedValues;
        return this;
    }

    public ContactFieldDescription setOrder(Integer order) {
        this.order = order;
        return this;
    }

    public ContactFieldDescription setRulesAndTermsInfo(RulesAndTermsInfo rulesAndTermsInfo) {
        this.rulesAndTermsInfo = rulesAndTermsInfo;
        return this;
    }

    public ContactFieldDescription setFieldType(FieldType fieldType) {
        this.fieldType = fieldType;
        return this;
    }

    public ContactFieldDescription setExtraCharge(ExtraChargeOptions extraCharge) {
        this.extraCharge = extraCharge;
        return this;
    }

    public ContactFieldDescription setId(Integer id) {
        this.id = id;
        return this;
    }

    public ContactFieldDescription setAccess(Access access) {
        this.access = access;
        return this;
    }

    public ContactFieldDescription setAdminOnly(Boolean adminOnly) {
        this.adminOnly = adminOnly;
        return this;
    }

    public ContactFieldDescription setExistsInLevels(List<LinkedResource> existsInLevels) {
        this.existsInLevels = existsInLevels;
        return this;
    }

    public ContactFieldDescription setMemberAccess(MemberAccess memberAccess) {
        this.memberAccess = memberAccess;
        return this;
    }

    public ContactFieldDescription setMemberOnly(Boolean memberOnly) {
        this.memberOnly = memberOnly;
        return this;
    }

    public ContactFieldDescription setBuiltIn(Boolean builtIn) {
        isBuiltIn = builtIn;
        return this;
    }

    public ContactFieldDescription setSupportSearch(Boolean supportSearch) {
        this.supportSearch = supportSearch;
        return this;
    }

    public ContactFieldDescription setEditable(Boolean editable) {
        isEditable = editable;
        return this;
    }

    public ContactFieldDescription setRenewalPolicy(RenewalPolicy renewalPolicy) {
        this.renewalPolicy = renewalPolicy;
        return this;
    }

    public ContactFieldDescription setProrateInApplication(Boolean prorateInApplication) {
        this.prorateInApplication = prorateInApplication;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactFieldDescription that = (ContactFieldDescription) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ContactFieldDescription{" +
               "fieldName='" + fieldName + '\'' +
               ", systemCode='" + systemCode + '\'' +
               ", displayType='" + displayType + '\'' +
               ", isSystem=" + isSystem +
               ", description=" + description +
               ", fieldInstructions=" + fieldInstructions +
               ", allowedValues=" + allowedValues +
               ", order=" + order +
               ", rulesAndTermsInfo=" + rulesAndTermsInfo +
               ", fieldType=" + fieldType +
               ", extraCharge=" + extraCharge +
               ", id=" + id +
               ", access=" + access +
               ", adminOnly=" + adminOnly +
               ", existsInLevels=" + existsInLevels +
               ", memberAccess=" + memberAccess +
               ", memberOnly=" + memberOnly +
               ", isBuiltIn=" + isBuiltIn +
               ", supportSearch=" + supportSearch +
               ", isEditable=" + isEditable +
               ", renewalPolicy=" + renewalPolicy +
               ", prorateInApplication=" + prorateInApplication +
               '}';
    }
}
