package com.maxi.gerenciamento.apiGerenciamento.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxi.gerenciamento.apiGerenciamento.domains.Atendimento;
import com.maxi.gerenciamento.apiGerenciamento.dtos.AtendimentoDTO;
import com.maxi.gerenciamento.apiGerenciamento.services.AtendimentoService;

@RestController
@RequestMapping(value = "/atendimentos")
public class AtendimentoController {

    @Autowired
    private AtendimentoService atendimentoService;
    

    @GetMapping(value = "/{id}")
    public ResponseEntity<AtendimentoDTO> findById(@PathVariable Integer id){
        Atendimento obj = atendimentoService.findById(id);
        return ResponseEntity.ok().body(new AtendimentoDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<AtendimentoDTO>> findAll(){
        List<Atendimento> list = atendimentoService.findAll();
        List<AtendimentoDTO> listDTO = list.stream().map( x -> new AtendimentoDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
}
