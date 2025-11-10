package com.hygor.erick.entities;

import java.util.Objects;

public class Produto {
    private String id;
    private String nome;
    private String descricao;
    private double preco;
    private int estoque;
    private String fornecedorId;

    public Produto() {
        this.id = "";
        this.nome = "";
        this.descricao = "";
        this.preco = 0.0;
        this.estoque = 0;
        this.fornecedorId = "";
    }

    public Produto(String id, String nome, String descricao, double preco, int estoque, String fornecedorId) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
        this.fornecedorId = fornecedorId;
    }

    //Outro
    public Produto(Produto other) {
        this.id = other.getId();
        this.nome = other.getNome();
        this.descricao = other.getDescricao();
        this.preco = other.getPreco();
        this.estoque = other.getEstoque();
        this.fornecedorId = other.getFornecedorId();
    }

    //Copiar
    public void copy(Produto other) {
        this.id = other.getId();
        this.nome = other.getNome();
        this.descricao = other.getDescricao();
        this.preco = other.getPreco();
        this.estoque = other.getEstoque();
        this.fornecedorId = other.getFornecedorId();
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public String getFornecedorId() {
        return fornecedorId;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public void setFornecedorId(String fornecedorId) {
        this.fornecedorId = fornecedorId;
    }

    @Override
    public String toString() {
        return "Produto{id=" + id + ", nome=" + nome + ", descricao=" + descricao +
               ", preco=" + preco + ", estoque=" + estoque + ", fornecedorId=" + fornecedorId + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Produto other = (Produto) obj;
        return Objects.equals(this.id, other.id) && Objects.equals(this.nome, other.nome);
    }
}
