package com.dgw.sgco.domain.financeiro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.dgw.sgco.domain.enums.TipoConta;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Conta
 */
@Entity
public class Conta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private boolean ativa;

    @Column(name = "cod_tipo")
    private Integer tipo;

    @JsonIgnore
    @OneToMany(mappedBy = "conta")
    private List<Movimentacao> movimentacoes = new ArrayList<>();

    public Conta() {
    }

    /**
     * Conta
     * 
     * @param id    - Integer
     * @param nome  - String
     * @param tipo  - TipoConta
     * @param ativa - boolean
     */
    public Conta(Integer id, String nome, TipoConta tipo, boolean ativa) {
        this();
        this.id = id;
        this.nome = nome;
        this.tipo = (tipo == null) ? null : tipo.getCod();
        this.ativa = ativa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoConta getTipo() {
        return TipoConta.toEnum(this.tipo);
    }

    public void setTipo(TipoConta tipo) {
        this.tipo = tipo.getCod();
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacoes(List<Movimentacao> movimentacoes) {
        this.movimentacoes = movimentacoes;
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
        Conta other = (Conta) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
