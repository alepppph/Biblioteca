package ifsuldeminas.pas.bcc.biblioteca.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;

// Esta anotação fará com que o JPA crie uma tabela 'usuario' que faz um JOIN com 'pessoa'
@Entity
@Table(name = "usuario")
// Herda todos os atributos e ID de Pessoa
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor 
public class Usuario extends Pessoa {

    // Atributos específicos do Usuario [cite: 104-106]
    @Column(unique = true, nullable = false)
    private String matricula; // [cite: 104]

    @Temporal(TemporalType.DATE)
    private Date dataCadastro; // [cite: 105]

    private String tipo; // [cite: 106]
    
    // Nota: Os relacionamentos com Emprestimo e Reserva serão adicionados pela Pessoa 2, 
    // mas a FK (Foreign Key) estará na classe Emprestimo e Reserva.
}