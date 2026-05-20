package org.example.eventos.repository;

import org.example.eventos.model.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {
    public List<Inscricao> findByEventoId(Long id);
}
