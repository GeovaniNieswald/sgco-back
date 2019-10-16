package com.dgw.sgco.resources.pessoa;

import java.net.URI;
import java.text.ParseException;

import javax.validation.Valid;

import com.dgw.sgco.domain.pessoa.Funcionario;
import com.dgw.sgco.dto.pessoa.FuncionarioDTO;
import com.dgw.sgco.dto.pessoa.FuncionarioGetDTO;
import com.dgw.sgco.resources.specifications.FuncionarioSpec;
import com.dgw.sgco.services.pessoa.FuncionarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * FuncionarioResource
 */
@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioResource {

    @Autowired
    private FuncionarioService service;

    /**
     * Inserir um novo Funcionario
     * 
     * @param obj - FuncionarioDTO
     * @return ResponseEntity com URI para o novo Funcionario inserido
     * @throws ParseException
     */
    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody FuncionarioDTO objDTO) throws ParseException {
        Funcionario obj = service.fromDTO(objDTO);

        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    /**
     * Alterar um Funcionario
     * 
     * @param obj - FuncionarioDTO
     * @param id  - Integer
     * @return ResponseEntity
     * @throws ParseException
     */
    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody FuncionarioDTO objDTO, @PathVariable Integer id) throws ParseException {
        Funcionario obj = service.fromDTO(objDTO);
        obj.setId(id);

        obj = service.update(obj);

        return ResponseEntity.noContent().build();
    }

    /**
     * Excluir um Funcionario pelo id
     * 
     * @param id - Integer
     * @return ResponseEntity
     */
    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    /**
     * Buscar Funcionário por id
     * 
     * @param id - Integer
     * @return ResponseEntity -> Funcionario
     */
    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Funcionario> find(@PathVariable Integer id) {
        Funcionario obj = service.find(id);

        return ResponseEntity.ok().body(obj);
    }

    /**
     * Buscar funcionários por filtro, de forma páginada
     * 
     * @return ResponseEntity -> List<Funcionario>
     */
    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<FuncionarioGetDTO>> findByFilter(
            FuncionarioSpec funcionarioSpec,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {

        Page<Funcionario> list = service.findPage(page, linesPerPage, orderBy, direction, funcionarioSpec);
        Page<FuncionarioGetDTO> listDTO = list.map(obj -> new FuncionarioGetDTO(obj));

        return ResponseEntity.ok().body(listDTO);
    }
}
