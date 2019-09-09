package com.dgw.sgco.domain.financeiro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.dgw.sgco.domain.agendamento.Agendamento;
import com.dgw.sgco.domain.enums.StatusMovimentacao;
import com.dgw.sgco.domain.enums.TipoMovimentacao;

/**
 * Movimentacao
 */
@Entity
public class Movimentacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descricao;

    @Column(name = "cod_tipo")
    private Integer tipo;

    @Column(name = "cod_status")
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "id_conta")
    private Conta conta;

    @OneToMany(mappedBy = "movimentacao")
    private List<Parcela> parcelas = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_agendamento")
    private Agendamento agendamento;

    public Movimentacao() {
    }

    /**
     * Movimentação
     * 
     * @param id          - Integer
     * @param descricao   - String
     * @param tipo        - TipoMovimentacao
     * @param status      - StatusMovimentacao
     * @param conta       - Conta
     * @param agendamento - Agendamento
     */
    public Movimentacao(Integer id, String descricao, TipoMovimentacao tipo, StatusMovimentacao status, Conta conta, Agendamento agendamento) {
        this();
        this.id = id;
        this.descricao = descricao;
        this.tipo = (tipo == null) ? null : tipo.getCod();
        this.status = (status == null) ? null : status.getCod();
        this.conta = conta;
        this.agendamento = agendamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoMovimentacao getTipo() {
        return TipoMovimentacao.toEnum(this.tipo);
    }

    public void setTipo(TipoMovimentacao tipo) {
        this.tipo = tipo.getCod();
    }

    public StatusMovimentacao getStatus() {
        return StatusMovimentacao.toEnum(this.status);
    }

    public void setStatus(StatusMovimentacao status) {
        this.status = status.getCod();
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public List<Parcela> getParcelas() {
        return parcelas;
    }

    public void setParcelas(List<Parcela> parcelas) {
        this.parcelas = parcelas;
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
        Movimentacao other = (Movimentacao) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
