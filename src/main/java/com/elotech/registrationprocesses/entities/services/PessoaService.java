package com.elotech.registrationprocesses.entities.services;

import com.elotech.registrationprocesses.entities.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;


}
