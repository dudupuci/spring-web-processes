package com.elotech.registrationprocesses.entities.services.exceptions;

import com.elotech.registrationprocesses.entities.Pessoa;
import com.elotech.registrationprocesses.entities.Processo;

public class DuplicatedDataException extends RuntimeException {
    private static final long SerialVersionUID = 1L;

    public DuplicatedDataException(Pessoa pessoa) {
    super("Error trying to duplicate person: "+pessoa.getNome()+ " already exists.");
    }

    public DuplicatedDataException(Processo processo) {
        super("Error trying to duplicate process: "+processo.getNumero()+ " already exists.");
    }
}
