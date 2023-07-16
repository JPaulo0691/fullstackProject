package com.br.helpdeskapi.validacoes.Cliente;

import com.br.helpdeskapi.customException.exceptionHandler.exception.TecnicoException.CpfAlreadyCreatedException;
import com.br.helpdeskapi.dtos.request.ClienteRequest;
import com.br.helpdeskapi.dtos.request.TecnicoRequest;
import com.br.helpdeskapi.repository.PessoaRepository;
import com.br.helpdeskapi.validacoes.Tecnico.IValidDadosGeraisTecnico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidClienteCPFCadastrado implements IClienteValidDadosGerais {

    @Autowired
    PessoaRepository pessoaRepository;

    @Override
    public void validDadosGerais(ClienteRequest cliente) {
        boolean cpfJaExiste = this.pessoaRepository.existsByCpf(cliente.getCpf());

        if (cpfJaExiste == true){
            throw new CpfAlreadyCreatedException(cliente.getCpf());
        }
    }
}
