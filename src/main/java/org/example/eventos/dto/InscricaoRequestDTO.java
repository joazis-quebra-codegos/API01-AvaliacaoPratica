package org.example.eventos.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InscricaoRequestDTO(

        @NotBlank
        String nome,

        @Email
        @NotBlank
        String email,

        @NotBlank
        String status,

        @NotNull
        Long idEvento
) {}
