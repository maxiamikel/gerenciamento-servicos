package com.maxi.gerenciamento.apiGerenciamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxi.gerenciamento.apiGerenciamento.domains.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
    
}
