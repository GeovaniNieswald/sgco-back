package com.dgw.sgco.domain.enums;

/**
 * StatusMovimentacao
 */
public enum StatusMovimentacao {

    CRIADA(0, "Criada"), PAGA(1, "Paga"), CANCELADA(2, "Cancelada");

    private Integer cod;
    private String descricao;

    /**
     * ENUM - Status Movimentação
     * 
     * @param cod       - Integer
     * @param descricao - String
     */
    private StatusMovimentacao(Integer cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public Integer getCod() {
        return this.cod;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static StatusMovimentacao toEnum(Integer cod) {
        if (cod == null)
            return null;

        for (StatusMovimentacao x : StatusMovimentacao.values()) {
            if (cod.equals(x.getCod()))
                return x;
        }

        throw new IllegalArgumentException("Código inválido: " + cod);
    }
}
