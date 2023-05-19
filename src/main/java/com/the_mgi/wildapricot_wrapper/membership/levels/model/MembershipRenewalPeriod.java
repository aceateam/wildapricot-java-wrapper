package com.the_mgi.wildapricot_wrapper.membership.levels.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.the_mgi.wildapricot_wrapper.membership.levels.model.enums.MembershipRenewalPeriodKind;
import lombok.Getter;

import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MembershipRenewalPeriod {
    /**
     * Period of renewal.
     */
    @JsonProperty("Kind")
    private MembershipRenewalPeriodKind kind;

    /**
     * Indicates if renewal period starts from join date. Otherwise, starts from dates specified in Dates field.
     */
    @JsonProperty("StartFromJoinDate")
    private Boolean startFromJoinDate;

    /**
     * Collection of renewal dates during a year.
     */
    @JsonProperty("Dates")
    private List<MembershipRenewalPeriodDate> dates;

    /**
     * Indicates if recurring payments will be charged automatically.
     */
    @JsonProperty("AutomaticRecurringPayments")
    private Boolean automaticRecurringPayments;

    /**
     * Application approval policy
     */
    @JsonProperty("ApplicationReview")
    private MembershipRenewalPeriodApplicationReview applicationReview;

    public MembershipRenewalPeriod setKind(MembershipRenewalPeriodKind kind) {
        this.kind = kind;
        return this;
    }

    public MembershipRenewalPeriod setStartFromJoinDate(Boolean startFromJoinDate) {
        this.startFromJoinDate = startFromJoinDate;
        return this;
    }

    public MembershipRenewalPeriod setDates(List<MembershipRenewalPeriodDate> dates) {
        this.dates = dates;
        return this;
    }

    public MembershipRenewalPeriod setAutomaticRecurringPayments(Boolean automaticRecurringPayments) {
        this.automaticRecurringPayments = automaticRecurringPayments;
        return this;
    }

    public MembershipRenewalPeriod setApplicationReview(MembershipRenewalPeriodApplicationReview applicationReview) {
        this.applicationReview = applicationReview;
        return this;
    }

    @Override
    public String toString() {
        return "MembershipRenewalPeriod{" +
               "kind=" + kind +
               ", startFromJoinDate=" + startFromJoinDate +
               ", dates=" + dates +
               ", automaticRecurringPayments=" + automaticRecurringPayments +
               ", applicationReview=" + applicationReview +
               '}';
    }
}
