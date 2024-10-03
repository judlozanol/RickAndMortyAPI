package com.example.mortyapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PersonajeDTO(
        @JsonProperty("id") String id,
        @JsonProperty("name") String name,
        @JsonProperty("status") String status,
        @JsonProperty("species") String species) {
}
