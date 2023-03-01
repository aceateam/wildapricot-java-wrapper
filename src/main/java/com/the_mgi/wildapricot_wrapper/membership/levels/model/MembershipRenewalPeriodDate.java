package com.the_mgi.wildapricot_wrapper.membership.levels.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MembershipRenewalPeriodDate {
    /**
     * Month of a year, 1-12
     * <ul>
     *     <li>minimum 1</li>
     *     <li>maximum 12</li>
     * </ul>
     */
    @JsonProperty("Month")
    private Integer month;

    /**
     * Day of a month
     * <ul>
     *     <li>minimum 1</li>
     *     <li>maximum 31</li>
     * </ul>
     */
    @JsonProperty("Day")
    private Integer day;

    public MembershipRenewalPeriodDate setMonth(Integer month) {
        this.month = month;
        return this;
    }

    public MembershipRenewalPeriodDate setDay(Integer day) {
        this.day = day;
        return this;
    }

    @Override
    public String toString() {
        return "MembershipRenewalPeriodDate{" +
               "month=" + month +
               ", day=" + day +
               '}';
    }
}