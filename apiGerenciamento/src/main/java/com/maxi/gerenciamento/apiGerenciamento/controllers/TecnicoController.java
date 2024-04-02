package com.maxi.gerenciamento.apiGerenciamento.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.maxi.gerenciamento.apiGerenciamento.domains.Tecnico;
import com.maxi.gerenciamento.apiGerenciamento.dtos.TecnicoDTO;
import com.maxi.gerenciamento.apiGerenciamento.services.TecnicoService;

@RestController
@RequestMapping(value = "/tecnicos")
public class TecnicoController {
    
    @Autowired
    private TecnicoService tecnicoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(new TecnicoDTO(tecnicoService.findById(id)));
    }

    @GetMapping
    public ResponseEntity<List<TecnicoDTO>> findAll(){
        List<Tecnico> tecnicos = tecnicoService.findAll();
        List<TecnicoDTO> listDto = tecnicos.stream().map(tec -> new TecnicoDTO(tec)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    public ResponseEntity<TecnicoDTO> create(@RequestBody TecnicoDTO obj){
        Tecnico newObj = tecnicoService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
