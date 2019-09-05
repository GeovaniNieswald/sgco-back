package com.dgw.sgco.services.agendamento;

import java.util.Optional;

import com.dgw.sgco.domain.agendamento.Procedimento;
import com.dgw.sgco.repositories.agendamento.ProcedimentoRepository;
import com.dgw.sgco.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ProcedimentoService
 */
@Service
public class ProcedimentoService {

    @Autowired
    private ProcedimentoRepository repo;

    /**
     * Buscar Procedimento por id
     * 
     * @param id - Integer
     * @return Procedimento
     */
    public Procedimento find(Integer id) {
        Optional<Procedimento> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Procedimento.class.getName()));
    }

}