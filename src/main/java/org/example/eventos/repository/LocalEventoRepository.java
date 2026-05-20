package org.example.eventos.repository;

import org.example.eventos.model.Evento;
import org.example.eventos.model.LocalEvento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocalEventoRepository extends JpaRepository<LocalEvento, Long> {
}
