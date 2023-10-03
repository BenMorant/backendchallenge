package com.glady.benmorant.exception;

public class BeyondExpirationException extends RuntimeException {

    public BeyondExpirationException(String message) {
        super(message);
    }
}
