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

    private String metascol;

    private String dificuldade;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    public Meta() {
    }

    public Meta(long id, String descricao, Date data, String metascol,
                String dificuldade, Funcionario funcionario, Status status) {
        this.id = id;
        this.descricao = descricao;
        this.data = data;
        this.metascol = metascol;
        this.dificuldade = dificuldade;
        this.funcionario = funcionario;
        this.status = status;
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

    public String getMetascol() {
        return metascol;
    }

    public void setMetascol(String metascol) {
        this.metascol = metascol;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
