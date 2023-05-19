package com.the_mgi.wildapricot_wrapper.account.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SquareRegisterSettings {
    /**
     * Is integration enabled in admin UI.
     */
    @JsonProperty("IntegrationEnabled")
    private Boolean integrationEnabled;

    /**
     * (optional) Square client Id
     */
    @JsonProperty("ClientId")
    private String clientId;

    public SquareRegisterSettings setIntegrationEnabled(Boolean integrationEnabled) {
        this.integrationEnabled = integrationEnabled;
        return this;
    }

    public SquareRegisterSettings setClientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    @Override
    public String toString() {
        return "SquareRegisterSettings{" +
               "integrationEnabled=" + integrationEnabled +
               ", clientId='" + clientId + '\'' +
               '}';
    }
}
