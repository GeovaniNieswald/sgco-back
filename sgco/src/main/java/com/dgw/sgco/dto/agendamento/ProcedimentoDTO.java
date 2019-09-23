package com.dgw.sgco.dto.agendamento;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;

import com.dgw.sgco.domain.agendamento.Procedimento;

import org.hibernate.validator.constraints.Length;

/**
 * ProcedimentoDTO
 */
public class ProcedimentoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 100, message = "O tamanho deve ser entre 5 e 100 caracteres")
    private String nome;

    private BigDecimal valor;
    private boolean ativo;

    public ProcedimentoDTO() {
    }

    /**
     * 
     * @param obj - Procedimento
     */
    public ProcedimentoDTO(Procedimento obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.valor = obj.getValor();
        this.ativo = obj.isAtivo();
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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}
