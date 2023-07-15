package com.br.helpdeskapi.dtos.response;

import com.br.helpdeskapi.domain.entity.Tecnico;
import com.br.helpdeskapi.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TecnicoResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    protected Integer id;
    protected String nome;
    protected String email;
    protected Set<Integer> perfis = new HashSet<>();
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCriacao;

    public TecnicoResponse(){}

    public TecnicoResponse(Tecnico tecnico) {
        this.id = tecnico.getId();
        this.nome = tecnico.getNome();
        this.email = tecnico.getEmail();
        this.perfis = tecnico.getPerfis().stream().map(perfil -> perfil.getCodigo()).collect(Collectors.toSet());
        this.dataCriacao = tecnico.getDataCriacao();
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
