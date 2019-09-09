package com.dgw.sgco.domain.enums;

/**
 * StatusParcela
 */
public enum StatusParcela {

    CRIADA(0, "Criada"), PAGA(1, "Paga"), CANCELADA(2, "Cancelada");

    private Integer cod;
    private String descricao;

    /**
     * ENUM - Status Parcela
     * 
     * @param cod       - Integer
     * @param descricao - String
     */
    private StatusParcela(Integer cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public Integer getCod() {
        return this.cod;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static StatusParcela toEnum(Integer cod) {
        if (cod == null)
            return null;

        for (StatusParcela x : StatusParcela.values()) {
            if (cod.equals(x.getCod()))
                return x;
        }

        throw new IllegalArgumentException("Código inválido: " + cod);
    }
}
