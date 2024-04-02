package com.maxi.gerenciamento.apiGerenciamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxi.gerenciamento.apiGerenciamento.domains.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer>{
    
}
