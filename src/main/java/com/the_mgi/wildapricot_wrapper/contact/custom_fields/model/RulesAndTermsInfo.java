package com.the_mgi.wildapricot_wrapper.contact.custom_fields.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RulesAndTermsInfo {
    /**
     * Terms of use label.
     */
    @JsonProperty("Text")
    private String text;

    /**
     * Url of the rules and terms document.
     */
    @JsonProperty("Link")
    private String link;

    public RulesAndTermsInfo setLink(String link) {
        this.link = link;
        return this;
    }

    public RulesAndTermsInfo setText(String text) {
        this.text = text;
        return this;
    }

    @Override
    public String toString() {
        return "RulesAndTermsInfo{" +
               "text='" + text + '\'' +
               ", link='" + link + '\'' +
               '}';
    }
}
