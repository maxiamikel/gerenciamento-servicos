package com.maxi.gerenciamento.apiGerenciamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxi.gerenciamento.apiGerenciamento.domains.Atendimento;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Integer>{
    
}
