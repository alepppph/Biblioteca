package ifsuldeminas.pas.bcc.biblioteca.model.entities;

import jakarta.persistence.*;

//Um exemplar está relacionado a apenas um emprestimo,
//e um emprestimo deve estar relacionado a um exemplar de um livro.
@Entity
public class Exemplar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String codigoBarra;
    private String estado;
    private String statusDisponibilidade;
    @OneToOne // Relacionamento com Exemplar (1:1): unidirecional
    Emprestimo emprestimo;
    @ManyToOne
    Livro livro;
}
