package com.br.helpdeskapi.resources;

import com.br.helpdeskapi.domain.entity.Tecnico;
import com.br.helpdeskapi.dtos.response.TecnicoResponse;
import com.br.helpdeskapi.service.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tecnicos")
public class TecnicoController {

    @Autowired
    private TecnicoService tecnicoService;

    @GetMapping("/{id}")
    public ResponseEntity<TecnicoResponse> findByTecnicoId(@PathVariable(value = "id")Integer id){
        var tecnicoById = tecnicoService.findTecnicoById(id);

        return ResponseEntity.ok(new TecnicoResponse(tecnicoById));
    }
}
