package com.elotech.registrationprocesses.entities.controllers;

import com.elotech.registrationprocesses.entities.Pessoa;
import com.elotech.registrationprocesses.entities.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    // get All
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Pessoa>> findAll() {
        List<Pessoa> list = pessoaService.findAll();
        return ResponseEntity.ok().body(list);
    }

    // get by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pessoa> findById(@PathVariable Long id) {
        Pessoa pessoa = pessoaService.findById(id);
        return ResponseEntity.ok().body(pessoa);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Pessoa> insertPessoa(@RequestBody Pessoa pessoa) {
        pessoa = pessoaService.insertPessoa(pessoa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).body(pessoa);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Pessoa> updatePessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        Pessoa oldPessoa = pessoaService.findById(id);
        pessoaService.updateDataPessoa(pessoa, oldPessoa);
        return ResponseEntity.ok().body(pessoa);
    }


    // delete by id
    @RequestMapping(value = "/{id}", method = RequestMethod.
            DELETE)
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        pessoaService.deletePessoa(id);
        return ResponseEntity.noContent().build();
    }


}
