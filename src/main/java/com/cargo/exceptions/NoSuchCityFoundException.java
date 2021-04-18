package com.cargo.exceptions;

public class NoSuchCityFoundException extends ServiceException {

    private static final String DEFAULT_MESSAGE = "No such city found";

    public NoSuchCityFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public NoSuchCityFoundException(String message) {
        super(message);
    }

}
