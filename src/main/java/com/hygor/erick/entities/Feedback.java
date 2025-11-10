package com.hygor.erick.entities;

import java.time.LocalDate;
import java.util.Objects;

public class Feedback {
    private String id;
    private String usuarioId;
    private String comentario;
    private int nota;
    private LocalDate data;

    public Feedback() {
        this.id = "";
        this.usuarioId = "";
        this.comentario = "";
        this.nota = 0;
        this.data = LocalDate.now();
    }

    public Feedback(String id, String usuarioId, String comentario, int nota, LocalDate data) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.comentario = comentario;
        this.nota = nota;
        this.data = data;
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public String getComentario() {
        return comentario;
    }

    public int getNota() {
        return nota;
    }

    public LocalDate getData() {
        return data;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Feedback{id=" + id + ", usuarioId=" + usuarioId + ", nota=" + nota +
               ", comentario='" + comentario + "', data=" + data + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Feedback other = (Feedback) obj;
        return Objects.equals(this.id, other.id) && Objects.equals(this.usuarioId, other.usuarioId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuarioId);
    }
}
