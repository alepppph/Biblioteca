package ifsuldeminas.pas.bcc.biblioteca.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "endereco")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    // O Endereco não tem um ID próprio no diagrama, mas por ser uma Entity,
    // é necessário um ID para o JPA, ou deve ser mapeado como @Embeddable.
    // Usaremos um ID simples para simplificar o mapeamento @OneToOne.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Atributos baseados no diagrama [cite: 109-115]
    private String rua; // [cite: 109]
    private String numero; // [cite: 110]
    private String complemento; // [cite: 111]
    private String bairro; // [cite: 112]
    private String cidade; // [cite: 113]
    private String estado; // [cite: 114]
    private String cep; // [cite: 115]
    
    // Mapeamento do relacionamento com Pessoa: 
    // Endereco tem uma chave estrangeira para Pessoa
    // Relacionamento 1 Endereco para 1 Pessoa.
    @OneToOne 
    // Define a coluna de chave estrangeira (FK) na tabela 'endereco'
    @JoinColumn(name = "pessoa_id", unique = true, nullable = false) 
    private Pessoa pessoa;
}