package com.br.helpdeskapi.dtos.request;

import com.br.helpdeskapi.domain.entity.Tecnico;
import com.br.helpdeskapi.domain.enums.Perfil;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.FetchType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TecnicoRequest {

    @NotNull(message = "O campo nome é obrigatório")
    protected String nome;
    @CPF
    @NotNull(message = "O campo cpf é obrigatório")
    protected String cpf;
    @Email
    @NotNull(message = "O campo email é obrigatório")
    protected String email;
    @NotNull(message = "É necessário uma senha para se cadastrar")
    protected String senha;
    @NotNull
    protected Set<Integer> perfis = new HashSet<>();

    public TecnicoRequest(){
        addPerfil(Perfil.CLIENTE);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Perfil> getPerfis() {
        return perfis.stream()
                     .map(perfil -> Perfil.toEnum(perfil))
                     .collect(Collectors.toSet());
    }

    public void addPerfil(Perfil perfis) {
        this.perfis.add(perfis.getCodigo());
    }
}
