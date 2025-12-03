package ifsuldeminas.pas.bcc.biblioteca.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    // ----------------------------------------------------
    // CORREÇÃO: ADICIONANDO O CAMPO DE CHAVE PRIMÁRIA (@Id)
    // ----------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Atributos baseados no diagrama
    @Column(nullable = false)
    @NotBlank
    private String nome; //

    @Column(unique = true, nullable = false)
    @NotNull
    private String cpf; //

    @Column(unique = true)
    @NotBlank
    private String email; //

    private String telefone; //

    // Mapeamento do relacionamento com Endereco: 
    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private Endereco endereco;

    @OneToOne
    Reserva reserva;

    // ----------------------------------------------------
    // GETTERS & SETTERS
    // ----------------------------------------------------
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}
