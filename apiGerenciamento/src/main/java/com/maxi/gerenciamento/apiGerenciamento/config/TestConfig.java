package com.maxi.gerenciamento.apiGerenciamento.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.maxi.gerenciamento.apiGerenciamento.services.DbServiceInicializar;

@Configuration
@Profile("test")
public class TestConfig {
    
    @Autowired
    private DbServiceInicializar dbInittializar;

    @Bean
    public String initializar(){
        this.dbInittializar.initializarBD();
        return "ok";
    }
}
