package com.cargo.exceptions;

import com.cargo.model.enums.ErrorType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import static com.cargo.model.enums.ErrorType.FATAL_ERROR_TYPE;

@Data
@EqualsAndHashCode(callSuper = false)
public class ServiceException extends RuntimeException {

    private ErrorType errorType = FATAL_ERROR_TYPE;

    public ServiceException(String message) {
        super(message);
    }

}



