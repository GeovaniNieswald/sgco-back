package com.dgw.sgco.domain.agendamento;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * ProcedimentoAgendado
 */
@Entity
public class ProcedimentoAgendado implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @EmbeddedId
    private ProcedimentoAgendadoPK id = new ProcedimentoAgendadoPK();

    private BigDecimal valor;
    private BigDecimal quantidade;
    private BigDecimal desconto;

    public ProcedimentoAgendado() {
    }

    /**
     * ProcedimentoAgendado
     * 
     * @param procedimento - Procedimento
     * @param agendamento  - Agendamento
     * @param valor        - BigDecimal
     * @param quantidade   - BigDecimal
     * @param desconto     - BigDecimal
     */
    public ProcedimentoAgendado(Procedimento procedimento, Agendamento agendamento, BigDecimal valor, BigDecimal quantidade, BigDecimal desconto) {
        this();
        this.id.setProcedimento(procedimento);
        this.id.setAgendamento(agendamento);
        this.valor = valor;
        this.quantidade = quantidade;
        this.desconto = desconto;
    }

    public Procedimento getProcedimento() {
        return this.id.getProcedimento();
    }

    @JsonIgnore
    public Agendamento getAgendamento() {
        return this.id.getAgendamento();
    }

    public ProcedimentoAgendadoPK getId() {
        return id;
    }

    public void setId(ProcedimentoAgendadoPK id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
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
        ProcedimentoAgendado other = (ProcedimentoAgendado) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
