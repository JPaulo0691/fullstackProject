package com.br.helpdeskapi.service;

import com.br.helpdeskapi.domain.entity.Tecnico;
import com.br.helpdeskapi.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    public Tecnico findTecnicoById(Integer id){
        return tecnicoRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Não existe esse técnico"));
    }
}
