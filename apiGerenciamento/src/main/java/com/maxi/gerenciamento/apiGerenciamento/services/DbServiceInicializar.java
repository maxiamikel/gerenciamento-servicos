package com.maxi.gerenciamento.apiGerenciamento.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxi.gerenciamento.apiGerenciamento.domains.Atendimento;
import com.maxi.gerenciamento.apiGerenciamento.domains.Cliente;
import com.maxi.gerenciamento.apiGerenciamento.domains.Tecnico;
import com.maxi.gerenciamento.apiGerenciamento.domains.enums.Prioridade;
import com.maxi.gerenciamento.apiGerenciamento.domains.enums.Status;
import com.maxi.gerenciamento.apiGerenciamento.repositories.AtendimentoRepository;
import com.maxi.gerenciamento.apiGerenciamento.repositories.ClienteRepository;
import com.maxi.gerenciamento.apiGerenciamento.repositories.TecnicoRepository;

@Service
public class DbServiceInicializar {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AtendimentoRepository atendimentoRepository;


    public void initializarBD() {

        Tecnico tec1 = new Tecnico(null, "Amikel Maxi", "641.922.580-99", "amikel@maxi.com", "amikel");
        Tecnico tec2 = new Tecnico(null, "Myrlande Louissaint Maxi", "073.834.340-48", "myrlande@maxi.com", "myrlande");

        Cliente cli1 = new Cliente(null, "Jean René Maxi", "230.167.570-01", "rene@maxi.com", "rene");

        tecnicoRepository.saveAll(Arrays.asList(tec1, tec2));
        clienteRepository.saveAll(Arrays.asList(cli1));

        Atendimento at1 = new Atendimento(null, Prioridade.BAIXA, Status.ABERTO, "Teste", "Testar funcionalidade", tec2,
                cli1);
        atendimentoRepository.save(at1);
    }
}
