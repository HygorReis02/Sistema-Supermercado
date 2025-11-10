package com.hygor.erick.Valid;

import com.hygor.erick.exception.PessoaException;
import com.hygor.erick.entities.Feedback;

import java.time.LocalDate;

public class ValidFeedback {

    public Feedback validar(String id, String usuarioId, String comentario, int nota, LocalDate data) {
        Feedback feedback = new Feedback();

        if (id.isEmpty()) throw new PessoaException("Erro - Campo vazio: 'id'");
        feedback.setId(id);

        if (usuarioId.isEmpty()) throw new PessoaException("Erro - Campo vazio: 'usuarioId'");
        feedback.setUsuarioId(usuarioId);

        if (comentario == null || comentario.isBlank()) throw new PessoaException("Erro - Comentário não pode estar vazio");
        feedback.setComentario(comentario);

        if (nota < 1 || nota > 5) throw new PessoaException("Erro - Nota deve estar entre 1 e 5");
        feedback.setNota(nota);

        if (data == null) throw new PessoaException("Erro - Data inválida");
        feedback.setData(data);

        return feedback;
    }
}
