package com.hygor.erick.controller;

import com.hygor.erick.DAO.IDAO;
import com.hygor.erick.Valid.ValidFeedback;
import com.hygor.erick.entities.Feedback;



import java.time.LocalDate;
import java.util.List;

public class FeedbackController {
    private IDAO<Feedback> repositorio;

    public FeedbackController(IDAO<Feedback> repositorio) {
        this.repositorio = repositorio;
    }

    public void registrarFeedback(String id, String usuarioId, String comentario, int nota) {
        ValidFeedback valid = new ValidFeedback();
        Feedback feedback = valid.validar(id, usuarioId, comentario, nota, LocalDate.now());
        repositorio.save(feedback);
    }

    public Feedback buscarFeedback(String id) {
        return repositorio.find(id);
    }

    public List<Feedback> listarFeedbacks() {
        return repositorio.findAll();
    }

    public void removerFeedback(String id) {
        repositorio.delete(id);
    }
}
