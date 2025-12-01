package ifsuldeminas.pas.bcc.biblioteca.model.entities;

import jakarta.persistence.*;

import java.util.Date;

//Um usuario pode ter varias reservas,
//e uma reserva (parte) pertence apenas a um usuário
@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date dataReserva;
    private String status;
    @OneToOne
    Livro livros;
}
