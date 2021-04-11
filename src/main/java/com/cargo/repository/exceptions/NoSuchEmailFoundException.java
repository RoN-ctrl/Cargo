package com.cargo.repository.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoSuchEmailFoundException extends RuntimeException {

    public NoSuchEmailFoundException(String message) {
        super(message);
    }

}
