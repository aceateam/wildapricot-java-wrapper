package com.the_mgi.wildapricot_wrapper.membership.levels.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MembershipRenewalPeriodApplicationReview {
    /**
     * If true, membership fee should be received in full before application is activated. Else, approved memberships activate immediately, regardless of payment status.
     */
    @JsonProperty("PrepayRequired")
    private Boolean prepayRequired;

    /**
     * <p>Indicates that account administrator should approve membership application.</p>
     * <p>False means that all applications are considered approved when they are submitted.</p>
     */
    @JsonProperty("AdminApprovalRequired")
    private Boolean adminApprovalRequired;

    public MembershipRenewalPeriodApplicationReview setPrepayRequired(Boolean prepayRequired) {
        this.prepayRequired = prepayRequired;
        return this;
    }

    public MembershipRenewalPeriodApplicationReview setAdminApprovalRequired(Boolean adminApprovalRequired) {
        this.adminApprovalRequired = adminApprovalRequired;
        return this;
    }

    @Override
    public String toString() {
        return "MembershipRenewalPeriodApplicationReview{" +
               "prepayRequired=" + prepayRequired +
               ", adminApprovalRequired=" + adminApprovalRequired +
               '}';
    }
}
