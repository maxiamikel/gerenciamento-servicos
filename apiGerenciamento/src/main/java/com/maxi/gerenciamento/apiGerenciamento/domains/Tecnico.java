package com.maxi.gerenciamento.apiGerenciamento.domains;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.maxi.gerenciamento.apiGerenciamento.domains.enums.Perfil;
import com.maxi.gerenciamento.apiGerenciamento.dtos.TecnicoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tecnicos")
public class Tecnico extends Pessoa{
    private static final long serialVersionUID=1L;

    @JsonIgnore
    @OneToMany(mappedBy = "tecnico")
    private List<Atendimento> atendimentos = new ArrayList<>() ;


    public Tecnico() {
        super();
        addPerfil(Perfil.CLIENTE);
    }

    public Tecnico(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
        addPerfil(Perfil.CLIENTE);
    }

    public Tecnico(TecnicoDTO obj) {
        super();
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.perfils = obj.getPerfils().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
        this.dataCadastro = obj.getDataCadastro();
        addPerfil(Perfil.CLIENTE);
    }

    public List<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(List<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }

    

}
