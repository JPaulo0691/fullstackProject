package com.br.helpdeskapi.service;

import com.br.helpdeskapi.customException.exceptionHandler.exception.TecnicoException.TecnicoComChamadoAtivoException;
import com.br.helpdeskapi.customException.exceptionHandler.exception.TecnicoException.TecnicoNotFoundException;
import com.br.helpdeskapi.domain.entity.Tecnico;
import com.br.helpdeskapi.dtos.request.UpdateRequest;
import com.br.helpdeskapi.dtos.request.TecnicoRequest;
import com.br.helpdeskapi.dtos.response.TecnicoResponse;
import com.br.helpdeskapi.repository.TecnicoRepository;
import com.br.helpdeskapi.validacoes.Tecnico.IValidDadosGeraisTecnico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private List<IValidDadosGeraisTecnico> validadorDeDados;

    public Tecnico cadastrarTecnico(TecnicoRequest tecnicoRequest){

        this.validDadosCadstrais(tecnicoRequest);
        return this.tecnicoRepository.save(new Tecnico(tecnicoRequest));
    }

    public void validDadosCadstrais(TecnicoRequest tecnicoRequest){
        validadorDeDados.forEach(validar -> validar.validarDados(tecnicoRequest));
    }

    public Tecnico findTecnicoById(Integer id){
        return tecnicoRepository.findById(id)
                                .orElseThrow(() -> new TecnicoNotFoundException(id));
    }

    public List<TecnicoResponse> findAllTecnico(){

        return this.tecnicoRepository.findAll()
                                     .stream()
                                     .map(listTecnico -> new TecnicoResponse(listTecnico))
                                     .collect(Collectors.toList());
    }

    public Tecnico updateTecnico(Integer id, UpdateRequest updateRequest){
        var tecnico = this.tecnicoRepository.findById(id);

        if (!tecnico.isPresent()){
            throw new TecnicoNotFoundException(id);
        }
        else {
            var atualizarDados = tecnico.get();
            atualizarDados.setEmail(updateRequest.getEmail());
            atualizarDados.setSenha(updateRequest.getSenha());

            return this.tecnicoRepository.save(atualizarDados);
        }
    }

    public void deleteTecnicoById(Integer id){

        var tecnico = this.tecnicoRepository.findById(id);

        if(tecnico.get().getChamados().size() > 0){
            throw new TecnicoComChamadoAtivoException(id);
        }
        this.tecnicoRepository.deleteById(id);
    }
}
