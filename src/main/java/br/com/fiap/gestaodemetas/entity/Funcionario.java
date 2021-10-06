package br.com.fiap.gestaodemetas.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nome;

    private String email;

    private String cargo;

    private String senha;

    private long funcional;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "funcionario_id")
    private List<Meta> metas = new ArrayList();

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    public Empresa getEmpresa() {
        return empresa;
    }

    public Funcionario() {
    }

    public Funcionario(long id, String nome, String email, String cargo, String senha, long funcional, List<Meta> metas, Empresa empresa) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
        this.senha = senha;
        this.funcional = funcional;
        this.metas = metas;
        this.empresa = empresa;
    }

    public long getFuncional() {
        return funcional;
    }

    public void setFuncional(long funcional) {
        this.funcional = funcional;
    }

    public List<Meta> getMetas() {
        return metas;
    }

    public void setMetas(List<Meta> metas) {
        this.metas = metas;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
