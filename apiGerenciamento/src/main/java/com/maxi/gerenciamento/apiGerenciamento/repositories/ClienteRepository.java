package com.maxi.gerenciamento.apiGerenciamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxi.gerenciamento.apiGerenciamento.domains.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    
}
