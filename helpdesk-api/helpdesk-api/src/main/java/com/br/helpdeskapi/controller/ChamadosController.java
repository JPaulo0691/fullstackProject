package com.br.helpdeskapi.controller;

import com.br.helpdeskapi.domain.entity.Chamado;
import com.br.helpdeskapi.dtos.request.ChamadoRequest;
import com.br.helpdeskapi.dtos.response.ChamadoResponse;
import com.br.helpdeskapi.service.ChamadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/chamados")
public class ChamadosController {

    @Autowired
    private ChamadoService chamadoService;

    @PostMapping
    public ResponseEntity<ChamadoResponse> createChamado(@Valid @RequestBody ChamadoRequest chamadoRequest){
        var chamado = this.chamadoService.create(chamadoRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ChamadoResponse(chamado));
    }

    @GetMapping
    public ResponseEntity<List<ChamadoResponse>> findAll(){
        return ResponseEntity.ok(chamadoService.findAllChamados());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChamadoResponse> findChamadoById(@PathVariable("id") Integer id){

        var chamado = this.chamadoService.findChamadoById(id);

        return ResponseEntity.ok(new ChamadoResponse(chamado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChamadoResponse> updateChamado(@PathVariable("id")Integer id
                                                       , @Valid @RequestBody ChamadoRequest chamadoRequest){

        Chamado chamado = this.chamadoService.update(id,chamadoRequest);

        return ResponseEntity.ok(new ChamadoResponse(chamado));
    }
}
