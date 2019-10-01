package com.dgw.sgco.services.agendamento;

import java.util.List;
import java.util.Optional;

import com.dgw.sgco.domain.agendamento.Procedimento;
import com.dgw.sgco.dto.agendamento.ProcedimentoDTO;
import com.dgw.sgco.repositories.agendamento.ProcedimentoRepository;
import com.dgw.sgco.resources.specifications.ProcedimentoSpec;
import com.dgw.sgco.services.exceptions.DataIntegrityException;
import com.dgw.sgco.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

/**
 * ProcedimentoService
 */
@Service
public class ProcedimentoService {

    @Autowired
    private ProcedimentoRepository repo;

    /**
     * Inserir um novo Procedimento
     * 
     * @param obj - Procedimento
     * @return Procedimento inserido
     */
    public Procedimento insert(Procedimento obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    /**
     * Alterar um Procedimento
     * 
     * @param obj - Procedimento
     * @return Procedimento alterado
     */
    public Procedimento update(Procedimento obj) {
        find(obj.getId());
        return repo.save(obj);
    }

    /**
     * Excluir um Procedimento pelo id
     * 
     * @param id - Integer
     */
    public void delete(Integer id) {
        find(id);

        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityException("Não é possível excluir um procedimento que já tenha sido agendado alguma vez!");
        }
    }

    /**
     * Buscar Procedimento por id
     * 
     * @param id - Integer
     * @return Procedimento
     */
    public Procedimento find(Integer id) {
        Optional<Procedimento> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Procedimento.class.getName()));
    }

    /**
     * Buscar todos os Procedimentos
     * 
     * @return List<Procedimento>
     */
    public List<Procedimento> findAll() {
        return repo.findAll();
    }

    /**
     * Buscar procedimentos por filtro, de forma páginada
     * 
     * @param page             - Integer
     * @param linesPerPage     - Integer
     * @param orderBy          - String
     * @param direction        - String
     * @param procedimentoSpec - ProcedimentoSpec (nome, ativo)
     * @return Page<Procedimento>
     */
    public Page<Procedimento> findPage(Integer page, Integer linesPerPage, String orderBy, String direction, ProcedimentoSpec procedimentoSpec) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

        return repo.findAll(procedimentoSpec, pageRequest);
    }

    /**
     * Metódo para converter um ProcedimentoDTO em um Procedimento
     * 
     * @param objDTO - ProcedimentoDTO
     * @return Procedimento
     */
    public Procedimento fromDTO(ProcedimentoDTO objDTO) {
        return new Procedimento(objDTO.getId(), objDTO.getNome(), objDTO.getValor(), objDTO.isAtivo());
    }

}
