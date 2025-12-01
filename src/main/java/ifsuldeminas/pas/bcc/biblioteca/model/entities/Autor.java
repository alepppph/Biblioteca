package ifsuldeminas.pas.bcc.biblioteca.model.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String biografia;
    @ManyToMany(mappedBy = "livros")
    Set<Livro> livros;
}
