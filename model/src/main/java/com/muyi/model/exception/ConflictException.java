package com.muyi.model.exception;


public class ConflictException extends MicroServiceException {

    private static final long serialVersionUID = 1L;

    public ConflictException(String errorCode, String message) {
        super(errorCode, message);
    }
}
