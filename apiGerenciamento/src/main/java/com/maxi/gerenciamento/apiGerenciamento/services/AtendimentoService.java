package com.maxi.gerenciamento.apiGerenciamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxi.gerenciamento.apiGerenciamento.domains.Atendimento;
import com.maxi.gerenciamento.apiGerenciamento.repositories.AtendimentoRepository;
import com.maxi.gerenciamento.apiGerenciamento.services.exceptions.ObjectNotFoundException;

@Service
public class AtendimentoService {
    
    @Autowired
    private AtendimentoRepository atendimentoRepository;

    public Atendimento findById(Integer id){
        Optional<Atendimento> obj = atendimentoRepository.findById(id);
        return obj.orElseThrow( () -> new ObjectNotFoundException("Atendimento não encontrado, ID:"+id));
    }

    public List<Atendimento> findAll() {
        return atendimentoRepository.findAll();
    }

    
}
