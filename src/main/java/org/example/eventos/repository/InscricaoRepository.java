package org.example.eventos.repository;

import org.example.eventos.model.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {

    //TODO: criar método para listar inscrições de um determinado evento.
}
