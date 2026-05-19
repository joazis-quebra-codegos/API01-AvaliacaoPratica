package org.example.eventos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "TBLOCALEVENTO")
public class LocalEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLocal")
    private Long id;

    private String nome;

    private String endereco;

    @OneToMany(mappedBy = "localEvento")
    private List<Evento> eventos = new ArrayList<>;

    private Integer capacidade;
}
