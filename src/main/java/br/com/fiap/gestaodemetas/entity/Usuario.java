package br.com.fiap.gestaodemetas.entity;

import javax.persistence.*;

@Entity
@Table(name = "Usuario")
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private String sobrenome;
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
    private String password;
    private String email;

    public Usuario(long id, String nome, String sobrenome, Empresa empresa, String password, String email) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.empresa = empresa;
        this.password = password;
        this.email = email;
    }

    public Usuario() {
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
