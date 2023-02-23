package com.the_mgi.wildapricot_wrapper.account.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Localization {
    /**
     * Date format like "d MMM yyyy"
     */
    @JsonProperty("DateFormat")
    private String dateFormat;

    /**
     * Time format like "h:mm tt"
     */
    @JsonProperty("TimeFormat")
    private String timeFormat;

    public Localization setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
        return this;
    }

    public Localization setTimeFormat(String timeFormat) {
        this.timeFormat = timeFormat;
        return this;
    }

    @Override
    public String toString() {
        return "Localization{" +
               "dateFormat='" + dateFormat + '\'' +
               ", timeFormat='" + timeFormat + '\'' +
               '}';
    }
}
