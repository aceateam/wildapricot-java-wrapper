package com.the_mgi.wildapricot_wrapper.contact.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.the_mgi.wildapricot_wrapper.contact.converters.DateConverter;
import com.the_mgi.wildapricot_wrapper.contact.converters.StatusConverter;
import com.the_mgi.wildapricot_wrapper.contact.model.enums.Status;
import lombok.Getter;

import java.util.Date;
import java.util.List;

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

}
