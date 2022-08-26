package com.elotech.registrationprocesses.entities.services;

import com.elotech.registrationprocesses.entities.Pessoa;
import com.elotech.registrationprocesses.entities.Processo;
import com.elotech.registrationprocesses.entities.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public Pessoa findById(Long id) {
        return pessoaRepository.findById(id).orElse(null);
    }

    public Pessoa insertPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public void deletePessoa(Long id) {
        try {
            pessoaRepository.deleteById(id);
            // id can be null, create a exception
        } catch (Exception e) {
            System.out.println("Error trying to delete pessoa: " + e.getMessage());
        }
    }

    public Pessoa updateAndSavePessoa(Long id, Pessoa newPessoa) {
        try {
            Pessoa oldPessoa = pessoaRepository.findById(id).orElse(null);
            updateDataPessoa(newPessoa, oldPessoa);
            return pessoaRepository.save(newPessoa);

        } catch (Exception e) {
            System.out.println("Error trying to update and save pessoa: " + e.getMessage());
        }
        return null;
    }


    public void updateDataPessoa(Pessoa newPessoa, Pessoa oldPessoa) {
        newPessoa.setNome(oldPessoa.getNome());
        newPessoa.setCpf(oldPessoa.getCpf());
        newPessoa.setDataCadastro(oldPessoa.getDataCadastro());
        newPessoa.setDataNascimento(oldPessoa.getDataNascimento());
        newPessoa.setProcesso(oldPessoa.getProcesso());
    }


}
