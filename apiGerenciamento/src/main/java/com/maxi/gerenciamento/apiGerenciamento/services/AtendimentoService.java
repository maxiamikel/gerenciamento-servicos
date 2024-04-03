package com.maxi.gerenciamento.apiGerenciamento.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxi.gerenciamento.apiGerenciamento.domains.Atendimento;
import com.maxi.gerenciamento.apiGerenciamento.domains.Cliente;
import com.maxi.gerenciamento.apiGerenciamento.domains.Tecnico;
import com.maxi.gerenciamento.apiGerenciamento.domains.enums.Prioridade;
import com.maxi.gerenciamento.apiGerenciamento.domains.enums.Status;
import com.maxi.gerenciamento.apiGerenciamento.dtos.AtendimentoDTO;
import com.maxi.gerenciamento.apiGerenciamento.repositories.AtendimentoRepository;
import com.maxi.gerenciamento.apiGerenciamento.services.exceptions.ObjectNotFoundException;

import jakarta.validation.Valid;

@Service
public class AtendimentoService {
    
    @Autowired
    private AtendimentoRepository atendimentoRepository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private TecnicoService tecnicoService;

    public Atendimento findById(Integer id){
        Optional<Atendimento> obj = atendimentoRepository.findById(id);
        return obj.orElseThrow( () -> new ObjectNotFoundException("Atendimento não encontrado, ID:"+id));
    }

    public List<Atendimento> findAll() {
        return atendimentoRepository.findAll();
    }

    public Atendimento create(@Valid AtendimentoDTO objDto) {
        return atendimentoRepository.save(newAtendimento(objDto));
    }

    public Atendimento update(Integer id, @Valid AtendimentoDTO obDto) {
       obDto.setId(id);
       Atendimento atendimentoDB = findById(id);
       atendimentoDB = newAtendimento(obDto);
       return atendimentoRepository.save(atendimentoDB);
    }

    private Atendimento newAtendimento(AtendimentoDTO obj){
        Tecnico tecnico = tecnicoService.findById(obj.getTecnico());
        Cliente cliente = clienteService.findById(obj.getCliente());

        Atendimento atendimento = new Atendimento();
        if(obj.getId() != null){
            atendimento.setId(obj.getId());
        }

        if(obj.getStatus().equals(2)){
            atendimento.setDataFechamento(LocalDate.now());
        }

        atendimento.setCliente(cliente);
        atendimento.setTecnico(tecnico);
        atendimento.setDataAbertura(LocalDate.now());
        atendimento.setObservacao(obj.getObservacao());
        atendimento.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
        atendimento.setStatus(Status.toEnum(obj.getStatus()));
        atendimento.setTitulo(obj.getTitulo());
        return atendimento;
    }

    
}
