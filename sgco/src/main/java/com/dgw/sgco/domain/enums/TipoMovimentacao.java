package com.dgw.sgco.domain.enums;

/**
 * TipoMovimentacao
 */
public enum TipoMovimentacao {

    CONTA_PAGAR(0, "Conta a Pagar"), CONTA_RECEBER(1, "Conta a Receber"), SALDO_ANTERIOR(2, "Saldo Anterior");

    private Integer cod;
    private String descricao;

    /**
     * ENUM - Tipo de Movimentação
     * 
     * @param cod       - Integer
     * @param descricao - String
     */
    private TipoMovimentacao(Integer cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public Integer getCod() {
        return this.cod;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static TipoMovimentacao toEnum(Integer cod) {
        if (cod == null)
            return null;

        for (TipoMovimentacao x : TipoMovimentacao.values()) {
            if (cod.equals(x.getCod()))
                return x;
        }

        throw new IllegalArgumentException("Código inválido: " + cod);
    }
}