package com.cargo.exceptions;

public class NoSuchParcelFoundException extends ServiceException {

    private static final String DEFAULT_MESSAGE = "No such parcel found";

    public NoSuchParcelFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public NoSuchParcelFoundException(String message) {
        super(message);
    }

}
