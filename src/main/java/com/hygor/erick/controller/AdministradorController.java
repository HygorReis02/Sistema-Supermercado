package com.hygor.erick.controller;

import com.hygor.erick.DAO.IDAO;
import com.hygor.erick.entities.Administrador;
import com.hygor.erick.entities.Feedback;


import java.util.List;

public class AdministradorController {
    private IDAO<Administrador> repositorio;

    public AdministradorController(IDAO<Administrador> repositorio) {
        this.repositorio = repositorio;
    }

    public void adicionarAdministrador(Administrador admin) {
        repositorio.save(admin);
    }

    public Administrador buscarAdministrador(String id) {
        return repositorio.find(id);
    }

    public List<Administrador> listarAdministradores() {
        return repositorio.findAll();
    }

    public void removerAdministrador(String id) {
        repositorio.delete(id);
    }

    public void verFeedbacksDosUsuarios(List<Feedback> feedbacks) {
        System.out.println("📊 Feedbacks registrados por usuários:");
        for (Feedback f : feedbacks) {
            System.out.println("- Usuário: " + f.getUsuarioId() +
                               " | Nota: " + f.getNota() +
                               " | Comentário: " + f.getComentario() +
                               " | Data: " + f.getData());
        }
    }
}
