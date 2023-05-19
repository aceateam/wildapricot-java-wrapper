package com.the_mgi.wildapricot_wrapper.contact.base.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.the_mgi.wildapricot_wrapper.contact.base.model.enums.Status;
import lombok.Getter;

import java.util.Objects;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactsMe {
    /**
     * Contact unique identifier.
     */
    @JsonProperty("Id")
    private String id;

    /**
     * Permanent resource URL in API.
     */
    @JsonProperty("Url")
    private String url;

    /**
     * Combination of names or organization or email. Value depends on presence of values. It could be used to display contact record on lists.
     */
    @JsonProperty("DisplayName")
    private String displayName;

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
     * Contact primary email, shortcut for custom field value with system code 'Email'. Should be unique in account.
     */
    @JsonProperty("Email")
    private String emailAddress;

    /**
     * Shortcut for custom field value with system code 'Organization'
     */
    @JsonProperty("Organization")
    private String organization;

    /**
     * The status of the contact's membership. The status is only included in the results if the contact is a member.
     */
    @JsonProperty("Status")
    private Status status;

    /**
     * Information about current membership level assigned to the contact. If the contact is not a member, then the MembershipLevel field is not included in the results.
     */
    @JsonProperty("MembershipLevel")
    private MembershipLevel membershipLevel;

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

    public ContactsMe setId(String id) {
        this.id = id;
        return this;
    }

    public ContactsMe setUrl(String url) {
        this.url = url;
        return this;
    }

    public ContactsMe setDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public ContactsMe setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactsMe setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactsMe setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public ContactsMe setOrganization(String organization) {
        this.organization = organization;
        return this;
    }

    public ContactsMe setStatus(Status status) {
        this.status = status;
        return this;
    }

    public ContactsMe setMembershipLevel(MembershipLevel membershipLevel) {
        this.membershipLevel = membershipLevel;
        return this;
    }

    public ContactsMe setAccountAdministrator(Boolean accountAdministrator) {
        isAccountAdministrator = accountAdministrator;
        return this;
    }

    public ContactsMe setTermsOfUseAccepted(Boolean termsOfUseAccepted) {
        this.termsOfUseAccepted = termsOfUseAccepted;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactsMe that = (ContactsMe) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ContactsMe{" +
               "id='" + id + '\'' +
               ", url='" + url + '\'' +
               ", displayName='" + displayName + '\'' +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", emailAddress='" + emailAddress + '\'' +
               ", organization='" + organization + '\'' +
               ", status=" + status +
               ", membershipLevel=" + membershipLevel +
               ", isAccountAdministrator=" + isAccountAdministrator +
               ", termsOfUseAccepted=" + termsOfUseAccepted +
               '}';
    }
}
