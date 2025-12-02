package com.biblioteca.demo.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título é obrigatório.")
    @Size(min = 2, max = 150, message = "O título deve ter entre 2 e 150 caracteres.")
    private String titulo;

    @NotBlank(message = "O autor é obrigatório.")
    private String autor;

    @NotBlank(message = "O ISBN é obrigatório.")
    @Pattern(regexp = "\\d{13}", message = "O ISBN deve conter exatamente 13 números.")
    private String isbn;

    @NotNull(message = "O ano não pode ser nulo.")
    @Min(value = 1500, message = "Ano inválido.")
    @Max(value = 2100, message = "Ano inválido.")
    private Integer ano;

    @NotBlank(message = "A categoria é obrigatória.")
    private String categoria;

    public Livro() {}

    public Livro(String titulo, String autor, String isbn, Integer ano, String categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.ano = ano;
        this.categoria = categoria;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public Integer getAno() { return ano; }
    public void setAno(Integer ano) { this.ano = ano; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
}
