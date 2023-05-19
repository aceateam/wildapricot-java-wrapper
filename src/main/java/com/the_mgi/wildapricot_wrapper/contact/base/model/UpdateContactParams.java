package com.the_mgi.wildapricot_wrapper.contact.base.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.the_mgi.wildapricot_wrapper.contact.base.model.enums.Status;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateContactParams {
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

    /**
     * Unique contact identifier
     */
    @JsonProperty("Id")
    private Integer id;

    public UpdateContactParams setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UpdateContactParams setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UpdateContactParams setOrganization(String organization) {
        this.organization = organization;
        return this;
    }

    public UpdateContactParams setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public UpdateContactParams setMembershipLevelId(MembershipLevelId membershipLevelId) {
        this.membershipLevelId = membershipLevelId;
        return this;
    }

    public UpdateContactParams setMembershipEnabled(Boolean membershipEnabled) {
        isMembershipEnabled = membershipEnabled;
        return this;
    }

    public UpdateContactParams setStatus(Status status) {
        this.status = status;
        return this;
    }

    public UpdateContactParams setPassword(String password) {
        this.password = password;
        return this;
    }

    public UpdateContactParams setFieldValues(List<FieldValue> fieldValues) {
        this.fieldValues = fieldValues;
        return this;
    }

    public UpdateContactParams setRecreateInvoice(Boolean recreateInvoice) {
        this.recreateInvoice = recreateInvoice;
        return this;
    }

    public UpdateContactParams setId(Integer id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UpdateContactParams that = (UpdateContactParams) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "UpdateContactParams{" +
               "firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", organization='" + organization + '\'' +
               ", emailAddress='" + emailAddress + '\'' +
               ", membershipLevelId=" + membershipLevelId +
               ", isMembershipEnabled=" + isMembershipEnabled +
               ", status=" + status +
               ", fieldValues=" + fieldValues +
               ", recreateInvoice=" + recreateInvoice +
               ", id='" + id + '\'' +
               '}';
    }
}
