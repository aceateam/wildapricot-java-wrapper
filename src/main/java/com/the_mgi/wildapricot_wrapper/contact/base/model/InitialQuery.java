package com.the_mgi.wildapricot_wrapper.contact.base.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class InitialQuery {
    /**
     * Object type which was requested. In this case it is always Contact.
     */
    @JsonProperty("ObjectType")
    private String objectType;

    /**
     * Value of $filter parameter passed into API.
     */
    @JsonProperty("FilterExpression")
    private String filterExpression;

    /**
     * Value of $select parameter passed into API.
     */
    @JsonProperty("SelectExpression")
    private String selectExpression;

    /**
     * Indicates if client requested only a list of identifiers, instead of full list of contacts.
     */
    @JsonProperty("ReturnIds")
    private Boolean returnIds;

    public InitialQuery setObjectType(String objectType) {
        this.objectType = objectType;
        return this;
    }

    public InitialQuery setFilterExpression(String filterExpression) {
        this.filterExpression = filterExpression;
        return this;
    }

    public InitialQuery setSelectExpression(String selectExpression) {
        this.selectExpression = selectExpression;
        return this;
    }

    public InitialQuery setReturnIds(Boolean returnIds) {
        this.returnIds = returnIds;
        return this;
    }

    @Override
    public String toString() {
        return "InitialQuery{" +
               "objectType='" + objectType + '\'' +
               ", filterExpression='" + filterExpression + '\'' +
               ", selectExpression='" + selectExpression + '\'' +
               ", returnIds=" + returnIds +
               '}';
    }
}
