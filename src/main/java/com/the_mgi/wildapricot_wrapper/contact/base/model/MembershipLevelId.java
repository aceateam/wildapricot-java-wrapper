package com.the_mgi.wildapricot_wrapper.contact.base.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Objects;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MembershipLevelId {
    /**
     * ID of membership level to assign.
     */
    @JsonProperty("Id")
    private Integer id;

    public MembershipLevelId setId(Integer id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MembershipLevelId that = (MembershipLevelId) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "MembershipLevelId{" +
               "id='" + id + '\'' +
               '}';
    }
}
