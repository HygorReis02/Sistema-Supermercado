package com.hygor.erick.DAO;

import com.hygor.erick.entities.Feedback;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FeedbackBancoDeDados implements IDAO<Feedback> {
    private Connection connection;

    public FeedbackBancoDeDados(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Feedback feedback) {
        String sql = "INSERT INTO feedback (id, usuarioId, comentario, nota, data) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, feedback.getId());
            stmt.setString(2, feedback.getUsuarioId());
            stmt.setString(3, feedback.getComentario());
            stmt.setInt(4, feedback.getNota());
            stmt.setDate(5, Date.valueOf(feedback.getData()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar feedback: " + e.getMessage());
        }
    }

    @Override
    public void update(String id, Feedback feedback) {
        String sql = "UPDATE feedback SET usuarioId = ?, comentario = ?, nota = ?, data = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, feedback.getUsuarioId());
            stmt.setString(2, feedback.getComentario());
            stmt.setInt(3, feedback.getNota());
            stmt.setDate(4, Date.valueOf(feedback.getData()));
            stmt.setString(5, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar feedback: " + e.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM feedback WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar feedback: " + e.getMessage());
        }
    }

    @Override
    public Feedback find(String id) {
        String sql = "SELECT * FROM feedback WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Feedback(
                        rs.getString("id"),
                        rs.getString("usuarioId"),
                        rs.getString("comentario"),
                        rs.getInt("nota"),
                        rs.getDate("data").toLocalDate()
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar feedback: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Feedback> findAll() {
        String sql = "SELECT * FROM feedback";
        List<Feedback> lista = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                lista.add(new Feedback(
                    rs.getString("id"),
                    rs.getString("usuarioId"),
                    rs.getString("comentario"),
                    rs.getInt("nota"),
                    rs.getDate("data").toLocalDate()
                ));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar feedbacks: " + e.getMessage());
        }
        return lista;
    }
}
