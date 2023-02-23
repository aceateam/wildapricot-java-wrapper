package com.the_mgi.wildapricot_wrapper.account.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.the_mgi.wildapricot_wrapper.account.model.enums.AllowedOperations;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Resources {
    /**
     * Permanent resource URL in API.
     */
    @JsonProperty("Url")
    private String url;

    /**
     * Name of resource
     */
    @JsonProperty("Name")
    private String name;

    /**
     * Text description of the resource
     */
    @JsonProperty("Description")
    private String description;

    /**
     * Collection of allowed operations for this resource. Possible values are
     */
    @JsonProperty("AllowedOperations")
    private List<AllowedOperations> allowedOperations;

    public Resources setUrl(String url) {
        this.url = url;
        return this;
    }

    public Resources setName(String name) {
        this.name = name;
        return this;
    }

    public Resources setDescription(String description) {
        this.description = description;
        return this;
    }

    public Resources setAllowedOperations(List<AllowedOperations> allowedOperations) {
        this.allowedOperations = allowedOperations;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resources resources = (Resources) o;

        return Objects.equals(url, resources.url);
    }

    @Override
    public int hashCode() {
        return url != null ? url.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Resources{" +
               "url='" + url + '\'' +
               ", name='" + name + '\'' +
               ", description='" + description + '\'' +
               ", allowedOperations=" + allowedOperations +
               '}';
    }
}
