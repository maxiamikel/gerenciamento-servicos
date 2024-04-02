package com.maxi.gerenciamento.apiGerenciamento.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maxi.gerenciamento.apiGerenciamento.domains.Tecnico;
import com.maxi.gerenciamento.apiGerenciamento.domains.enums.Perfil;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class TecnicoDTO implements Serializable{
    private static final long serialVersionUID=1L;

    protected Integer id;
    @NotNull(message = "O nome é requerido")
    @NotEmpty(message="O nome não pode ser vazio")
    protected String nome;
    @NotNull(message = "O CPF é requerido")
    @NotEmpty(message="O CPF não pode ser vazio")
    @CPF(message = "CPF inválido")
    protected String cpf;
    @NotNull(message = "O email é requerido")
    @Email(message = "O email não é válido")
    protected String email;
    @NotNull(message = "A senha é requerida")
    @NotEmpty(message="A senha não pode ser vazia")
    protected String senha;
    protected Set<Integer> perfils = new HashSet<>();

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCadastro = LocalDate.now();

    public TecnicoDTO() {
        super();
    }

    public TecnicoDTO(Tecnico obj) {
        super();
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.perfils = obj.getPerfils().stream().map( x -> x.getCodigo()).collect(Collectors.toSet());
        this.dataCadastro = obj.getDataCadastro();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Perfil> getPerfils() {
        return perfils.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

    public void addPerfil(Perfil perfil) {
        this.perfils.add(perfil.getCodigo());
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    

}
