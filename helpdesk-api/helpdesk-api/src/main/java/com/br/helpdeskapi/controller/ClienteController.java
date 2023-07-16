package com.br.helpdeskapi.controller;

import com.br.helpdeskapi.domain.entity.Cliente;
import com.br.helpdeskapi.dtos.request.ClienteRequest;
import com.br.helpdeskapi.dtos.response.ClienteResponse;
import com.br.helpdeskapi.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteResponse> cadastrar(@Valid @RequestBody ClienteRequest clienteRequest){
        Cliente cliente = this.clienteService.create(clienteRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ClienteResponse(cliente));
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> findAll(){

        return ResponseEntity.ok(this.clienteService.findAllClient());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> findByClienteId(@PathVariable(value = "id")Integer id){
        var clienteById = this.clienteService.findClientById(id);

        return ResponseEntity.ok(new ClienteResponse(clienteById));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> updateClienteById(@PathVariable(value = "id")Integer id
            , @Valid @RequestBody ClienteRequest updateRequest){
        var atualizarCliente = this.clienteService.updateCliente(id,updateRequest);

        return ResponseEntity.ok(new ClienteResponse(atualizarCliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClienteById(@PathVariable("id") Integer id){
        this.clienteService.deleteClientById(id);

        return ResponseEntity.noContent().build();
    }
}
