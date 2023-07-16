package com.br.helpdeskapi.domain.entity;

import com.br.helpdeskapi.domain.enums.Perfil;
import com.br.helpdeskapi.dtos.request.ClienteRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Cliente extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Chamado> chamados = new ArrayList<>();

    public Cliente() {
        addPerfil(Perfil.CLIENTE);
    }

    public Cliente(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
        addPerfil(Perfil.CLIENTE);
    }

    public Cliente(ClienteRequest clienteRequest){
        this.nome = clienteRequest.getNome();
        this.cpf = clienteRequest.getCpf();
        this.email = clienteRequest.getEmail();
        this.senha = clienteRequest.getSenha();
        this.perfis = clienteRequest.getPerfis().stream().map(perfil -> perfil.getCodigo()).collect(Collectors.toSet());
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }
}

/*
    REGRA -> A classe cliente pode ter nenhum ou vários chamados.
*/