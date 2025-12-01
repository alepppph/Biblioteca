package ifsuldeminas.pas.bcc.biblioteca.model.entities;

import jakarta.persistence.*;

import java.util.Date;
// um usuario pode ter varios emprestimos e um emprestimo (parte) está relacionado a apenas uma usuario.
@Entity
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date dataRetirada;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDevolucaoReal;
    private Double multa;
    private String status;
    @ManyToOne //Relacionamento com Usuário (1:n): bidirecional.
    Usuario usuario;
}
