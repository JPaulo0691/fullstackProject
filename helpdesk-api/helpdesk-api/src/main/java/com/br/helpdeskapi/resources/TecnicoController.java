package com.br.helpdeskapi.resources;

import com.br.helpdeskapi.domain.entity.Tecnico;
import com.br.helpdeskapi.dtos.request.TecnicoRequest;
import com.br.helpdeskapi.dtos.response.TecnicoResponse;
import com.br.helpdeskapi.service.TecnicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
}
