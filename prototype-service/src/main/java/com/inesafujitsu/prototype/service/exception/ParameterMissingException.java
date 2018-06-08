package com.inesafujitsu.prototype.service.exception;

public class ParameterMissingException extends RuntimeException {

    public ParameterMissingException(String message) {
        super("There might be some parameter missing" + message);
    }
}
