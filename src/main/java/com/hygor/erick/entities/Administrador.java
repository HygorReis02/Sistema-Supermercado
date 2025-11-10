package com.hygor.erick.entities;

import java.util.List;
import java.util.Objects;

public class Administrador {
    private String id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private Endereço endereco;

    public Administrador() {
        this.id = "";
        this.nome = "";
        this.cpf = "";
        this.telefone = "";
        this.email = "";
        this.endereco = new Endereço();
    }

    public Administrador(String id, String nome, String cpf, String telefone, String email, Endereço endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public Administrador(Administrador other) {
        this.id = other.getId();
        this.nome = other.getNome();
        this.cpf = other.getCpf();
        this.telefone = other.getTelefone();
        this.email = other.getEmail();
        this.endereco = other.getEndereco();
    }

    public void copy(Administrador other) {
        this.id = other.getId();
        this.nome = other.getNome();
        this.cpf = other.getCpf();
        this.telefone = other.getTelefone();
        this.email = other.getEmail();
        this.endereco = other.getEndereco();
    }

    public void verFeedbacksDosUsuarios(List<Feedback> feedbacks) {
        System.out.println("📊 Feedbacks registrados por usuários:");
        if (feedbacks.isEmpty()) {
            System.out.println("Nenhum feedback disponível.");
        } else {
            for (Feedback f : feedbacks) {
                System.out.println("- Usuário: " + f.getUsuarioId() +
                                   " | Nota: " + f.getNota() +
                                   " | Comentário: " + f.getComentario() +
                                   " | Data: " + f.getData());
            }
        }
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

    public String getTelefone() {
        return telefone;
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

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEndereco(Endereço endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Administrador{id=" + id + ", nome=" + nome + ", cpf=" + cpf +
               ", telefone=" + telefone + ", email=" + email + ", endereco=" + endereco + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Administrador other = (Administrador) obj;
        return Objects.equals(this.id, other.id) && Objects.equals(this.cpf, other.cpf);
    }
}
