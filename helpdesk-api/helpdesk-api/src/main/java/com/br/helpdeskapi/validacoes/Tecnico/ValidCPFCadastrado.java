package com.br.helpdeskapi.validacoes.Tecnico;

import com.br.helpdeskapi.customException.exceptionHandler.exception.TecnicoException.CpfAlreadyCreatedException;
import com.br.helpdeskapi.dtos.request.TecnicoRequest;
import com.br.helpdeskapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidCPFCadastrado implements IValidDadosGeraisTecnico{

    @Autowired
    PessoaRepository pessoaRepository;

    @Override
    public void validarDados(TecnicoRequest tecnico) {
        boolean cpfJaExiste = this.pessoaRepository.existsByCpf(tecnico.getCpf());

        if (cpfJaExiste == true){
            throw new CpfAlreadyCreatedException(tecnico.getCpf());
        }
    }
}
