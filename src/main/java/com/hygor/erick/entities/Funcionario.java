package com.hygor.erick.entities;

import java.util.Objects;

public class Funcionario {
    private String id;
    private String nome;
    private String cpf;
    private String email;
    private Endereço endereco;
    private String cargo;

    public Funcionario() {
        this.id = "";
        this.nome = "";
        this.cpf = "";
        this.email = "";
        this.endereco = new Endereço();
        this.cargo = "";
    }

    public Funcionario(String id, String nome, String cpf, String email, Endereço endereco, String cargo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
        this.cargo = cargo;
    }

    //Outro
    public Funcionario(Funcionario other) {
        this.id = other.getId();
        this.nome = other.getNome();
        this.cpf = other.getCpf();
        this.email = other.getEmail();
        this.endereco = other.getEndereco();
        this.cargo = other.getCargo();
    }

    //Copiar
    public void copy(Funcionario other) {
        this.id = other.getId();
        this.nome = other.getNome();
        this.cpf = other.getCpf();
        this.email = other.getEmail();
        this.endereco = other.getEndereco();
        this.cargo = other.getCargo();
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public Endereço getEndereco() {
        return endereco;
    }

    public String getCargo() {
        return cargo;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEndereco(Endereço endereco) {
        this.endereco = endereco;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Funcionario{id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email +
               ", endereco=" + endereco + ", cargo=" + cargo + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Funcionario other = (Funcionario) obj;
        return Objects.equals(this.id, other.id) && Objects.equals(this.cpf, other.cpf);
    }
}
