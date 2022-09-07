package com.elotech.registrationprocesses.entities.services.exceptions;

import com.elotech.registrationprocesses.entities.Pessoa;
import com.elotech.registrationprocesses.entities.Processo;

public class UpdateDataException extends RuntimeException {

    private static final long SerialVersionUID = 1L;

    public UpdateDataException(Processo processo) {
        super("Error trying to update the process number: "+processo.getNumero());
    }

    public UpdateDataException(Pessoa pessoa){
        super("Error trying to update the person: "+pessoa.getNome());
    }
}
