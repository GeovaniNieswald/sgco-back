package com.dgw.sgco.resources.pessoa;

import java.util.List;

import com.dgw.sgco.domain.pessoa.Funcionario;
import com.dgw.sgco.resources.specifications.FuncionarioSpec;
import com.dgw.sgco.services.pessoa.FuncionarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * FuncionarioResource
 */
@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioResource {

    @Autowired
    private FuncionarioService service;

    /**
     * Buscar Funcionário por id
     * 
     * @param id - Integer
     * @return ResponseEntity -> Funcionario
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Funcionario> find(@PathVariable Integer id) {
        Funcionario obj = service.find(id);

        return ResponseEntity.ok().body(obj);
    }

    /**
     * Buscar funcionários por filtro
     * 
     * @param funcionarioSpec - FuncionarioSpec
     * @return ResponseEntity -> List<Funcionario>
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Funcionario>> findAll(FuncionarioSpec funcionarioSpec) {
        List<Funcionario> list = service.findAll(funcionarioSpec);

        return ResponseEntity.ok().body(list);
    }

}
