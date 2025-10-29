package ifsuldeminas.pas.bcc.biblioteca.model.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "emprestimos")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dataRetirada;

    @Temporal(TemporalType.DATE)
    private Date dataDevolucaoPrevista;

    @Temporal(TemporalType.DATE)
    private Date dataDevolucaoReal;

    private Double multa;
    private String status;

    @ManyToOne
    @JoinColumn(name = "exemplar_id")
    private Exemplar exemplar;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // Getters e Setters
    // ...
}
