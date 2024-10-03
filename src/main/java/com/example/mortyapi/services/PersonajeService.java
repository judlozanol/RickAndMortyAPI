package com.example.mortyapi.services;

import com.example.mortyapi.models.PersonajeDTO;
import com.example.mortyapi.models.ResultadoDTO;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class PersonajeService {

    private Logger logger = LoggerFactory.getLogger(PersonajeService.class);

    private HttpClient client;

    public PersonajeService(@Autowired HttpClient client) {
        this.client = client;
    }

    public void getPersonajeByName(String name) throws NullPointerException{
        ObjectMapper mapper = new ObjectMapper();
        StringBuilder url = new StringBuilder("https://rickandmortyapi.com/api/character/");
        url.append("?name=" + name);
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url.toString())).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            logger.info(response.body());
            ResultadoDTO p = mapper.readValue(response.body(), ResultadoDTO.class);
            PersonajeDTO pj = p.results().get(0);
            logger.info(pj.toString());
            mapper.setDefaultPrettyPrinter(new DefaultPrettyPrinter(DefaultPrettyPrinter.DEFAULT_SEPARATORS));
            mapper.writeValue(new File("src/main/resources/personaje.json"), pj);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
