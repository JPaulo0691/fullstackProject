package com.br.helpdeskapi.dtos.response;

import com.br.helpdeskapi.domain.entity.Chamado;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;

public class ChamadoResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAbertura = LocalDate.now();
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFechamento;
    private String prioridade;
    private String status;
    private String titulo;
    private String observacoes;

    private String nomeCliente;
    private Integer codTecnico;
    private String nomeTecnico;

    public ChamadoResponse(){}

    public ChamadoResponse(Chamado chamado){
        this.id = chamado.getId();
        this.dataAbertura  = chamado.getDataAbertura();
        if(chamado.getDataFechamento() == null){
            this.dataFechamento = LocalDate.of(2999,2,2);
        }
        else{
            this.dataFechamento = chamado.getDataFechamento();
        }
        this.prioridade = chamado.getPrioridade().getDescricao();
        this.status = chamado.getStatus().getDescricao();
        this.titulo = chamado.getTitulo();
        this.observacoes = chamado.getObservacoes();
        this.nomeCliente = chamado.getCliente().getNome();
        this.codTecnico = chamado.getTecnico().getId();
        this.nomeTecnico = chamado.getTecnico().getNome();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDate getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(LocalDate dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Integer getCodTecnico() {
        return codTecnico;
    }

    public void setCodTecnico(Integer codTecnico) {
        this.codTecnico = codTecnico;
    }

    public String getNomeTecnico() {
        return nomeTecnico;
    }

    public void setNomeTecnico(String nomeTecnico) {
        this.nomeTecnico = nomeTecnico;
    }
}
