package com.dgw.sgco.resources.agendamento;

import java.net.URI;
import java.util.List;

import com.dgw.sgco.domain.agendamento.Procedimento;
import com.dgw.sgco.services.agendamento.ProcedimentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * ProcedimentoResource
 */
@RestController
@RequestMapping(value = "/procedimentos")
public class ProcedimentoResource {

    @Autowired
    private ProcedimentoService service;

    /**
     * Buscar Procedimento por id
     * 
     * @param id - Integer
     * @return Procedimento
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Procedimento> find(@PathVariable Integer id) {
        Procedimento obj = service.find(id);

        return ResponseEntity.ok().body(obj);
    }

    /**
     * Buscar todos os Procedimentos
     * 
     * @return List<Procedimento>
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Procedimento>> findAll() {
        List<Procedimento> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    /**
     * Inserir um novo Procedimento
     * 
     * @param obj - Procedimento
     * @return ResponseEntity com URI para o novo procedimento inserido
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Procedimento obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    /**
     * Alterar um Procedimento
     * 
     * @param obj - Procedimento
     * @param id  - Integer
     * @return ResponseEntity
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Procedimento obj, @PathVariable Integer id) {
        obj.setId(id);
        obj = service.update(obj);

        return ResponseEntity.noContent().build();
    }

    /**
     * Excluir um Procedimento pelo id
     * 
     * @param id - Integer
     * @return ResponseEntity
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
