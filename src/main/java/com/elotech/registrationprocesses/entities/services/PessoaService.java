package com.elotech.registrationprocesses.entities.services;

import com.elotech.registrationprocesses.entities.Pessoa;
import com.elotech.registrationprocesses.entities.repositories.PessoaRepository;
import com.elotech.registrationprocesses.entities.services.exceptions.DuplicatedDataException;
import com.elotech.registrationprocesses.entities.services.exceptions.ControllerNotFoundException;
import com.elotech.registrationprocesses.entities.services.exceptions.UpdateDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class PessoaService  {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> findAll() {
        return (List<Pessoa>) pessoaRepository.findAll();
    }


    public Page<Pessoa> findAllPage(PageRequest request) {
        return pessoaRepository.findAll(request);
    }

    public Page<Pessoa> findAllPageable(Pageable pageable) {
        return pessoaRepository.findAll(pageable);
    }


    public List<Pessoa> pagination(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Pessoa> result = pessoaRepository.findAll(pageable);
        return result.toList();
    }

    public void deleteAll(List<Pessoa> list) {
        pessoaRepository.deleteAll(list);
    }

    public Pessoa findById(Long id) {
        return pessoaRepository.findById(id).orElseThrow(
                () -> new ControllerNotFoundException(HttpStatus.NOT_FOUND));
    }

    public Pessoa insertPessoa(Pessoa pessoa) {
        try {
            return pessoaRepository.save(pessoa);
        } catch (Exception e) {
            throw new DuplicatedDataException(pessoa);
        }
    }

    public void deletePessoa(Long id) {
        try {
            pessoaRepository.deleteById(id);
            // id can be null, create a exception
        } catch (Exception e) {
            throw new ControllerNotFoundException(HttpStatus.NOT_FOUND);
        }
    }

    public Pessoa updateAndSavePessoa(Long id, Pessoa newPessoa) {
        try {
            Pessoa oldPessoa = pessoaRepository.findById(id).orElse(null);
            updateDataPessoa(newPessoa, oldPessoa);
            return pessoaRepository.save(newPessoa);

        } catch (Exception e) {
            throw new UpdateDataException(newPessoa);
        }

    }


    public void updateDataPessoa(Pessoa newPessoa, Pessoa oldPessoa) {
        oldPessoa.setNome(newPessoa.getNome());
        oldPessoa.setCpf(newPessoa.getCpf());
        oldPessoa.setDataCadastro(newPessoa.getDataCadastro());
        oldPessoa.setDataNascimento(newPessoa.getDataNascimento());
        oldPessoa.setProcesso(newPessoa.getProcesso());
    }

}
