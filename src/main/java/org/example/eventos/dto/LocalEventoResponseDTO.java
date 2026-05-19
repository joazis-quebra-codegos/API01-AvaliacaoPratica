package org.example.eventos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record LocalEventoResponseDTO (

        Long id,

        String nome,

        String endereco,

        Integer capacidade

        //TODO: colocar dados trazidos no response
){
}
