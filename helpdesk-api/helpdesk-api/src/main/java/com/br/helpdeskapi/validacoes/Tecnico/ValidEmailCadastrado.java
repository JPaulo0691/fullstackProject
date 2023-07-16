package com.br.helpdeskapi.validacoes.Tecnico;

import com.br.helpdeskapi.customException.exceptionHandler.exception.TecnicoException.EmailAlreadyCreatedException;
import com.br.helpdeskapi.dtos.request.TecnicoRequest;
import com.br.helpdeskapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidEmailCadastrado implements IValidDadosGeraisTecnico{

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public void validarDados(TecnicoRequest tecnico) {
        boolean existsEmail = this.pessoaRepository.existsByEmail(tecnico.getEmail());

        if (existsEmail == true){
            throw new EmailAlreadyCreatedException(tecnico.getEmail());
        }
    }
}
