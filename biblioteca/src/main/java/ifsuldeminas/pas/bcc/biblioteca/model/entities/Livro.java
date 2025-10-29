package ifsuldeminas.pas.bcc.biblioteca.model.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String isbn;
    private String editora;
    private Integer anoPublicacao;
    private Integer paginas;
    private String idioma;

    @ManyToMany
    @JoinTable(name = "livro_autor",
        joinColumns = @JoinColumn(name = "livro_id"),
        inverseJoinColumns = @JoinColumn(name = "autor_id"))
    private List<Autor> autores;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @OneToMany(mappedBy = "livro", cascade = CascadeType.ALL)
    private List<Exemplar> exemplares;

    // Getters e Setters
    // ...
}
