package org.example.eventos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TBEVENTO")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEvento")
    private Long id;

    private String nome;

    private String descricao;

    //exemplo = "2026-05-19"
    private LocalDate dataEvento;

    private Double valorIngresso;

    //TO DO: corrigir o relacionamento entre Evento e LocalEvento
    @ManyToOne
    @JoinColumn(name = "localEvento")
    private Long localId;

}


