package com.elotech.registrationprocesses.entities.controllers;

import com.elotech.registrationprocesses.entities.Pessoa;
import com.elotech.registrationprocesses.entities.repositories.PessoaRepository;
import com.elotech.registrationprocesses.entities.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
// Accept all and resolve cors
@CrossOrigin(origins = "*")
@RequestMapping(value = "/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private PessoaRepository pessoaRepository;


    // get All
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Pessoa>> findAll() {
        List<Pessoa> list = pessoaService.findAll();
        return ResponseEntity.ok().body(list);
    }

    // Pagination by number and size
    @RequestMapping(method = RequestMethod.GET, value = "/pagination/{pageNumber}/{pageSize}")
    public ResponseEntity<List<Pessoa>> getAllPagination(@PathVariable int pageNumber, @PathVariable int pageSize) {
        return ResponseEntity.ok().body(pessoaService.pagination(pageNumber, pageSize));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/simplePage")
    public Page<Pessoa> simplePagination() {
        Page<Pessoa> page = pessoaService.findAllPage(PageRequest.of(0,20));
        return ResponseEntity.ok().body(page).getBody();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/paramPage")
    public Page<Pessoa> paramPagination(Pageable pageable) {
        Page<Pessoa> page = pessoaService.findAllPageable(pageable);
        return ResponseEntity.ok().body(page).getBody();
    }


    // get by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pessoa> findById(@PathVariable Long id) {
        Pessoa pessoa = pessoaService.findById(id);
        return ResponseEntity.ok().body(pessoa);
    }

    // post
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Pessoa> insertPessoa(@Valid @RequestBody Pessoa pessoa) {
        pessoa = pessoaService.insertPessoa(pessoa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).body(pessoa);

    }


    // put, update
    @RequestMapping(value = "alterar/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Pessoa> updatePessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        Pessoa oldPessoa = pessoaService.findById(id);
        pessoaService.updateDataPessoa(pessoa, oldPessoa);
        pessoaService.updateAndSavePessoa(id, pessoa);
        return ResponseEntity.ok().body(pessoa);
    }


    // delete by id
    @RequestMapping(value = "remover/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        pessoaService.deletePessoa(id);
        return ResponseEntity.noContent().build();
    }

    // delete all
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteAll() {
        List<Pessoa> list = pessoaService.findAll();
        pessoaService.deleteAll(list);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/filter")
    public ResponseEntity<List<Pessoa>> findPersonByName(@RequestParam("nome") String nome) {
      return ResponseEntity.ok().body(pessoaRepository.findByNomeContains(nome));
      // or: return this.pessoaRepository.findByNomeContains(nome);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/filterAll")
    public ResponseEntity<List<Pessoa>> findPersonByNameAndCpf(@RequestParam("nome") String nome,
                                                               @RequestParam("cpf")String cpf) {
        return ResponseEntity.ok().body(pessoaRepository.findByNomeAndCpfContains(nome, cpf));
    }



}

