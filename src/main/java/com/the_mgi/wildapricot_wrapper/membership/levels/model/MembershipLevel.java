package com.the_mgi.wildapricot_wrapper.membership.levels.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.the_mgi.wildapricot_wrapper.contact.custom_fields.model.LinkedResource;
import com.the_mgi.wildapricot_wrapper.membership.levels.model.enums.MembershipLevelType;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MembershipLevel {
    /**
     * Unique membership level identifier
     */
    @JsonProperty("Id")
    private Integer id;

    /**
     * level name
     */
    @JsonProperty("Name")
    private String name;

    /**
     * level description
     */
    @JsonProperty("Description")
    private String description;

    /**
     * Indicates if non-member can apply for membership with this level.
     */
    @JsonProperty("PublicCanApply")
    private Boolean publicCanApply;

    /**
     * Indicates if membership level is individual or bundle.
     */
    @JsonProperty("Type")
    private MembershipLevelType type;

    /**
     * Maximum number of bundle members. Empty for individuals.
     */
    @JsonProperty("BundleMembersLimit")
    private Integer bundleMembersLimit;

    /**
     * Price of being a member with this level of membership. Price is for RenewalPeriod.
     */
    @JsonProperty("MembershipFee")
    private Double membershipFee;

    /**
     * Member can switch from current level to one of levels from this list.
     */
    @JsonProperty("MemberCanChangeToLevels")
    private List<LinkedResource> memberCanChangeToLevel;

    /**
     * Describes membership renewal period.
     */
    @JsonProperty("RenewalPeriod")
    private MembershipRenewalPeriod renewalPeriod;

    public MembershipLevel setId(Integer id) {
        this.id = id;
        return this;
    }

    public MembershipLevel setName(String name) {
        this.name = name;
        return this;
    }

    public MembershipLevel setDescription(String description) {
        this.description = description;
        return this;
    }

    public MembershipLevel setPublicCanApply(Boolean publicCanApply) {
        this.publicCanApply = publicCanApply;
        return this;
    }

    public MembershipLevel setType(MembershipLevelType type) {
        this.type = type;
        return this;
    }

    public MembershipLevel setBundleMembersLimit(Integer bundleMembersLimit) {
        this.bundleMembersLimit = bundleMembersLimit;
        return this;
    }

    public MembershipLevel setMembershipFee(Double membershipFee) {
        this.membershipFee = membershipFee;
        return this;
    }

    public MembershipLevel setMemberCanChangeToLevel(List<LinkedResource> memberCanChangeToLevel) {
        this.memberCanChangeToLevel = memberCanChangeToLevel;
        return this;
    }

    public MembershipLevel setRenewalPeriod(MembershipRenewalPeriod renewalPeriod) {
        this.renewalPeriod = renewalPeriod;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MembershipLevel that = (MembershipLevel) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "MembershipLevel{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", description='" + description + '\'' +
               ", publicCanApply=" + publicCanApply +
               ", type=" + type +
               ", bundleMembersLimit=" + bundleMembersLimit +
               ", membershipFee=" + membershipFee +
               ", memberCanChangeToLevel=" + memberCanChangeToLevel +
               ", renewalPeriod=" + renewalPeriod +
               '}';
    }
}
