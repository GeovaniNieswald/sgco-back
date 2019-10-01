package com.dgw.sgco.resources.agendamento;

import java.net.URI;

import javax.validation.Valid;

import com.dgw.sgco.domain.agendamento.Agendamento;
import com.dgw.sgco.services.agendamento.AgendamentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * AgendamentoResource
 */
@RestController
@RequestMapping(value = "/agendamentos")
public class AgendamentoResource {

    @Autowired
    private AgendamentoService service;

    /**
     * Inserir um novo Agendamento
     * 
     * @param obj - Agendamento
     * @return ResponseEntity com URI para o novo Agendamento inserido
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody Agendamento obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    /**
     * Buscar Agendamento por id
     * 
     * @param id - Integer
     * @return Agendamento
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Agendamento> find(@PathVariable Integer id) {
        Agendamento obj = service.find(id);

        return ResponseEntity.ok().body(obj);
    }

}
