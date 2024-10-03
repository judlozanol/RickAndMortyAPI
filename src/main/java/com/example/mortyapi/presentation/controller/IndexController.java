package com.example.mortyapi.presentation.controller;

import com.example.mortyapi.models.PersonajeDTO;
import com.example.mortyapi.services.PersonajeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;


@Controller
public class IndexController {
    private Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private PersonajeService personajeService;

    @RequestMapping(path = "/cuestionario", method = RequestMethod.GET)
    public String indexController(Model model) {
        //model.addAttribute("hola", "Sapo");
        return "index";
    }

    @GetMapping(path = "/mostrardatos")
    public String mostrarDatos(HttpServletRequest request, Model model) {
        String nombre = request.getParameter("name");
        try {
            personajeService.getPersonajeByName(nombre);
            ObjectMapper mapper = new ObjectMapper();
            PersonajeDTO personajeDTO = null;
            personajeDTO = mapper.readValue(new File("src/main/resources/personaje.json"), PersonajeDTO.class);
            model.addAttribute("name", personajeDTO.name());
            model.addAttribute("id", personajeDTO.id());
            model.addAttribute("status", personajeDTO.status());
            model.addAttribute("species", personajeDTO.species());
            return "entrega";
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NullPointerException e) {
            return "error";
        }

    }

}
