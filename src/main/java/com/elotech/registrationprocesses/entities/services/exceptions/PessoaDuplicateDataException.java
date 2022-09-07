package com.elotech.registrationprocesses.entities.services.exceptions;

import com.elotech.registrationprocesses.entities.Pessoa;

public class PessoaDuplicateDataException extends RuntimeException {
    private static final long SerialVersionUID = 1L;

    public PessoaDuplicateDataException(Pessoa pessoa) {
    super("Error trying to duplicate person: "+pessoa.getNome()+ " already exists.");

    }
}
