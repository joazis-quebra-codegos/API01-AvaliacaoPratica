package org.example.eventos.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TBINSCRICAO")
public class Inscricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idInscricao")
    private Long id;

    private String nomeParticipante;

    //pode-se usar o @Email para validar no DTO!
    private String emailParticipante;

    private String status;

    @ManyToOne
    @JoinColumn(name = "evento")
    private Long idEvento;

    //TODO: transformar em entidade e colocar relacionamento

}
