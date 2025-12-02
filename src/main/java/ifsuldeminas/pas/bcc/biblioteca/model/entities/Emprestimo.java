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

    //Getters dos Atributos de Emprestimo
    public Long getId() {
        return id;
    }

    public Date getDataRetirada() {
        return dataRetirada;
    }

    public Date getDataDevolucaoReal() {
        return dataDevolucaoReal;
    }

    public Double getMulta() {
        return multa;
    }

    public String getStatus() {
        return status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    //Setters dos Atributos de Emprestimo

    public void setId(Long id) {
        this.id = id;
    }

    public void setDataRetirada(Date dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public void setDataDevolucaoReal(Date dataDevolucaoReal) {
        this.dataDevolucaoReal = dataDevolucaoReal;
    }

    public void setMulta(Double multa) {
        this.multa = multa;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
