package com.elotech.registrationprocesses.entities.services.exceptions;

public class ControllerNotFoundException extends RuntimeException {

    private static final long SerialVersionUID = 1L;

    public ControllerNotFoundException(Object id) {
        super("Controller/Resource has not found! Id= "+id);
    }
}
