package com.elotech.registrationprocesses.entities.repositories;

import com.elotech.registrationprocesses.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;


@Repository
public interface PessoaRepository extends PagingAndSortingRepository<Pessoa, Long>{
    List<Pessoa> findByNomeContains(String nome);
    List<Pessoa> findByNomeAndCpfContains(String nome, String cpf);

}
