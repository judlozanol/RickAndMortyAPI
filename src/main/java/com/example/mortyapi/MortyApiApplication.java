package com.example.mortyapi;

import com.example.mortyapi.services.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MortyApiApplication implements CommandLineRunner {
    private PersonajeService personajeService;

    public MortyApiApplication(@Autowired PersonajeService personajeService) {
        this.personajeService = personajeService;
    }
    public static void main(String[] args) {
        SpringApplication.run(MortyApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
