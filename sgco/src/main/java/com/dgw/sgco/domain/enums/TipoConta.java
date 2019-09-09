package com.dgw.sgco.domain.enums;

/**
 * TipoConta
 */
public enum TipoConta {

    CARTAO(0, "Cartão"), CONTA_CORRENTE(1, "Conta Corrente"), POUPANCA(2, "Poupança");

    private Integer cod;
    private String descricao;

    /**
     * ENUM - Tipo de Conta
     * 
     * @param cod       - Integer
     * @param descricao - String
     */
    private TipoConta(Integer cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public Integer getCod() {
        return this.cod;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static TipoConta toEnum(Integer cod) {
        if (cod == null)
            return null;

        for (TipoConta x : TipoConta.values()) {
            if (cod.equals(x.getCod()))
                return x;
        }

        throw new IllegalArgumentException("Código inválido: " + cod);
    }
}
