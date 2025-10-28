package ifsuldeminas.pas.bcc.biblioteca.model.entities;

import java.util.Date;

public class Emprestimo {
    private Long id;
    private Date dataRetirada;
    private Date dataDevolucaoReal;
    private Double multa;
    private String status;
}
