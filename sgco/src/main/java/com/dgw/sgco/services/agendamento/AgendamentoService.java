package com.dgw.sgco.services.agendamento;

import java.math.BigDecimal;
import java.util.Optional;

import com.dgw.sgco.domain.agendamento.Agendamento;
import com.dgw.sgco.domain.agendamento.ProcedimentoAgendado;
import com.dgw.sgco.repositories.agendamento.AgendamentoRepository;
import com.dgw.sgco.services.email.EmailService;
import com.dgw.sgco.services.exceptions.ObjectNotFoundException;
import com.dgw.sgco.services.pessoa.PacienteService;

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

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private EmailService emailService;

    /**
     * Inserir um novo Agendamento
     * 
     * @param obj - Agendamento
     * @return Agendamento
     */
    @Transactional
    public Agendamento insert(Agendamento obj) {
        obj.setId(null);
        obj.setPaciente(pacienteService.find(obj.getPaciente().getId()));

        for (ProcedimentoAgendado pa : obj.getProcedimentos()) {
            pa.setDesconto(BigDecimal.ZERO);
            pa.setProcedimento(procedimentoService.find(pa.getProcedimento().getId()));
            pa.setValor(pa.getProcedimento().getValor());
            pa.setAgendamento(obj);
        }

        obj = repo.save(obj);

        emailService.enviarNotificacaoAgendamentoHtml(obj);

        return obj;
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
