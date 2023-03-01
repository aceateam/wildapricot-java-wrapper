package com.the_mgi.wildapricot_wrapper.membership.bundles.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.the_mgi.wildapricot_wrapper.base.util.IdAndUrl;
import com.the_mgi.wildapricot_wrapper.contact.custom_fields.model.LinkedResource;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bundle {
    /**
     * Unique bundle identifier.
     */
    @JsonProperty("Id")
    private String id;

    /**
     * Permanent resource URL in API.
     */
    @JsonProperty("Url")
    private String url;

    /**
     * Email of bundle administrator.
     */
    @JsonProperty("Email")
    private String emailAddress;

    /**
     * The number of members in the bundle.
     */
    @JsonProperty("ParticipantsCount")
    private Integer participantsCount;

    /**
     * Link to bundle administrator.
     */
    @JsonProperty("Administrator")
    private IdAndUrl administrator;

    /**
     * Link to membership level related to this bundle.
     */
    @JsonProperty("MembershipLevel")
    private IdAndUrl membershipLevel;

    /**
     * If bundle size is limited, then this field indicates number of vacant spaces left in the bundle.
     * <p>
     * here jsonKey "SpacesLeft" was specified in wildapricot, whereas in jsonResponse it is "SpaceLeft", so going w/ that right now.
     */
    @JsonProperty("SpaceLeft")
    private Integer SpacesLeft;

    /**
     * Collection of links to members of the bundle.
     */
    @JsonProperty("Members")
    private List<LinkedResource> members;

    public Bundle setId(String id) {
        this.id = id;
        return this;
    }

    public Bundle setUrl(String url) {
        this.url = url;
        return this;
    }

    public Bundle setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public Bundle setParticipantsCount(Integer participantsCount) {
        this.participantsCount = participantsCount;
        return this;
    }

    public Bundle setAdministrator(IdAndUrl administrator) {
        this.administrator = administrator;
        return this;
    }

    public Bundle setMembershipLevel(IdAndUrl membershipLevel) {
        this.membershipLevel = membershipLevel;
        return this;
    }

    public Bundle setSpacesLeft(Integer spacesLeft) {
        SpacesLeft = spacesLeft;
        return this;
    }

    public Bundle setMembers(List<LinkedResource> members) {
        this.members = members;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bundle bundle = (Bundle) o;

        return Objects.equals(id, bundle.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Bundle{" +
               "id='" + id + '\'' +
               ", url='" + url + '\'' +
               ", emailAddress='" + emailAddress + '\'' +
               ", participantsCount=" + participantsCount +
               ", administrator=" + administrator +
               ", membershipLevel=" + membershipLevel +
               ", SpacesLeft=" + SpacesLeft +
               ", members=" + members +
               '}';
    }
}
