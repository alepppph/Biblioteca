package ifsuldeminas.pas.bcc.biblioteca.model.entities;

import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.NoArgsConstructor;
//import lombok.AllArgsConstructor;


// Configura a herança para a classe Usuario, usando tabelas separadas para Pessoa e Usuario

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@DiscriminatorValue(value = "classe")
public class Pessoa {
    // Atributos baseados no diagrama [cite: 98-101]
    @Column(nullable = false)
    private String nome; // [cite: 98]

    @Column(unique = true, nullable = false)
    private String cpf; // [cite: 99]

    @Column(unique = true)
    private String email; // [cite: 100]

    private String telefone; // [cite: 101]

    // Mapeamento do relacionamento com Endereco: 
    // Pessoa "1" -- "0..1" Endereco: possui [cite: 117]
    // MappedBy indica que a propriedade 'pessoa' na classe Endereco é quem gerencia o relacionamento.
    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private Endereco endereco;
    @OneToOne
    Reserva reserva;
}