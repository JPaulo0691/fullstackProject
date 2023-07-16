package com.br.helpdeskapi.dtos.request;

import jakarta.validation.constraints.NotNull;

import java.security.PublicKey;

public class UpdateRequest {

    @NotNull(message = "o campo email é obrigatório")
    private String email;
    @NotNull(message = "O campo senha é obrigatório")
    private String senha;

    public UpdateRequest(){}

    public UpdateRequest(String email, String senha) {
        this.email = email;
        this.senha = senha;
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
}
