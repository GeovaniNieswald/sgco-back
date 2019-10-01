package com.dgw.sgco.services.agendamento;

import java.math.BigDecimal;
import java.util.Optional;

import com.dgw.sgco.domain.agendamento.Agendamento;
import com.dgw.sgco.domain.agendamento.ProcedimentoAgendado;
import com.dgw.sgco.repositories.agendamento.AgendamentoRepository;
import com.dgw.sgco.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * AgendamentoService
 */
@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository repo;

    @Autowired
    private ProcedimentoService procedimentoService;

    /**
     * Inserir um novo Agendamento
     * 
     * @param obj - Agendamento
     * @return Agendamento
     */
    @Transactional
    public Agendamento insert(Agendamento obj) {
        obj.setId(null);

        for (ProcedimentoAgendado pa : obj.getProcedimentos()) {
            pa.setDesconto(BigDecimal.ZERO);
            pa.setValor(procedimentoService.find(pa.getProcedimento().getId()).getValor());
            pa.setAgendamento(obj);
        }

        return repo.save(obj);
    }

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
