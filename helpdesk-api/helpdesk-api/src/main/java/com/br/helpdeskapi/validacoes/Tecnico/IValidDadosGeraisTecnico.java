package com.br.helpdeskapi.validacoes.Tecnico;

import com.br.helpdeskapi.domain.entity.Pessoa;
import com.br.helpdeskapi.domain.entity.Tecnico;
import com.br.helpdeskapi.dtos.request.TecnicoRequest;

public interface IValidDadosGeraisTecnico {

    void validarDados(TecnicoRequest tecnico);
}
