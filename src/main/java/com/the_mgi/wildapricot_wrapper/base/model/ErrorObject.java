package com.the_mgi.wildapricot_wrapper.base.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ErrorObject {
    /**
     * Error code like Validation / Search / ...
     */
    @JsonProperty("code")
    private String code;

    /**
     * An explanation of why this error occurred
     */
    @JsonProperty("message")
    private String message;

    /**
     * More information about the error, Data structure is specific for each kind of error.
     */
    @JsonProperty("details")
    private String details;

    public ErrorObject setCode(String code) {
        this.code = code;
        return this;
    }

    public ErrorObject setMessage(String message) {
        this.message = message;
        return this;
    }

    public ErrorObject setDetails(String details) {
        this.details = details;
        return this;
    }

    @Override
    public String toString() {
        return "Error{" +
            "code='" + code + '\'' +
            ", message='" + message + '\'' +
            ", details='" + details + '\'' +
            '}';
    }
}
