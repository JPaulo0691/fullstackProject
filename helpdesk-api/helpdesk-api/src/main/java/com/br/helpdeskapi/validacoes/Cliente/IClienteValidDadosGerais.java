package com.br.helpdeskapi.validacoes.Cliente;

import com.br.helpdeskapi.dtos.request.ClienteRequest;

public interface IClienteValidDadosGerais {

    void validDadosGerais(ClienteRequest clienteRequest);
}
