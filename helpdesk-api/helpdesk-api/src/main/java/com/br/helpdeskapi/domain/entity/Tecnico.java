package com.br.helpdeskapi.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class Tecnico extends Pessoa{

    private List<Chamado> chamados = new ArrayList<>();

    public Tecnico() {
    }

    public Tecnico(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }

}

/*
    REGRA -> A classe técnico pode ter nenhum ou vários chamados.
 */