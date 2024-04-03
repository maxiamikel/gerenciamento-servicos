package com.maxi.gerenciamento.apiGerenciamento.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maxi.gerenciamento.apiGerenciamento.domains.Atendimento;

import jakarta.validation.constraints.NotNull;

public class AtendimentoDTO implements Serializable{

    private static final long serialVersionUID=1L;

     private Integer id;
     @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAbertura = LocalDate.now();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFechamento;

    @NotNull(message = "A prioridade é requerida")
    private Integer prioridade;
    @NotNull(message = "O status é requerido")
    private Integer status;
    @NotNull(message = "O titulo é requerido")
    private String titulo;
    @NotNull(message = "a observação é requerida")
    private String observacao;
    @NotNull(message = "O técnico é requerido")
    private Integer tecnico;
    @NotNull(message = "O cliente é requerido")
    private Integer cliente;
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
        this.status = obj.getStatus().getCodigo();
        this.titulo = obj.getTitulo();
        this.observacao = obj.getObservacao();
        this.tecnico = obj.getTecnico().getId();
        this.cliente = obj.getCliente().getId();
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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

    public Integer getTecnico() {
        return tecnico;
    }

    public void setTecnico(Integer idTecnico) {
        this.tecnico = idTecnico;
    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer idCliente) {
        this.cliente = idCliente;
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
