package com.elotech.registrationprocesses.entities.services;

import com.elotech.registrationprocesses.entities.repositories.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessoService {

    @Autowired
    private ProcessoRepository processoRepository;
}
