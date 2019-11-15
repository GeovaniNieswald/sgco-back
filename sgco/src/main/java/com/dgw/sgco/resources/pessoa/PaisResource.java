package com.dgw.sgco.resources.pessoa;

import java.util.List;
import java.util.stream.Collectors;

import com.dgw.sgco.domain.pessoa.Estado;
import com.dgw.sgco.domain.pessoa.Pais;
import com.dgw.sgco.dto.pessoa.EstadoDTO;
import com.dgw.sgco.dto.pessoa.PaisDTO;
import com.dgw.sgco.services.pessoa.EstadoService;
import com.dgw.sgco.services.pessoa.PaisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * PaisResource
 */
@RestController
@RequestMapping(value = "/paises")
public class PaisResource {

    @Autowired
    private PaisService service;
    @Autowired
    private EstadoService estadoService;

    /**
     * Buscar Pais por id
     * 
     * @param id - Integer
     * @return Pais
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pais> find(@PathVariable Integer id) {
        Pais obj = service.find(id);

        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<PaisDTO>> findAll() {
        List<Pais> list = service.findAll();
        List<PaisDTO> listDTO = list.stream().map(obj -> new PaisDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @RequestMapping(value = "/{idPais}/estados", method = RequestMethod.GET)
    public ResponseEntity<List<EstadoDTO>> findEstados(@PathVariable Integer idPais) {
        List<Estado> list = estadoService.findByPais(idPais);
        List<EstadoDTO> listDto = list.stream().map(obj -> new EstadoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

}
