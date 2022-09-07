package com.elotech.registrationprocesses.entities.services.exceptions;

import com.elotech.registrationprocesses.entities.Processo;

public class ProcessoDuplicateDataException extends RuntimeException {
    private static final long SerialVersionUID = 1L;

    public ProcessoDuplicateDataException(Processo processo) {
    super("Error trying to duplicate process: "+processo.getNumero()+ " already exists.");

    }
}
