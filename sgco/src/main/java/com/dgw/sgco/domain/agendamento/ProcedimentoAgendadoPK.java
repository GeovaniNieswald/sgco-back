package com.dgw.sgco.domain.agendamento;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * ProcedimentoAgendadoPK
 */
@Embeddable
public class ProcedimentoAgendadoPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "id_procedimento")
    private Procedimento procedimento;

    @ManyToOne
    @JoinColumn(name = "id_agendamento")
    private Agendamento agendamento;

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((agendamento == null) ? 0 : agendamento.hashCode());
        result = prime * result + ((procedimento == null) ? 0 : procedimento.hashCode());
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
        ProcedimentoAgendadoPK other = (ProcedimentoAgendadoPK) obj;
        if (agendamento == null) {
            if (other.agendamento != null)
                return false;
        } else if (!agendamento.equals(other.agendamento))
            return false;
        if (procedimento == null) {
            if (other.procedimento != null)
                return false;
        } else if (!procedimento.equals(other.procedimento))
            return false;
        return true;
    }

}
