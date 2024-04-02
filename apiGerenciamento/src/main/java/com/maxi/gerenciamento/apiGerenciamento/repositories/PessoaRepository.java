package com.maxi.gerenciamento.apiGerenciamento.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxi.gerenciamento.apiGerenciamento.domains.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    Optional<Pessoa> findByCpf(String cof);

    Optional<Pessoa> findByEmail(String email);
}
