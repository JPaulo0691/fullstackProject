package com.br.helpdeskapi.domain.entity;

import com.br.helpdeskapi.domain.enums.Perfil;
import com.br.helpdeskapi.dtos.request.UpdateRequest;
import com.br.helpdeskapi.dtos.request.TecnicoRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Tecnico extends Pessoa{

    private static final long serialVersionUID = 1L;

    @JsonIgnore // faz com que ignore esse campo
    @OneToMany(mappedBy = "tecnico")
    private List<Chamado> chamados = new ArrayList<>();

    public Tecnico() {
        addPerfil(Perfil.CLIENTE);
    }

    public Tecnico(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
        addPerfil(Perfil.CLIENTE);
    }

    public Tecnico(TecnicoRequest tecnicoRequest){
        this.nome = tecnicoRequest.getNome();
        this.cpf = tecnicoRequest.getCpf();
        this.email = tecnicoRequest.getEmail();
        this.senha = tecnicoRequest.getSenha();
        this.perfis = tecnicoRequest.getPerfis().stream().map(perfil -> perfil.getCodigo()).collect(Collectors.toSet());
    }

    public Tecnico(UpdateRequest updateRequest){
        this.email = updateRequest.getEmail();
        this.senha = updateRequest.getSenha();
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
