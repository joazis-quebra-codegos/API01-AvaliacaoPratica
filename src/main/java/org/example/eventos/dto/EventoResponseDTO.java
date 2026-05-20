package org.example.eventos.dto;

import java.time.LocalDate;

public record EventoResponseDTO(

        Long id,

        String nome,

        String descricao,

        LocalDate dataEvento,

        Double valorIngresso,

        Long localId,

        String localNome,

        String endereco
) {
}
