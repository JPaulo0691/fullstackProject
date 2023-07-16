package com.br.helpdeskapi.dtos.response;

import com.br.helpdeskapi.domain.entity.Cliente;
import com.br.helpdeskapi.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ClienteResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    protected Integer id;
    protected String nome;
    protected String email;
    protected Set<Integer> perfis = new HashSet<>();
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCriacao;

    public ClienteResponse(){}

    public ClienteResponse(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.perfis = cliente.getPerfis().stream().map(perfil -> perfil.getCodigo()).collect(Collectors.toSet());
        this.dataCriacao = cliente.getDataCriacao();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Set<Perfil> getPerfis() {
        return perfis.stream().map(perfil -> Perfil.toEnum(perfil)).collect(Collectors.toSet());
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }


}
