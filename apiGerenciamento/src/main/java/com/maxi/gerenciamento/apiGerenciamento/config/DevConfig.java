package com.maxi.gerenciamento.apiGerenciamento.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.maxi.gerenciamento.apiGerenciamento.services.DbServiceInicializar;

@Configuration
@Profile("dev")
public class DevConfig {
    
    @Autowired
    private DbServiceInicializar dbInittializar;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String value;

    @Bean
    public String initializar(){
        if(value.equals("create")){
            this.dbInittializar.initializarBD();
            return "ok";
        }
        return "";
    }
}
