package com.the_mgi.wildapricot_wrapper.contact.custom_fields.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RenewalPolicy {
    /**
     * Indicates if the field should be shown in renewal form.
     */
    @JsonProperty("IncludeInRenewals")
    private Boolean includeInRenewals;

    /**
     * Indicates whether field value can be changed during renual process. Can be set to TRUE only if IncludeInRenewals is set to TRUE.
     */
    @JsonProperty("AllowedToChangeInRenewal")
    private Boolean allowedToChangeInRenewal;

    public RenewalPolicy setIncludeInRenewals(Boolean includeInRenewals) {
        this.includeInRenewals = includeInRenewals;
        return this;
    }

    public RenewalPolicy setAllowedToChangeInRenewal(Boolean allowedToChangeInRenewal) {
        this.allowedToChangeInRenewal = allowedToChangeInRenewal;
        return this;
    }

    @Override
    public String toString() {
        return "RenewalPolicy{" +
               "includeInRenewals=" + includeInRenewals +
               ", allowedToChangeInRenewal=" + allowedToChangeInRenewal +
               '}';
    }
}
