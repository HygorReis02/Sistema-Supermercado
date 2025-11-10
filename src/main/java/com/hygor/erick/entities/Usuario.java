package com.hygor.erick.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {
    private String id;
    private String nome;
    private String email;
    private String senha;
    private String perfil;
    private List<Feedback> feedbacks;

    public Usuario() {
        this.id = "";
        this.nome = "";
        this.email = "";
        this.senha = "";
        this.perfil = "";
        this.feedbacks = new ArrayList<>();
    }

    public Usuario(String id, String nome, String email, String senha, String perfil) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.perfil = perfil;
        this.feedbacks = new ArrayList<>();
    }

    //Outro
    public Usuario(Usuario other) {
        this.id = other.getId();
        this.nome = other.getNome();
        this.email = other.getEmail();
        this.senha = other.getSenha();
        this.perfil = other.getPerfil();
        this.feedbacks = new ArrayList<>(other.getFeedbacks());
    }

    //Copiar
    public void copy(Usuario other) {
        this.id = other.getId();
        this.nome = other.getNome();
        this.email = other.getEmail();
        this.senha = other.getSenha();
        this.perfil = other.getPerfil();
        this.feedbacks = new ArrayList<>(other.getFeedbacks());
    }

    //Add Feedback
    public void adicionarFeedback(Feedback feedback) {
        this.feedbacks.add(feedback);
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void verMeusFeedbacks() {
        System.out.println("📋 Feedbacks de " + nome + ":");
        if (feedbacks.isEmpty()) {
            System.out.println("Nenhum feedback registrado.");
        } else {
            for (Feedback f : feedbacks) {
                System.out.println("- [" + f.getNota() + "] " + f.getComentario() + " (" + f.getData() + ")");
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

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getPerfil() {
        return perfil;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    @Override
    public String toString() {
        return "Usuario{id=" + id + ", nome=" + nome + ", email=" + email +
               ", perfil=" + perfil + ", feedbacks=" + feedbacks.size() + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Usuario other = (Usuario) obj;
        return Objects.equals(this.id, other.id) && Objects.equals(this.email, other.email);
    }
}
