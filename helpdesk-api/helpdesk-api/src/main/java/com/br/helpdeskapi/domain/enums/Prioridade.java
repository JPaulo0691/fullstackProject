package com.br.helpdeskapi.domain.enums;

public enum Prioridade {

    BAIXA(0, "BAIXA"),
    MÉDIA(1, "MÉDIA"),
    ALTA(2, "ALTA");

    private Integer codigo;
    private String descricao;

    Prioridade(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Prioridade toEnum(Integer codigo){

        if(codigo == null){
            return null;
        }

        for (Prioridade perfis: Prioridade.values()){
            if (codigo.equals(perfis.getCodigo())){
                return perfis;
            }
        }

        throw new IllegalArgumentException("Prioridade Inválida");

    }
}
