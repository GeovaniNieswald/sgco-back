package com.dgw.sgco.services.pessoa;

import java.util.Optional;

import com.dgw.sgco.domain.pessoa.Paciente;
import com.dgw.sgco.repositories.pessoa.PacienteRepository;
import com.dgw.sgco.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PacienteService
 */
@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repo;

    /**
     * Buscar Paciente por id
     * 
     * @param id - Integer
     * @return Paciente
     */
    public Paciente find(Integer id) {
        Optional<Paciente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Paciente.class.getName()));
    }

}
