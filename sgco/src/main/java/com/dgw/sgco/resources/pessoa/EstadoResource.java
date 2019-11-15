package com.dgw.sgco.resources.pessoa;

import java.util.List;
import java.util.stream.Collectors;

import com.dgw.sgco.domain.pessoa.Cidade;
import com.dgw.sgco.domain.pessoa.Estado;
import com.dgw.sgco.dto.pessoa.CidadeDTO;
import com.dgw.sgco.services.pessoa.CidadeService;
import com.dgw.sgco.services.pessoa.EstadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * EstadoResource
 */
@RestController
@RequestMapping(value = "/estados")
public class EstadoResource {

    @Autowired
    private EstadoService service;
    @Autowired
    private CidadeService serviceCidade;

    /**
     * Buscar Estado por id
     * 
     * @param id - Integer
     * @return Estado
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Estado> find(@PathVariable Integer id) {
        Estado obj = service.find(id);

        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{idEstado}/cidades", method = RequestMethod.GET)
    public ResponseEntity<List<CidadeDTO>> findCidades(@PathVariable Integer idEstado) {
        List<Cidade> list = serviceCidade.findByEstado(idEstado);
        List<CidadeDTO> listDto = list.stream().map(obj -> new CidadeDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

}
