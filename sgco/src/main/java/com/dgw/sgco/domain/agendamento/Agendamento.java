package com.dgw.sgco.domain.agendamento;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.dgw.sgco.domain.enums.StatusAgendamento;
import com.dgw.sgco.utils.JsonToMapConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Agendamento
 */
@Entity
public class Agendamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String anamnese;
    private String diagnostico;
    private String observacao;

    @Column(name = "receiturario", columnDefinition = "varchar") // Alterar para JSON quando utilizar no mysql
    @Convert(converter = JsonToMapConverter.class)
    private Map<String, Object> receiturario = new HashMap<>();

    @Column(name = "atestado", columnDefinition = "varchar") // Alterar para JSON quando utilizar no mysql
    @Convert(converter = JsonToMapConverter.class)
    private Map<String, Object> atestado = new HashMap<>();

    @Column(name = "data_hora_inicio")
    private Date dataHoraInicio;

    @Column(name = "data_hora_fim")
    private Date dataHoraFim;

    @Column(name = "cod_status")
    private Integer status;

    public Agendamento() {
    }

    /**
     * Agendamento
     * 
     * @param id             - Integer
     * @param anamnese       - String
     * @param diagnostico    - String
     * @param dataHoraInicio - Date
     * @param dataHoraFim    - Date
     * @param observacao     - String
     * @param status         - StatusAgendamento
     */
    public Agendamento(Integer id, String anamnese, String diagnostico, Date dataHoraInicio, Date dataHoraFim,
            String observacao, StatusAgendamento status) {
        super();
        this.id = id;
        this.anamnese = anamnese;
        this.diagnostico = diagnostico;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.observacao = observacao;
        this.status = (status == null) ? null : status.getCod();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnamnese() {
        return anamnese;
    }

    public void setAnamnese(String anamnese) {
        this.anamnese = anamnese;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Map<String, Object> getReceiturario() {
        return receiturario;
    }

    public void setReceiturario(Map<String, Object> receiturario) {
        this.receiturario = receiturario;
    }

    public Map<String, Object> getAtestado() {
        return atestado;
    }

    public void setAtestado(Map<String, Object> atestado) {
        this.atestado = atestado;
    }

    public Date getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(Date dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public Date getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(Date dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public StatusAgendamento getStatus() {
        return StatusAgendamento.toEnum(this.status);
    }

    public void setStatus(StatusAgendamento status) {
        this.status = status.getCod();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Agendamento other = (Agendamento) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}