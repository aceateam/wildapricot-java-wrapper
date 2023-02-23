package com.the_mgi.wildapricot_wrapper.account.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactLimitInfo {
    /**
     * Number of contacts currently in database (archived excluded)
     */
    @JsonProperty("CurrentContactsCount")
    private Integer currentContactsCount;

    /**
     * Maximum number of contacts allowed by billing plan.
     */
    @JsonProperty("BillingPlanContactsLimit")
    private Integer billingPlanContactsLimit;

    public ContactLimitInfo setCurrentContactsCount(Integer currentContactsCount) {
        this.currentContactsCount = currentContactsCount;
        return this;
    }

    public ContactLimitInfo setBillingPlanContactsLimit(Integer billingPlanContactsLimit) {
        this.billingPlanContactsLimit = billingPlanContactsLimit;
        return this;
    }

    @Override
    public String toString() {
        return "ContactLimitInfo{" +
               "currentContactsCount=" + currentContactsCount +
               ", billingPlanContactsLimit=" + billingPlanContactsLimit +
               '}';
    }
}
