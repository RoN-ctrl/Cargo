package com.cargo.repository.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoSuchCityFoundException extends RuntimeException {

    public NoSuchCityFoundException(String message) {
        super(message);
    }

}
