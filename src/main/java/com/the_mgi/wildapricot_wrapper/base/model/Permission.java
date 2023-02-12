package com.the_mgi.wildapricot_wrapper.base.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class Permission {
    @JsonProperty("AccountId")
    private Integer accountId;

    @JsonProperty("AvailableScopes")
    private List<String> availableScopes;

    @JsonProperty("SecurityProfileId")
    private Long securityProfileId;

    public Permission setAccountId(Integer accountId) {
        this.accountId = accountId;
        return this;
    }

    public Permission setAvailableScopes(List<String> availableScopes) {
        this.availableScopes = availableScopes;
        return this;
    }

    public Permission setSecurityProfileId(Long securityProfileId) {
        this.securityProfileId = securityProfileId;
        return this;
    }
}
