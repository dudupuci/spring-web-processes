package com.elotech.registrationprocesses.entities.controllers;


import com.elotech.registrationprocesses.entities.Processo;
import com.elotech.registrationprocesses.entities.services.ProcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
// Accept all and resolve cors
@CrossOrigin(origins = "*")
@RequestMapping(value = "/processos")
public class ProcessoController {

    @Autowired
    private ProcessoService processoService;

    // get all
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Processo>> findAll() {
        List<Processo> list = processoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    // get by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Processo> findById(@PathVariable Long id) {
        Processo processo = processoService.findById(id);
        return ResponseEntity.ok().body(processo);
    }

    // post
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Processo> updateProcesso(@PathVariable Long id, @RequestBody Processo newProcesso) {
        Processo oldProcesso = processoService.findById(id);
        processoService.updateProcesso(newProcesso, oldProcesso);
        processoService.updateAndSaveProcesso(id, newProcesso);
        return ResponseEntity.ok().body(newProcesso);
    }

    // put
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Processo> insertProcesso(@RequestBody Processo processo) {
        processo = processoService.insertProcesso(processo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(processo.getId()).toUri();
        return ResponseEntity.created(uri).body(processo);
    }


    // delete by id
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        processoService.deleteProcesso(id);
        return ResponseEntity.noContent().build();
    }


}
