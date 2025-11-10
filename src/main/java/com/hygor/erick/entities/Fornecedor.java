package com.hygor.erick.entities;

import java.util.Objects;

public class Fornecedor {
    private String id;
    private String nomeEmpresa;
    private String cnpj;
    private String email;
    private String telefone;
    private Endereço endereco;

    public Fornecedor() {
        this.id = "";
        this.nomeEmpresa = "";
        this.cnpj = "";
        this.email = "";
        this.telefone = "";
        this.endereco = new Endereço();
    }

    public Fornecedor(String id, String nomeEmpresa, String cnpj, String email, String telefone, Endereço endereco) {
        this.id = id;
        this.nomeEmpresa = nomeEmpresa;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    //Outro
    public Fornecedor(Fornecedor other) {
        this.id = other.getId();
        this.nomeEmpresa = other.getNomeEmpresa();
        this.cnpj = other.getCnpj();
        this.email = other.getEmail();
        this.telefone = other.getTelefone();
        this.endereco = other.getEndereco();
    }

    //Copiar
    public void copy(Fornecedor other) {
        this.id = other.getId();
        this.nomeEmpresa = other.getNomeEmpresa();
        this.cnpj = other.getCnpj();
        this.email = other.getEmail();
        this.telefone = other.getTelefone();
        this.endereco = other.getEndereco();
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public Endereço getEndereco() {
        return endereco;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(Endereço endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Fornecedor{id=" + id + ", nomeEmpresa=" + nomeEmpresa + ", cnpj=" + cnpj +
               ", email=" + email + ", telefone=" + telefone + ", endereco=" + endereco + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cnpj);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Fornecedor other = (Fornecedor) obj;
        return Objects.equals(this.id, other.id) && Objects.equals(this.cnpj, other.cnpj);
    }
}
