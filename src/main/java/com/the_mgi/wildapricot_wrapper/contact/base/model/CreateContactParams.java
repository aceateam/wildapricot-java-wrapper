package com.the_mgi.wildapricot_wrapper.contact.base.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.the_mgi.wildapricot_wrapper.contact.base.model.enums.Status;
import lombok.Getter;

import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateContactParams {
    /**
     * Shortcut for custom field value with system code 'FirstName'
     */
    @JsonProperty("FirstName")
    private String firstName;

    /**
     * Shortcut for custom field value with system code 'LastName'
     */
    @JsonProperty("LastName")
    private String lastName;

    /**
     * Shortcut for custom field value with system code 'Organization'
     */
    @JsonProperty("Organization")
    private String organization;

    /**
     * Contact primary email, shortcut for custom field value with system code 'Email'. Should be unique in account.
     */
    @JsonProperty("Email")
    private String emailAddress;

    @JsonProperty("MembershipLevel")
    private MembershipLevelId membershipLevelId;

    /**
     * Indicates whether the contact is a member. A value of false indicates that the contact is a not a member or is a suspended member.
     */
    @JsonProperty("MembershipEnabled")
    private Boolean isMembershipEnabled;

    /**
     * The status of the contact's membership. The status is only included in the results if the contact is a member.
     */
    @JsonProperty("Status")
    private Status status;

    /**
     * New password to assign. If you don't want to change password, just skip this field.
     */
    @JsonProperty("Password")
    private String password;

    /**
     * An array of field values to assign to contact.
     */
    @JsonProperty("FieldValues")
    private List<FieldValue> fieldValues;

    /**
     * Indicates whether to create invoice is required. Default value is TRUE
     */
    @JsonProperty("RecreateInvoice")
    private Boolean recreateInvoice;

    public CreateContactParams setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CreateContactParams setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CreateContactParams setOrganization(String organization) {
        this.organization = organization;
        return this;
    }

    public CreateContactParams setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public CreateContactParams setMembershipLevelId(MembershipLevelId membershipLevelId) {
        this.membershipLevelId = membershipLevelId;
        return this;
    }

    public CreateContactParams setMembershipEnabled(Boolean membershipEnabled) {
        isMembershipEnabled = membershipEnabled;
        return this;
    }

    public CreateContactParams setStatus(Status status) {
        this.status = status;
        return this;
    }

    public CreateContactParams setPassword(String password) {
        this.password = password;
        return this;
    }

    public CreateContactParams setFieldValues(List<FieldValue> fieldValues) {
        this.fieldValues = fieldValues;
        return this;
    }

    public CreateContactParams setRecreateInvoice(Boolean recreateInvoice) {
        this.recreateInvoice = recreateInvoice;
        return this;
    }

    @Override
    public String toString() {
        return "CreateContactParams{" +
               "firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", organization='" + organization + '\'' +
               ", emailAddress='" + emailAddress + '\'' +
               ", membershipLevelId=" + membershipLevelId +
               ", isMembershipEnabled=" + isMembershipEnabled +
               ", status=" + status +
               ", password='" + password + '\'' +
               ", fieldValues=" + fieldValues +
               ", recreateInvoice=" + recreateInvoice +
               '}';
    }
}
