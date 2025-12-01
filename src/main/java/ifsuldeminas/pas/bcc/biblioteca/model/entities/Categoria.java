package ifsuldeminas.pas.bcc.biblioteca.model.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String descricao;
    @OneToMany
    @JoinColumn(name = "livro_id")
    Set<Livro> livros;
}
