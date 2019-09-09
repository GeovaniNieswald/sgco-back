package com.dgw.sgco.domain.financeiro;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.dgw.sgco.domain.enums.StatusParcela;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Parcela
 */
@Entity
public class Parcela implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date vencimento;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date data;

    private BigDecimal valor;

    @Column(name = "cod_status")
    private Integer status;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_movimentacao")
    private Movimentacao movimentacao;

    public Parcela() {
    }

    /**
     * Parcela
     * 
     * @param id         - Integer
     * @param vencimento - Date
     * @param valor      - BigDecimal
     * @param status     - StatusParcela
     */
    public Parcela(Integer id, Date vencimento, BigDecimal valor, StatusParcela status, Movimentacao movimentacao) {
        this();
        this.id = id;
        this.vencimento = vencimento;
        this.valor = valor;
        this.status = (status == null) ? null : status.getCod();
        this.movimentacao = movimentacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public StatusParcela getStatus() {
        return StatusParcela.toEnum(this.status);
    }

    public void setStatus(StatusParcela status) {
        this.status = status.getCod();
    }

    public Movimentacao getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(Movimentacao movimentacao) {
        this.movimentacao = movimentacao;
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
        Parcela other = (Parcela) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
