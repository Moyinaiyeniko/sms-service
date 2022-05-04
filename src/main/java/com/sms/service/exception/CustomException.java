package com.sms.service.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {
    private final String message;
    private final String error;
    private final HttpStatus httpStatus;


    public CustomException(String message, String error, HttpStatus httpStatus) {
        this.message = message;
        this.error = error;
        this.httpStatus = httpStatus;

    }


    public String getMessage() {
        return message;
    }

    public String getError() {
        return error;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}