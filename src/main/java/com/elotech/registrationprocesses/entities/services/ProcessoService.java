package com.elotech.registrationprocesses.entities.services;

import com.elotech.registrationprocesses.entities.Processo;
import com.elotech.registrationprocesses.entities.repositories.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProcessoService {

    @Autowired
    private ProcessoRepository processoRepository;

    public List<Processo> findAll() {
        return processoRepository.findAll();
    }

    public Processo findById(Long id) {
        return processoRepository.findById(id).orElse(null);
    }

    public Processo insertProcesso(Processo processo) {
        return processoRepository.save(processo);
    }

    public void deleteProcesso(Long id) {
        try {
            processoRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Error trying to delete process: " + e.getMessage());
        }

    }

    public Processo updateAndSaveProcesso(Long id, Processo newProcesso) {
        try {
            Processo oldProcesso = processoRepository.findById(id).orElse(null);
            updateProcesso(newProcesso, oldProcesso);
            return processoRepository.save(newProcesso);


        } catch (Exception e) {
            System.out.println("Error trying to update and save process: " + e.getMessage());
        }
        return null;
    }


    public void updateProcesso(Processo newProcesso, Processo oldProcesso) {
        oldProcesso.setNumero(newProcesso.getNumero());
        oldProcesso.setPessoas(newProcesso.getPessoas());
        oldProcesso.setAno(newProcesso.getAno());
        oldProcesso.setDataCadastro(newProcesso.getDataCadastro());

    }

}
