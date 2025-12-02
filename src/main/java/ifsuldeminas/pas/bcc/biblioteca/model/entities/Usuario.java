package ifsuldeminas.pas.bcc.biblioteca.model.entities;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

//import lombok.Getter;
//import lombok.Setter;
//import lombok.NoArgsConstructor;
//import lombok.AllArgsConstructor;

import java.util.Date;
import java.util.Set;

// Esta anotação fará com que o JPA crie uma tabela 'usuario' que faz um JOIN com 'pessoa'
// Herda todos os atributos e ID de Pessoa
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Pessoa")
public class Usuario extends Pessoa {
    // Atributos específicos do Usuario [cite: 104-106]
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //@Column(unique = true, nullable = false)
    @NotNull
    private String matricula; // [cite: 104]
    @Temporal(TemporalType.DATE)
    private Date dataCadastro; // [cite: 105]
    private String tipo; // [cite: 106]
    @OneToMany
    @JoinColumn(name = "reserva_id")
    Set<Reserva> reservas;
    // Nota: Os relacionamentos com Emprestimo e Reserva serão adicionados pela Pessoa 2, 
    // mas a FK (Foreign Key) estará na classe Emprestimo e Reserva.

    //Getters dos Atributos de Usuário.
    public Long getId() {
        return id;
    }

    public String getMatricula() {
        return matricula;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public String getTipo() {
        return tipo;
    }

    public Set<Reserva> getReservas() {
        return reservas;
    }

    //Setters dos Atributos de Usuário.
    public void setId(Long id) {
        this.id = id;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setReservas(Set<Reserva> reservas) {
        this.reservas = reservas;
    }
}