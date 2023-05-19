package com.the_mgi.wildapricot_wrapper.contact.custom_fields.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.the_mgi.wildapricot_wrapper.contact.custom_fields.model.enums.MultiplierType;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExtraChargeOptions {
    /**
     * Indicates the type of multiplier field.
     * <ul>
     *     <li>ItemPrice multiplier specifies a price for each requested item.</li>
     *     <li>Percentage multiplier specifies a percent of field value to use as extra charge.</li>
     * </ul>
     */
    @JsonProperty("MultiplierType")
    private MultiplierType multiplierType;

    /**
     * value of multiplier for extra charge calculation
     */
    @JsonProperty("Multiplier")
    private Double multiplier;

    /**
     * Minimal amount of items to request (minimal field value). For ItemPrice multiplier type only.
     */
    @JsonProperty("MinAmount")
    private Integer minAmount;

    /**
     * Maximum amount of items to request (maximum field value). For ItemPrice multiplier type only.
     */
    @JsonProperty("MaxAmount")
    private Integer maxAmount;

    /**
     * Minimal extra charge. (minimal field value). For Percentage multiplier type only.
     */
    @JsonProperty("MinCharge")
    private Double minCharge;

    /**
     * Minimal extra charge. (minimal field value). For Percentage multiplier type only.
     */
    @JsonProperty("MaxCharge")
    private Double maxCharge;

    public ExtraChargeOptions setMultiplierType(MultiplierType multiplierType) {
        this.multiplierType = multiplierType;
        return this;
    }

    public ExtraChargeOptions setMultiplier(Double multiplier) {
        this.multiplier = multiplier;
        return this;
    }

    public ExtraChargeOptions setMinAmount(Integer minAmount) {
        this.minAmount = minAmount;
        return this;
    }

    public ExtraChargeOptions setMaxAmount(Integer maxAmount) {
        this.maxAmount = maxAmount;
        return this;
    }

    public ExtraChargeOptions setMinCharge(Double minCharge) {
        this.minCharge = minCharge;
        return this;
    }

    public ExtraChargeOptions setMaxCharge(Double maxCharge) {
        this.maxCharge = maxCharge;
        return this;
    }

    @Override
    public String toString() {
        return "ExtraChargeOption{" +
               "multiplierType=" + multiplierType +
               ", multiplier=" + multiplier +
               ", minAmount=" + minAmount +
               ", maxAmount=" + maxAmount +
               ", minCharge=" + minCharge +
               ", maxCharge=" + maxCharge +
               '}';
    }
}
