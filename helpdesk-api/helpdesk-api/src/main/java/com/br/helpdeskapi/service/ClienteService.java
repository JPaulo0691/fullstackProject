package com.br.helpdeskapi.service;

import com.br.helpdeskapi.customException.exceptionHandler.exception.ClienteException.ClientNotFoundException;
import com.br.helpdeskapi.customException.exceptionHandler.exception.TecnicoException.TecnicoComChamadoAtivoException;
import com.br.helpdeskapi.customException.exceptionHandler.exception.TecnicoException.TecnicoNotFoundException;
import com.br.helpdeskapi.domain.entity.Cliente;
import com.br.helpdeskapi.domain.entity.Tecnico;
import com.br.helpdeskapi.dtos.request.ClienteRequest;
import com.br.helpdeskapi.dtos.request.UpdateRequest;
import com.br.helpdeskapi.dtos.response.ClienteResponse;
import com.br.helpdeskapi.dtos.response.TecnicoResponse;
import com.br.helpdeskapi.repository.ClienteRepository;
import com.br.helpdeskapi.repository.PessoaRepository;
import com.br.helpdeskapi.validacoes.Cliente.IClienteValidDadosGerais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    PessoaRepository pessoaRepository;
    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    List<IClienteValidDadosGerais> validarDados;

    public Cliente create(ClienteRequest clienteRequest){
        this.validDadosCadastrais(clienteRequest);
        return this.clienteRepository.save(new Cliente(clienteRequest));
    }

    public void validDadosCadastrais(ClienteRequest clientRequest){
        validarDados.forEach(validar -> validar.validDadosGerais(clientRequest));
    }

    public Cliente findClientById(Integer id){
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));
    }

    public List<ClienteResponse> findAllClient(){

        return this.clienteRepository.findAll()
                .stream()
                .map(listClient -> new ClienteResponse(listClient))
                .collect(Collectors.toList());
    }

    public Cliente updateCliente(Integer id, ClienteRequest updateRequest){
        var cliente = this.clienteRepository.findById(id);

        if (!cliente.isPresent()){
            throw new ClientNotFoundException(id);
        }
        else {
            var atualizarDados = cliente.get();
            atualizarDados.setEmail(updateRequest.getEmail());
            atualizarDados.setSenha(updateRequest.getSenha());

            return this.clienteRepository.save(atualizarDados);
        }
    }

    public void deleteClientById(Integer id){

        var cliente = this.clienteRepository.findById(id);

        if(cliente.get().getChamados().size() > 0){
            throw new DataIntegrityViolationException("Cliente Possui um chamado ativo");
        }
        this.clienteRepository.deleteById(id);
    }

}
