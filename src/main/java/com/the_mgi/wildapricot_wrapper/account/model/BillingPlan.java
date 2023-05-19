package com.the_mgi.wildapricot_wrapper.account.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Objects;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BillingPlan {
    /**
     * Billing plan name
     */
    @JsonProperty("Name")
    private String name;

    /**
     * Monthly price
     */
    @JsonProperty("Price")
    private Number price;

    public BillingPlan setName(String name) {
        this.name = name;
        return this;
    }

    public BillingPlan setPrice(Number price) {
        this.price = price;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BillingPlan that = (BillingPlan) o;

        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "BillingPlan{" +
               "name='" + name + '\'' +
               ", price=" + price +
               '}';
    }
}
