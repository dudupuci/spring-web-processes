package com.elotech.registrationprocesses.entities.services;

import com.elotech.registrationprocesses.entities.Processo;
import com.elotech.registrationprocesses.entities.controllers.exceptions.StandardError;
import com.elotech.registrationprocesses.entities.repositories.ProcessoRepository;
import com.elotech.registrationprocesses.entities.services.exceptions.ControllerNotFoundException;
import com.elotech.registrationprocesses.entities.services.exceptions.ProcessoDuplicateDataException;
import com.elotech.registrationprocesses.entities.services.exceptions.UpdateDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.time.Instant;
import java.util.List;

@Service
public class ProcessoService {

    @Autowired
    private ProcessoRepository processoRepository;

    public List<Processo> findAll() {
        return processoRepository.findAll();
    }

    public Processo findById(Long id) {
        return processoRepository.findById(id).orElseThrow(()
                -> new ControllerNotFoundException(HttpStatus.NOT_FOUND));
    }

    public Processo insertProcesso(Processo processo) {
        try {
            return processoRepository.save(processo);
        } catch (Exception e) {
            throw new ProcessoDuplicateDataException(processo);
        }

    }

    public void deleteProcesso(Long id) {
        try {
            processoRepository.deleteById(id);
        } catch (Exception e) {
            throw new ControllerNotFoundException(HttpStatus.NOT_FOUND);

        }

    }

    public Processo updateAndSaveProcesso(Long id, Processo newProcesso) {
        try {
            Processo oldProcesso = processoRepository.findById(id).orElse(null);
            updateProcesso(newProcesso, oldProcesso);
            return processoRepository.save(newProcesso);

        } catch (Exception e) {
            throw new UpdateDataException(newProcesso);
        }

    }


    public void updateProcesso(Processo newProcesso, Processo oldProcesso) {
        try {
            oldProcesso.setNumero(newProcesso.getNumero());
            oldProcesso.setPessoas(newProcesso.getPessoas());
            oldProcesso.setAno(newProcesso.getAno());
            oldProcesso.setDataCadastro(newProcesso.getDataCadastro());
        } catch (Exception e) {
            throw new UpdateDataException(newProcesso);
        }

    }

}
