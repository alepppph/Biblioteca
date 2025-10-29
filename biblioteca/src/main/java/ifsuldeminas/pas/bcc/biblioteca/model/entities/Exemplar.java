package ifsuldeminas.pas.bcc.biblioteca.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "exemplares")
public class Exemplar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigoBarra;
    private String estado;
    private String statusDisponibilidade;

    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;

    // Getters e Setters
    // ...
}
    