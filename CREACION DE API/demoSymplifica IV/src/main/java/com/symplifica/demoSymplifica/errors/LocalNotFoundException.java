package com.symplifica.demoSymplifica.errors;

public class LocalNotFoundException extends Exception{
    public LocalNotFoundException() {
    }

    public LocalNotFoundException(String message) {
        super(message);
    }

    public LocalNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public LocalNotFoundException(Throwable cause) {
        super(cause);
    }

    public LocalNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
