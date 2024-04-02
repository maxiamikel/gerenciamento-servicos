package com.maxi.gerenciamento.apiGerenciamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxi.gerenciamento.apiGerenciamento.domains.Pessoa;
import com.maxi.gerenciamento.apiGerenciamento.domains.Tecnico;
import com.maxi.gerenciamento.apiGerenciamento.dtos.TecnicoDTO;
import com.maxi.gerenciamento.apiGerenciamento.repositories.PessoaRepository;
import com.maxi.gerenciamento.apiGerenciamento.repositories.TecnicoRepository;
import com.maxi.gerenciamento.apiGerenciamento.services.exceptions.DataIntegrityViolationException;
import com.maxi.gerenciamento.apiGerenciamento.services.exceptions.ObjectNotFoundException;

import jakarta.validation.Valid;

@Service
public class TecnicoService {
    
    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Tecnico findById(Integer id){
        Optional<Tecnico> obj = tecnicoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID:"+ id));
    }

    public List<Tecnico> findAll(){
        return tecnicoRepository.findAll();
    }

    public Tecnico create(TecnicoDTO obj) {
        obj.setId(null);
        Tecnico newObj = new Tecnico(obj);
        validateIfExistCpfAndEmail(obj);
        return tecnicoRepository.save(newObj);
    }

    private void validateIfExistCpfAndEmail(TecnicoDTO objDto) {
        Optional<Pessoa> obj = pessoaRepository.findByCpf(objDto.getCpf());
       
        if(obj.isPresent() && obj.get().getId() != objDto.getId()){
            throw new DataIntegrityViolationException("O CPF já esta cadastrado no sistema");
        }

        obj =  pessoaRepository.findByEmail(objDto.getEmail());
        if(obj.isPresent() && obj.get().getId() != objDto.getId()){
            throw new DataIntegrityViolationException("O email já esta cadastrado no sistema");
        }
    }

    public Tecnico update(Integer id, @Valid TecnicoDTO objDTO) {
        Tecnico tecnicoDB = findById(id);
        validateIfExistCpfAndEmail(objDTO);
        tecnicoDB = new Tecnico(objDTO);
        return tecnicoRepository.save(tecnicoDB);
    }

    public void delete(Integer id) {
       Tecnico tecnicoDB = findById(id);
    
       if(tecnicoDB.getAtendimentos().size() > 0){
         throw new DataIntegrityViolationException("Tecnico possui dependencia no seu nome, não pode ser deletado");
       }
       tecnicoRepository.deleteById(id);
    }

}
