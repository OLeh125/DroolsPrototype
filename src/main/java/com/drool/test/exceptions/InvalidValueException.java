package com.drool.test.exceptions;

public class InvalidValueException extends BadRequestException {

    public InvalidValueException(String message) {
        super(message);
    }

}
