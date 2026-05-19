package org.example.eventos.dto;

public record InscricaoResponseDTO(

        Long id,

        String nomeParticipante,

        String emailParticipante,

        String status,

        Long idEvento,

        String nomeEvento
) {}
