package com.the_mgi.wildapricot_wrapper.membership.groups.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Objects;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MembershipGroupListItem {
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

    public MembershipGroupListItem setId(String id) {
        this.id = id;
        return this;
    }

    public MembershipGroupListItem setName(String name) {
        this.name = name;
        return this;
    }

    public MembershipGroupListItem setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MembershipGroupListItem that = (MembershipGroupListItem) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "MembershipGroupListItem{" +
               "id='" + id + '\'' +
               ", name='" + name + '\'' +
               ", description='" + description + '\'' +
               '}';
    }
}
