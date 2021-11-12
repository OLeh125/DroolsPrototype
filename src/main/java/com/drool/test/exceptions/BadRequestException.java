package com.drool.test.exceptions;

import org.springframework.core.NestedRuntimeException;

/**
 * Generic class that implies that there is a problem with the parameters provided in the request
 * Automatically managed by ControllerExceptionHandler
 */
public class BadRequestException extends NestedRuntimeException {
    public BadRequestException(String s) {
        super(s);
    }
}