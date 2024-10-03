package com.example.mortyapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.reflect.Array;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ResultadoDTO(@JsonProperty("results") ArrayList<PersonajeDTO> results) {

}
