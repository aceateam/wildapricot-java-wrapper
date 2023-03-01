package com.the_mgi.wildapricot_wrapper.membership.groups.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MembershipGroup {
    /**
     * Unique search identifier
     */
    @JsonProperty("Id")
    private String id;

    /**
     * Saved search name
     */
    @JsonProperty("Name")
    private String name;

    /**
     * Save search description
     */
    @JsonProperty("Description")
    private String description;

    /**
     * Total count of group participants
     */
    @JsonProperty("ContactsCount")
    private Integer contactsCount;

    /**
     * Contact IDs of group participants.
     */
    @JsonProperty("ContactIds")
    private List<Integer> contactIds;

    public MembershipGroup setId(String id) {
        this.id = id;
        return this;
    }

    public MembershipGroup setName(String name) {
        this.name = name;
        return this;
    }

    public MembershipGroup setDescription(String description) {
        this.description = description;
        return this;
    }

    public MembershipGroup setContactsCount(Integer contactsCount) {
        this.contactsCount = contactsCount;
        return this;
    }

    public MembershipGroup setContactIds(List<Integer> contactIds) {
        this.contactIds = contactIds;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MembershipGroup that = (MembershipGroup) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "MembershipGroup{" +
               "id='" + id + '\'' +
               ", name='" + name + '\'' +
               ", description='" + description + '\'' +
               ", contactsCount=" + contactsCount +
               ", contactIds=" + contactIds +
               '}';
    }
}
