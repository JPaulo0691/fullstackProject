package com.br.helpdeskapi.service;

import com.br.helpdeskapi.domain.entity.Chamado;
import com.br.helpdeskapi.domain.enums.Prioridade;
import com.br.helpdeskapi.domain.enums.StatusDoChamado;
import com.br.helpdeskapi.dtos.request.ChamadoRequest;
import com.br.helpdeskapi.dtos.response.ChamadoResponse;
import com.br.helpdeskapi.repository.ChamadoRepository;
import com.br.helpdeskapi.repository.TecnicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository chamadoRepository;
    @Autowired
    private TecnicoService tecnicoService;
    @Autowired
    private ClienteService clienteService;

    public List<ChamadoResponse> findAllChamados(){
        return this.chamadoRepository.findAll().stream()
                                               .map(chamados -> new ChamadoResponse(chamados))
                                               .collect(Collectors.toList());
    }
    public Chamado findChamadoById(Integer id){
        return this.chamadoRepository
                    .findById(id)
                    .orElseThrow(() ->  new RuntimeException("Chamado não foi encontrado"));
    }

    public Chamado create(@Valid ChamadoRequest chamadoRequest){
        return this.chamadoRepository.save(newChamado(chamadoRequest));
    }

    public Chamado update(Integer id, @Valid ChamadoRequest chamadoRequest) {

        chamadoRequest.setId(id);
        Chamado outdatedObject = this.findChamadoById(id);
        outdatedObject = newChamado(chamadoRequest);

        return this.chamadoRepository.save(outdatedObject);
    }

    public Chamado newChamado(ChamadoRequest chamadoRequest){

        var tecnico = tecnicoService.findTecnicoById(chamadoRequest.getTecnico());
        var cliente = clienteService.findClientById(chamadoRequest.getCliente());

        // chamado serve tanto para criar quanto para atualizar
        Chamado chamado = new Chamado();

        if(chamadoRequest.getId() != null){
            chamado.setId(chamadoRequest.getId());
        }
        if(chamadoRequest.getStatus().equals(StatusDoChamado.ENCERRADO.getCodigo())){
            chamado.setDataFechamento(LocalDate.now());
        }
        chamado.setTecnico(tecnico);
        chamado.setCliente(cliente);
        chamado.setPrioridade(Prioridade.toEnum(chamadoRequest.getPrioridade()));
        chamado.setStatus(StatusDoChamado.toEnum(chamadoRequest.getStatus()));
        chamado.setTitulo(chamadoRequest.getTitulo());
        chamado.setObservacoes(chamadoRequest.getObservacoes());

        return chamado;
    }
}
