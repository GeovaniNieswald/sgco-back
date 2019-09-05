package com.dgw.sgco.domain.financeiro;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

    public Movimentacao() {
    }

    /**
     * Movimentação
     * 
     * @param id        - Integer
     * @param descricao - String
     * @param tipo      - TipoMovimentacao
     * @param status    - StatusMovimentacao
     */
    public Movimentacao(Integer id, String descricao, TipoMovimentacao tipo, StatusMovimentacao status) {
        this.id = id;
        this.descricao = descricao;
        this.tipo = (tipo == null) ? null : tipo.getCod();
        this.status = (status == null) ? null : status.getCod();
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