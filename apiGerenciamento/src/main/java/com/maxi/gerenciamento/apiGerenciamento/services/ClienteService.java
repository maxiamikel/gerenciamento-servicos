package com.maxi.gerenciamento.apiGerenciamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxi.gerenciamento.apiGerenciamento.domains.Cliente;
import com.maxi.gerenciamento.apiGerenciamento.domains.Pessoa;
import com.maxi.gerenciamento.apiGerenciamento.dtos.ClienteDTO;
import com.maxi.gerenciamento.apiGerenciamento.repositories.ClienteRepository;
import com.maxi.gerenciamento.apiGerenciamento.repositories.PessoaRepository;
import com.maxi.gerenciamento.apiGerenciamento.services.exceptions.DataIntegrityViolationException;
import com.maxi.gerenciamento.apiGerenciamento.services.exceptions.ObjectNotFoundException;

import jakarta.validation.Valid;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Cliente findById(Integer id){
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID:"+ id));
    }

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    public Cliente create(ClienteDTO obj) {
        obj.setId(null);
        Cliente newObj = new Cliente(obj);
        validateIfExistCpfAndEmail(obj);
        return clienteRepository.save(newObj);
    }

    private void validateIfExistCpfAndEmail(ClienteDTO objDto) {
        Optional<Pessoa> obj = pessoaRepository.findByCpf(objDto.getCpf());
       
        if(obj.isPresent() && obj.get().getId() != objDto.getId()){
            throw new DataIntegrityViolationException("O CPF já esta cadastrado no sistema");
        }

        obj =  pessoaRepository.findByEmail(objDto.getEmail());
        if(obj.isPresent() && obj.get().getId() != objDto.getId()){
            throw new DataIntegrityViolationException("O email já esta cadastrado no sistema");
        }
    }

    public Cliente update(Integer id, @Valid ClienteDTO objDTO) {
        Cliente clienteDB = findById(id);
        validateIfExistCpfAndEmail(objDTO);
        clienteDB = new Cliente(objDTO);
        return clienteRepository.save(clienteDB);
    }

    public void delete(Integer id) {
       Cliente clienteDB = findById(id);
    
       if(clienteDB.getAtendimentos().size() > 0){
         throw new DataIntegrityViolationException("Cliente possui dependencia no seu nome, não pode ser deletado");
       }
       clienteRepository.deleteById(id);
    }

}
