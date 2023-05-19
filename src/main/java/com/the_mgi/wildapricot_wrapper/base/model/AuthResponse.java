package com.the_mgi.wildapricot_wrapper.base.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class AuthResponse {
    /**
     * The value you need to pass to the API
     */
    @JsonProperty("access_token")
    private String accessToken;


    @JsonProperty("token_type")
    private String tokenType;

    /**
     * The number of seconds the access_token will be valid
     */
    @JsonProperty("expires_in")
    private Integer expiresIn;

    /**
     * The token used to refresh the expired access_token
     */
    @JsonProperty("refresh_token")
    private String refreshToken;

    /**
     * List of available accounts and allowed operations for this access_token
     */
    @JsonProperty("Permissions")
    private List<Permission> permissions;

    public AuthResponse setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public AuthResponse setTokenType(String tokenType) {
        this.tokenType = tokenType;
        return this;
    }

    public AuthResponse setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }

    public AuthResponse setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }

    public AuthResponse setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
        return this;
    }

    @Override
    public String toString() {
        return "AuthResponse{" +
            "accessToken='" + accessToken + '\'' +
            ", tokenType='" + tokenType + '\'' +
            ", expiresIn=" + expiresIn +
            ", refreshToken='" + refreshToken + '\'' +
            ", permissions=" + permissions +
            '}';
    }
}
