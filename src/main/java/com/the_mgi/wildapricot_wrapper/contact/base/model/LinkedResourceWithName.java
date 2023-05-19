package com.the_mgi.wildapricot_wrapper.contact.base.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Objects;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class LinkedResourceWithName {
    /**
     * Unique search identifier
     */
    @JsonProperty("Id")
    private String id;

    /**
     * API url to get item details
     */
    @JsonProperty("Url")
    private String url;

    /**
     * Resource name
     */
    @JsonProperty("Name")
    private String name;

    public LinkedResourceWithName setId(String id) {
        this.id = id;
        return this;
    }

    public LinkedResourceWithName setUrl(String url) {
        this.url = url;
        return this;
    }

    public LinkedResourceWithName setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LinkedResourceWithName that = (LinkedResourceWithName) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "LinkedResourceWithName{" +
               "id='" + id + '\'' +
               ", url='" + url + '\'' +
               ", name='" + name + '\'' +
               '}';
    }
}
