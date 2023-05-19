package com.the_mgi.wildapricot_wrapper.contact.custom_fields.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Objects;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OptionsListItem {
    /**
     * Item identifier unique in the list
     */
    @JsonProperty("Id")
    private Integer id;

    /**
     * Human-readable text label.
     */
    @JsonProperty("Label")
    private String label;

    /**
     * Option position among other options.
     */
    @JsonProperty("Position")
    private Integer position;

    /**
     * Indicates whether this option would be selected on form if user did not select another option.
     */
    @JsonProperty("SelectedByDefault")
    private Boolean electedByDefault;

    /**
     * Extra price for selecting this option. Used only by fields with an associated cost.
     */
    @JsonProperty("ExtraCost")
    private Double extraCost;

    public OptionsListItem setId(Integer id) {
        this.id = id;
        return this;
    }

    public OptionsListItem setLabel(String label) {
        this.label = label;
        return this;
    }

    public OptionsListItem setPosition(Integer position) {
        this.position = position;
        return this;
    }

    public OptionsListItem setElectedByDefault(Boolean electedByDefault) {
        this.electedByDefault = electedByDefault;
        return this;
    }

    public OptionsListItem setExtraCost(Double extraCost) {
        this.extraCost = extraCost;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OptionsListItem that = (OptionsListItem) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "OptionsListItem{" +
               "id=" + id +
               ", label='" + label + '\'' +
               ", position=" + position +
               ", electedByDefault=" + electedByDefault +
               ", extraCost=" + extraCost +
               '}';
    }
}
