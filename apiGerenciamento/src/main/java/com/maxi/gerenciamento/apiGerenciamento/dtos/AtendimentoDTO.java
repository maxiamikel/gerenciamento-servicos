package com.maxi.gerenciamento.apiGerenciamento.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maxi.gerenciamento.apiGerenciamento.domains.Atendimento;
import com.maxi.gerenciamento.apiGerenciamento.domains.enums.Status;

public class AtendimentoDTO implements Serializable{

    private static final long serialVersionUID=1L;

     private Integer id;
     @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAbertura = LocalDate.now();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFechamento;
    private Integer prioridade;
    private Status status;
    private String titulo;
    private String observacao;
    private Integer idTecnico;
    private Integer idCliente;
    private String nomeTecnico;
    private String nomeCliente;

    public AtendimentoDTO() {
        super();
    }

    public AtendimentoDTO(Atendimento obj) {
        this.id = obj.getId();
        this.dataAbertura = obj.getDataAbertura();
        this.dataFechamento = obj.getDataFechamento();
        this.prioridade = obj.getPrioridade().getCodigo();
        this.status = obj.getStatus();
        this.titulo = obj.getTitulo();
        this.observacao = obj.getObservacao();
        this.idTecnico = obj.getTecnico().getId();
        this.idCliente = obj.getCliente().getId();
        this.nomeTecnico = obj.getTecnico().getNome();
        this.nomeCliente = obj.getCliente().getNome();
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
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

    public Integer getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Integer getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(Integer idTecnico) {
        this.idTecnico = idTecnico;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeTecnico() {
        return nomeTecnico;
    }

    public void setNomeTecnico(String nomeTecnico) {
        this.nomeTecnico = nomeTecnico;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    
    
}
