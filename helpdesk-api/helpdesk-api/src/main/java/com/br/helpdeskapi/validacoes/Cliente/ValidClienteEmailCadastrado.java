package com.br.helpdeskapi.validacoes.Cliente;

import com.br.helpdeskapi.customException.exceptionHandler.exception.TecnicoException.EmailAlreadyCreatedException;
import com.br.helpdeskapi.dtos.request.ClienteRequest;
import com.br.helpdeskapi.dtos.request.TecnicoRequest;
import com.br.helpdeskapi.repository.PessoaRepository;
import com.br.helpdeskapi.validacoes.Tecnico.IValidDadosGeraisTecnico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidClienteEmailCadastrado implements IClienteValidDadosGerais {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public void validDadosGerais(ClienteRequest cliente) {
        boolean existsEmail = this.pessoaRepository.existsByEmail(cliente.getEmail());

        if (existsEmail == true){
            throw new EmailAlreadyCreatedException(cliente.getEmail());
        }
    }
}
