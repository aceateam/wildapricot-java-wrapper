package com.the_mgi.wildapricot_wrapper.contact.base.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.the_mgi.wildapricot_wrapper.contact.base.converters.DateConverter;
import com.the_mgi.wildapricot_wrapper.contact.base.converters.StatusConverter;
import com.the_mgi.wildapricot_wrapper.contact.base.model.enums.Status;
import lombok.Getter;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactExtendedMembershipInfo {
    /**
     * Unique search identifier
     */
    @JsonProperty("Id")
    private String id;

    /**
     * Permanent resource URL in API.
     */
    @JsonProperty("Url")
    private String url;

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

    /**
     * Combination of names or organization or email. Value depends on presence of values. It could be used to display contact record on lists.
     */
    @JsonProperty("DisplayName")
    private String displayName;

    /**
     * Timestamp of last contact details modification. Complies with ISO8601 format. The date and time that common fields, membership fields, or member group participation were last updated for the contact.
     */
    @JsonProperty("ProfileLastUpdated")
    @JsonDeserialize(converter = DateConverter.class)
    private Date profileLastUpdated;

    /**
     * Information about current membership level assigned to the contact. If the contact is not a member, then the MembershipLevel field is not included in the results.
     */
    @JsonProperty("MembershipLevel")
    private MembershipLevel membershipLevel;

    /**
     * Indicates whether the contact is a member. A value of false indicates that the contact is a not a member or is a suspended member.
     */
    @JsonProperty("MembershipEnabled")
    private Boolean isMembershipEnabled;

    /**
     * The status of the contact's membership. The status is only included in the results if the contact is a member.
     */
    @JsonProperty("Status")
    @JsonDeserialize(converter = StatusConverter.class)
    private Status status;

    @JsonProperty("ExtendedMembershipInfo")
    private ExtendedMembershipInfo extendedMembershipInfo;

    /**
     * Indicates if the contact is an account administrator.
     */
    @JsonProperty("IsAccountAdministrator")
    private Boolean isAccountAdministrator;

    /**
     * Indicates if the contact already accepted Wild Apricot's terms of use.
     */
    @JsonProperty("TermsOfUseAccepted")
    private Boolean termsOfUseAccepted;

    /**
     * For each custom field you have added to your Wild Apricot database, the name of the field, its system code, and its value for this contact are returned. The system code is a unique field identifier that can be used instead of the field name to identify the field. As well, a number of system fields are returned. If a custom field is restricted to certain access levels, then CustomAccessLevel indicates the level to which the field is restricted. Possible values are AdminOnly, Member, and Public.
     */
    @JsonProperty("FieldValues")
    private List<ContactFieldValue> contactFieldValues;

    public ContactExtendedMembershipInfo setId(String id) {
        this.id = id;
        return this;
    }

    public ContactExtendedMembershipInfo setUrl(String url) {
        this.url = url;
        return this;
    }

    public ContactExtendedMembershipInfo setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactExtendedMembershipInfo setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactExtendedMembershipInfo setOrganization(String organization) {
        this.organization = organization;
        return this;
    }

    public ContactExtendedMembershipInfo setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public ContactExtendedMembershipInfo setDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public ContactExtendedMembershipInfo setProfileLastUpdated(Date profileLastUpdated) {
        this.profileLastUpdated = profileLastUpdated;
        return this;
    }

    public ContactExtendedMembershipInfo setMembershipLevel(MembershipLevel membershipLevel) {
        this.membershipLevel = membershipLevel;
        return this;
    }

    public ContactExtendedMembershipInfo setMembershipEnabled(Boolean membershipEnabled) {
        isMembershipEnabled = membershipEnabled;
        return this;
    }

    public ContactExtendedMembershipInfo setStatus(Status status) {
        this.status = status;
        return this;
    }

    public ContactExtendedMembershipInfo setExtendedMembershipInfo(ExtendedMembershipInfo extendedMembershipInfo) {
        this.extendedMembershipInfo = extendedMembershipInfo;
        return this;
    }

    public ContactExtendedMembershipInfo setAccountAdministrator(Boolean accountAdministrator) {
        isAccountAdministrator = accountAdministrator;
        return this;
    }

    public ContactExtendedMembershipInfo setTermsOfUseAccepted(Boolean termsOfUseAccepted) {
        this.termsOfUseAccepted = termsOfUseAccepted;
        return this;
    }

    public ContactExtendedMembershipInfo setContactFieldValues(List<ContactFieldValue> contactFieldValues) {
        this.contactFieldValues = contactFieldValues;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactExtendedMembershipInfo that = (ContactExtendedMembershipInfo) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ContactExtendedMembershipInfo{" +
               "id='" + id + '\'' +
               ", url='" + url + '\'' +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", organization='" + organization + '\'' +
               ", emailAddress='" + emailAddress + '\'' +
               ", displayName='" + displayName + '\'' +
               ", profileLastUpdated=" + profileLastUpdated +
               ", membershipLevel=" + membershipLevel +
               ", isMembershipEnabled=" + isMembershipEnabled +
               ", status=" + status +
               ", extendedMembershipInfo=" + extendedMembershipInfo +
               ", isAccountAdministrator=" + isAccountAdministrator +
               ", termsOfUseAccepted=" + termsOfUseAccepted +
               ", contactFieldValues=" + contactFieldValues +
               '}';
    }
}
