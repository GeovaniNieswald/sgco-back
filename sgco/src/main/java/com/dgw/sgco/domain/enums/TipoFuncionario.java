package com.dgw.sgco.domain.enums;

/**
 * TipoFuncionario
 */
public enum TipoFuncionario {

    SECRETARIA(0, "Secretária"), DENTISTA(1, "Dentista");

    private Integer cod;
    private String descricao;

    /**
     * ENUM - Tipo de Funcionário
     * 
     * @param cod       - Integer
     * @param descricao - String
     */
    private TipoFuncionario(Integer cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public Integer getCod() {
        return this.cod;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static TipoFuncionario toEnum(Integer cod) {
        if (cod == null)
            return null;

        for (TipoFuncionario x : TipoFuncionario.values()) {
            if (cod.equals(x.getCod()))
                return x;
        }

        throw new IllegalArgumentException("Código inválido: " + cod);
    }
}
