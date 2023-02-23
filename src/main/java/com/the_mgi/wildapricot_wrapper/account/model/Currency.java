package com.the_mgi.wildapricot_wrapper.account.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Objects;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Currency {
    /**
     * Currency code according to ISO4217
     */
    @JsonProperty("Code")
    private String code;

    /**
     * Human-readable currency name
     */
    @JsonProperty("Name")
    private String name;

    /**
     * Currency symbol like $ or â‚¬
     */
    @JsonProperty("Symbol")
    private String symbol;

    public Currency setCode(String code) {
        this.code = code;
        return this;
    }

    public Currency setName(String name) {
        this.name = name;
        return this;
    }

    public Currency setSymbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Currency currency = (Currency) o;

        return Objects.equals(code, currency.code);
    }

    @Override
    public int hashCode() {
        return code != null ? code.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Currency{" +
               "code='" + code + '\'' +
               ", name='" + name + '\'' +
               ", symbol='" + symbol + '\'' +
               '}';
    }
}
