package com.the_mgi.wildapricot_wrapper.account.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {
    /**
     * Account unique identifier.
     */
    @JsonProperty("Id")
    private Integer id;

    /**
     * Permanent resource URL in API.
     */
    @JsonProperty("Url")
    private String url;

    /**
     * The account name. This corresponds to the organization name as it appears on the Organization details screen.
     */
    @JsonProperty("Name")
    private String name;

    /**
     * The primary domain name for the account.
     */
    @JsonProperty("PrimaryDomainName")
    private String primaryDomainName;

    @JsonProperty("IsFreeAccount")
    private Boolean isFreeAccount;

    /**
     * Collection of account-related resources.
     */
    @JsonProperty("Resources")
    private List<Resources> resources;

    /**
     * Details about limits on the number of contacts.
     */
    @JsonProperty("ContactLimitInfo")
    private ContactLimitInfo contactLimitInfo;

    /**
     * Details about account time zone
     */
    @JsonProperty("TimeZone")
    private Timezone timezone;

    @JsonProperty("Currency")
    private Currency currency;

    @JsonProperty("Localization")
    private Localization localization;

    /**
     * Settings for Square Register integration, used for mobile app
     */
    @JsonProperty("SquareRegisterSettings")
    private SquareRegisterSettings squareRegisterSettings;

    @JsonProperty("PaymentSettings")
    private PaymentSettings paymentSettings;

    /**
     * Current account billing plan.
     */
    @JsonProperty("BillingPlan")
    private BillingPlan billingPlan;

    public Account setId(Integer id) {
        this.id = id;
        return this;
    }

    public Account setUrl(String url) {
        this.url = url;
        return this;
    }

    public Account setName(String name) {
        this.name = name;
        return this;
    }

    public Account setPrimaryDomainName(String primaryDomainName) {
        this.primaryDomainName = primaryDomainName;
        return this;
    }

    public Account setFreeAccount(Boolean freeAccount) {
        isFreeAccount = freeAccount;
        return this;
    }

    public Account setResources(List<Resources> resources) {
        this.resources = resources;
        return this;
    }

    public Account setContactLimitInfo(ContactLimitInfo contactLimitInfo) {
        this.contactLimitInfo = contactLimitInfo;
        return this;
    }

    public Account setTimezone(Timezone timezone) {
        this.timezone = timezone;
        return this;
    }

    public Account setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public Account setLocalization(Localization localization) {
        this.localization = localization;
        return this;
    }

    public Account setSquareRegisterSettings(SquareRegisterSettings squareRegisterSettings) {
        this.squareRegisterSettings = squareRegisterSettings;
        return this;
    }

    public Account setPaymentSettings(PaymentSettings paymentSettings) {
        this.paymentSettings = paymentSettings;
        return this;
    }

    public Account setBillingPlan(BillingPlan billingPlan) {
        this.billingPlan = billingPlan;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        return Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Account{" +
               "id=" + id +
               ", url='" + url + '\'' +
               ", name='" + name + '\'' +
               ", primaryDomainName='" + primaryDomainName + '\'' +
               ", isFreeAccount=" + isFreeAccount +
               ", resources=" + resources +
               ", contactLimitInfo=" + contactLimitInfo +
               ", timezone=" + timezone +
               ", currency=" + currency +
               ", localization=" + localization +
               ", squareRegisterSettings=" + squareRegisterSettings +
               ", paymentSettings=" + paymentSettings +
               ", billingPlan=" + billingPlan +
               '}';
    }
}
