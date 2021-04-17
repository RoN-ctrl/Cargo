package com.cargo.exceptions;

public class NoSuchAccountFoundException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "No such account found";

    public NoSuchAccountFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public NoSuchAccountFoundException(String message) {
        super(message);
    }

}
