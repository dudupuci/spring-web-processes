package com.elotech.registrationprocesses.entities.services.exceptions;

public class DatabaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DatabaseException(String msg) {
        // msg of superclass runtimeException
        super(msg);
    }


}