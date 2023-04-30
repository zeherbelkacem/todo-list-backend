package com.belkacem.agentsservice.exceptions;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends RuntimeException {
    private String message;
    private HttpStatus code;
    public ResourceNotFoundException(HttpStatus httpStatusCode , String message) {
        super(message);
        this.message = message;
        this.code = httpStatusCode;
    }
}
