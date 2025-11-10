package com.hygor.erick.DAO;

import com.hygor.erick.entities.NotaFiscal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotaFiscalBancoDeDados implements IDAO<NotaFiscal> {
    private Connection connection;

    public NotaFiscalBancoDeDados(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(NotaFiscal nota) {
        String sql = "INSERT INTO nota_fiscal (id, pedidoId, dataEmissao, valorTotal) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nota.getId());
            stmt.setString(2, nota.getPedidoId());
            stmt.setDate(3, Date.valueOf(nota.getDataEmissao()));
            stmt.setDouble(4, nota.getValorTotal());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar nota fiscal: " + e.getMessage());
        }
    }

    @Override
    public void update(String id, NotaFiscal nota) {
        String sql = "UPDATE nota_fiscal SET pedidoId = ?, dataEmissao = ?, valorTotal = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nota.getPedidoId());
            stmt.setDate(2, Date.valueOf(nota.getDataEmissao()));
            stmt.setDouble(3, nota.getValorTotal());
            stmt.setString(4, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar nota fiscal: " + e.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM nota_fiscal WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar nota fiscal: " + e.getMessage());
        }
    }

    @Override
    public NotaFiscal find(String id) {
        String sql = "SELECT * FROM nota_fiscal WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    NotaFiscal nota = new NotaFiscal();
                    nota.setId(rs.getString("id"));
                    nota.setPedidoId(rs.getString("pedidoId"));
                    nota.setDataEmissao(rs.getDate("dataEmissao").toLocalDate());
                    nota.setValorTotal(rs.getDouble("valorTotal"));
                    return nota;
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar nota fiscal: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<NotaFiscal> findAll() {
        String sql = "SELECT * FROM nota_fiscal";
        List<NotaFiscal> notas = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                NotaFiscal nota = new NotaFiscal();
                nota.setId(rs.getString("id"));
                nota.setPedidoId(rs.getString("pedidoId"));
                nota.setDataEmissao(rs.getDate("dataEmissao").toLocalDate());
                nota.setValorTotal(rs.getDouble("valorTotal"));
                notas.add(nota);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar notas fiscais: " + e.getMessage());
        }
        return notas;
    }
}
