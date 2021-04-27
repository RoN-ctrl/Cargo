package com.cargo.exceptions;

import com.cargo.model.enums.ErrorType;

public class NoSuchAccountFoundException extends ServiceException {

    private static final String DEFAULT_MESSAGE = "No such account found";

    public NoSuchAccountFoundException() {
        super(DEFAULT_MESSAGE);
        setErrorType(ErrorType.DATABASE_ERROR_TYPE);
    }

    public NoSuchAccountFoundException(String message) {
        super(message);
        setErrorType(ErrorType.DATABASE_ERROR_TYPE);
    }

}
