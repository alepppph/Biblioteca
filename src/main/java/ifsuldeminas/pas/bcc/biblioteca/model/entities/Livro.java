package ifsuldeminas.pas.bcc.biblioteca.model.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

//um livro pode possuir 0 ou mais exemplares, mas um exemplar ("parte") é referente a apenas um livro.
//um livro tem uma categoria, e uma categoria pode ser referente a N livros - (1-N);

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String isbn;
    private String editora;
    private Date anoPublicacao;
    private Integer qtdPaginas;
    private String idioma;
    @OneToMany(mappedBy = "exemplar")
    Set<Exemplar> exemplares;
    @ManyToMany
    Set<Autor> autores;

    //Getters dos Atributos de Livro
    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getEditora() {
        return editora;
    }

    public Date getAnoPublicacao() {
        return anoPublicacao;
    }

    public Integer getQtdPaginas() {
        return qtdPaginas;
    }

    public String getIdioma() {
        return idioma;
    }

    public Set<Exemplar> getExemplares() {
        return exemplares;
    }

    public Set<Autor> getAutores() {
        return autores;
    }
    //Setters dos Atributos de Livro
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setAnoPublicacao(Date anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setQtdPaginas(Integer qtdPaginas) {
        this.qtdPaginas = qtdPaginas;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
}
