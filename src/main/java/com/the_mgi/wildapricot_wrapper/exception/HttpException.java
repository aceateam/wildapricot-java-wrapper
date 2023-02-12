package com.the_mgi.wildapricot_wrapper.exception;

import com.the_mgi.wildapricot_wrapper.base.model.ErrorObject;
import lombok.Getter;

@Getter
public class HttpException extends Exception {
    private final Integer statusCode;
    private ErrorObject error;

    public HttpException(Integer statusCode, String exceptionMessage) {
        super(exceptionMessage);
        this.statusCode = statusCode;
    }

    public HttpException(String message, Integer statusCode, ErrorObject error) {
        super(message);
        this.statusCode = statusCode;
        this.error = error;
    }

    public HttpException error(ErrorObject error) {
        this.error = error;
        return this;
    }

    @Override
    public String toString() {
        return "HttpException{" +
            "statusCode=" + statusCode +
            ", exceptionMessage='" + super.getMessage() + '\'' +
            ", error=" + error +
            "} " + super.toString();
    }
}
