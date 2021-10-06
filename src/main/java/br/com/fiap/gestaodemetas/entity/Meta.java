package br.com.fiap.gestaodemetas.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Meta")
public class Meta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String descricao;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date data;

    private String dificuldade;

    private String status;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    public Meta() {
    }


    public Meta(long id, String descricao, Date data,String dificuldade, String status, Empresa empresa) {
        this.id = id;
        this.descricao = descricao;
        this.data = data;
        this.dificuldade = dificuldade;
        this.status = status;
        this.empresa = empresa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

}
