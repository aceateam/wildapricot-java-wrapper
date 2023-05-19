package com.the_mgi.wildapricot_wrapper.base.model;

import lombok.Getter;

@Getter
public class AuthRequestApiKey {
    private String apiKey;

    public AuthRequestApiKey setApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }
}
