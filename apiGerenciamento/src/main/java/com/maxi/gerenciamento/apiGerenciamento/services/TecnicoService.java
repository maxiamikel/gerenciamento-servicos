package com.maxi.gerenciamento.apiGerenciamento.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxi.gerenciamento.apiGerenciamento.domains.Tecnico;
import com.maxi.gerenciamento.apiGerenciamento.repositories.TecnicoRepository;
import com.maxi.gerenciamento.apiGerenciamento.services.exceptions.ObjectNotFoundException;

@Service
public class TecnicoService {
    
    @Autowired
    private TecnicoRepository tecnicoRepository;

    public Tecnico findById(Integer id){
        Optional<Tecnico> obj = tecnicoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID:"+ id));
    }

}
