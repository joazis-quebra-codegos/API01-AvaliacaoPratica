package org.example.eventos.repository;

import org.example.eventos.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    List<Evento> findByLocalEventoId(Long id);
    List<Evento> findByNomeContainingIgnoreCase(String nome);

    // TODO: criar método para filtrar eventos pelo nome.

    //TODO: criar método para listar eventos de um determinado local.

}
