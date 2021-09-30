package br.com.fiap.gestaodemetas.entity;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "Meta")
public class Meta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String descricao;

    private Calendar data;

    private String metascol;

    private String dificuldade;

    @ManyToOne(fetch = FetchType.LAZY)
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    public Status getStatus() {
        return status;
    }

    public Meta() {
    }

    public Meta(long id, String descricao, Calendar data, String metascol, String dificuldade) {
        this.id = id;
        this.descricao = descricao;
        this.data = data;
        this.metascol = metascol;
        this.dificuldade = dificuldade;
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

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
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
}
