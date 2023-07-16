package com.br.helpdeskapi.domain.enums;

public enum StatusDoChamado {

    ABERTO(0, "ABERTO"),
    ANDAMENTO(1, "EM ANDAMENTO"),
    ENCERRADO(2, "ENCERRADO");

    private Integer codigo;
    private String descricao;

    StatusDoChamado(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static StatusDoChamado toEnum(Integer codigo){

        if(codigo == null){
            return null;
        }

        for (StatusDoChamado perfis: StatusDoChamado.values()){
            if (codigo.equals(perfis.getCodigo())){
                return perfis;
            }
        }

        throw new IllegalArgumentException("Status Inválido");

    }
}
