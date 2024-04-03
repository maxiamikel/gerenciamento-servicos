package com.maxi.gerenciamento.apiGerenciamento.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.maxi.gerenciamento.apiGerenciamento.domains.Atendimento;
import com.maxi.gerenciamento.apiGerenciamento.dtos.AtendimentoDTO;
import com.maxi.gerenciamento.apiGerenciamento.services.AtendimentoService;

import jakarta.validation.Valid;

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

    @PostMapping
    public ResponseEntity<AtendimentoDTO> create(@Valid @RequestBody AtendimentoDTO objDto){
        Atendimento obj = atendimentoService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AtendimentoDTO> update(@PathVariable Integer id, @Valid @RequestBody AtendimentoDTO obDto){
        Atendimento obj = atendimentoService.update(id, obDto);
        return ResponseEntity.ok().body(new AtendimentoDTO(obj));
    }
}
