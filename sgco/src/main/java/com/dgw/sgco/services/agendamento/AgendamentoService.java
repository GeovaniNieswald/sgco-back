package com.dgw.sgco.services.agendamento;

import java.util.Optional;

import com.dgw.sgco.domain.agendamento.Agendamento;
import com.dgw.sgco.repositories.agendamento.AgendamentoRepository;
import com.dgw.sgco.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AgendamentoService
 */
@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository repo;

    /**
     * Buscar Agendamento por id
     * 
     * @param id - Integer
     * @return Agendamento
     */
    public Agendamento find(Integer id) {
        Optional<Agendamento> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Agendamento.class.getName()));
    }
}
