package com.br.helpdeskapi.controller;

import com.br.helpdeskapi.domain.entity.Tecnico;
import com.br.helpdeskapi.dtos.request.UpdateRequest;
import com.br.helpdeskapi.dtos.request.TecnicoRequest;
import com.br.helpdeskapi.dtos.response.TecnicoResponse;
import com.br.helpdeskapi.service.TecnicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tecnicos")
public class TecnicoController {

    @Autowired
    private TecnicoService tecnicoService;

    @PostMapping
    public ResponseEntity<TecnicoResponse> cadastrar(@Valid @RequestBody TecnicoRequest tecnicoRequest){
        Tecnico tecnico = this.tecnicoService.cadastrarTecnico(tecnicoRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(new TecnicoResponse(tecnico));
    }

    @GetMapping
    public ResponseEntity<List<TecnicoResponse>> findAll(){

        return ResponseEntity.ok(this.tecnicoService.findAllTecnico());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TecnicoResponse> findByTecnicoId(@PathVariable(value = "id")Integer id){
        var tecnicoById = this.tecnicoService.findTecnicoById(id);

        return ResponseEntity.ok(new TecnicoResponse(tecnicoById));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TecnicoResponse> updateTecnicoById(@PathVariable(value = "id")Integer id
                                                            ,@Valid @RequestBody UpdateRequest updateRequest){
        var atualizarTecnico = this.tecnicoService.updateTecnico(id,updateRequest);

        return ResponseEntity.ok(new TecnicoResponse(atualizarTecnico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTecnicoById(@PathVariable("id") Integer id){
        this.tecnicoService.deleteTecnicoById(id);

        return ResponseEntity.noContent().build();
    }

}
