package org.example.eventos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record EventoRequestDTO(

        //TODO: colocar validações de entrada de dados
        @NotBlank(message = "Nome é obrigatório")
        String nome,

        @NotBlank(message = "Descricão é obrigatória")
        String descricao,

        @NotEmpty(message = "Data do evento é obrigatória")
        LocalDate dataEvento,

        @NotNull(message = "Valor do ingresso é obrigatório")
        Double valorIngresso,

        @NotNull(message = "Local é obrigatório")
        Long localId
) {
}
