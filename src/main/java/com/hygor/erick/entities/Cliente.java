package com.hygor.erick.entities;

import java.util.Objects;

public class Cliente {
    private String id;
    private String nome;
    private String cpf;
    private String email;
    private Endereço endereco;

    public Cliente() {
        this.id = "";
        this.nome = "";
        this.cpf = "";
        this.email = "";
        this.endereco = new Endereço();
    }

    public Cliente(String id, String nome, String cpf, String email, Endereço endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
    }

    //Outro
    public Cliente(Cliente other) {
        this.id = other.getId();
        this.nome = other.getNome();
        this.cpf = other.getCpf();
        this.email = other.getEmail();
        this.endereco = other.getEndereco();
    }

    //Copiar
    public void copy(Cliente other) {
        this.id = other.getId();
        this.nome = other.getNome();
        this.cpf = other.getCpf();
        this.email = other.getEmail();
        this.endereco = other.getEndereco();
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

    @Override
    public String toString() {
        return "Cliente{id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", endereco=" + endereco + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.cpf);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        final Cliente other = (Cliente) obj;
        return Objects.equals(this.id, other.id) && Objects.equals(this.cpf, other.cpf);
    }
}
