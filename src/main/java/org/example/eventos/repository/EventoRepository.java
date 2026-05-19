package org.example.eventos.repository;

import org.example.eventos.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {

    // TODO: criar método para filtrar eventos pelo nome.

    //TODO: criar método para listar eventos de um determinado local.

}
