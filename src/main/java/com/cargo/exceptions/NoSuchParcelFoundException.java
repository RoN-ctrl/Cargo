package com.cargo.exceptions;

import com.cargo.model.enums.ErrorType;

public class NoSuchParcelFoundException extends ServiceException {

    private static final String DEFAULT_MESSAGE = "No such parcel found";

    public NoSuchParcelFoundException() {
        super(DEFAULT_MESSAGE);
        setErrorType(ErrorType.DATABASE_ERROR_TYPE);
    }

    public NoSuchParcelFoundException(String message) {
        super(message);
        setErrorType(ErrorType.DATABASE_ERROR_TYPE);
    }

}
