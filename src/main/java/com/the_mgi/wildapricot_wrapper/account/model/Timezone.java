package com.the_mgi.wildapricot_wrapper.account.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Objects;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Timezone {
    /**
     * Time zone id, i.e. "Arabic Standard Time"
     */
    @JsonProperty("ZoneId")
    private String zoneId;

    /**
     * Time zone name, i.e. "(UTC+03:00) Baghdad"
     */
    @JsonProperty("Name")
    private String name;

    /**
     * Offset from UTC Time in minutes, i.e. "180"
     */
    @JsonProperty("UtcOffset")
    private Integer utcOffset;

    public Timezone setZoneId(String zoneId) {
        this.zoneId = zoneId;
        return this;
    }

    public Timezone setName(String name) {
        this.name = name;
        return this;
    }

    public Timezone setUtcOffset(Integer utcOffset) {
        this.utcOffset = utcOffset;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Timezone timezone = (Timezone) o;

        return Objects.equals(zoneId, timezone.zoneId);
    }

    @Override
    public int hashCode() {
        return zoneId != null ? zoneId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Timezone{" +
               "zoneId='" + zoneId + '\'' +
               ", name='" + name + '\'' +
               ", utcOffset=" + utcOffset +
               '}';
    }
}
