package com.cargo.exceptions;

import com.cargo.model.enums.ErrorType;

public class NoSuchCityFoundException extends ServiceException {

    private static final String DEFAULT_MESSAGE = "No such city found";

    public NoSuchCityFoundException() {
        super(DEFAULT_MESSAGE);
        setErrorType(ErrorType.DATABASE_ERROR_TYPE);
    }

    public NoSuchCityFoundException(String message) {
        super(message);
        setErrorType(ErrorType.DATABASE_ERROR_TYPE);
    }

}
