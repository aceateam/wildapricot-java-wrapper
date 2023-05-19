package com.the_mgi.wildapricot_wrapper.contact.saved_search.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SavedSearch {
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
     * Contact IDs found by Saved Search.
     */
    @JsonProperty("ContactIds")
    private List<Integer> contactIds;

    public SavedSearch setId(String id) {
        this.id = id;
        return this;
    }

    public SavedSearch setName(String name) {
        this.name = name;
        return this;
    }

    public SavedSearch setDescription(String description) {
        this.description = description;
        return this;
    }

    public SavedSearch setContactIds(List<Integer> contactIds) {
        this.contactIds = contactIds;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SavedSearch that = (SavedSearch) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "SavedSearch{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", contactIds=" + contactIds +
            '}';
    }
}
