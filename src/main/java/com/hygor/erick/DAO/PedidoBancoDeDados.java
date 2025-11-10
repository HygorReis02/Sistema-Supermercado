package com.hygor.erick.DAO;

import com.hygor.erick.entities.Pedido;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PedidoBancoDeDados implements IDAO<Pedido> {
    private Connection connection;

    public PedidoBancoDeDados(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Pedido pedido) {
        String sql = "INSERT INTO pedido (id, clienteId, valorTotal, data, status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, pedido.getId());
            stmt.setString(2, pedido.getClienteId());
            stmt.setDouble(3, pedido.getValorTotal());
            stmt.setDate(4, Date.valueOf(pedido.getData()));
            stmt.setString(5, pedido.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar pedido: " + e.getMessage());
        }
    }

    @Override
    public void update(String id, Pedido pedido) {
        String sql = "UPDATE pedido SET clienteId = ?, valorTotal = ?, data = ?, status = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, pedido.getClienteId());
            stmt.setDouble(2, pedido.getValorTotal());
            stmt.setDate(3, Date.valueOf(pedido.getData()));
            stmt.setString(4, pedido.getStatus());
            stmt.setString(5, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar pedido: " + e.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM pedido WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar pedido: " + e.getMessage());
        }
    }

    @Override
    public Pedido find(String id) {
        String sql = "SELECT * FROM pedido WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Pedido(
                        rs.getString("id"),
                        rs.getString("clienteId"),
                        rs.getDouble("valorTotal"),
                        rs.getDate("data").toLocalDate(),
                        rs.getString("status")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar pedido: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Pedido> findAll() {
        String sql = "SELECT * FROM pedido";
        List<Pedido> pedidos = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                pedidos.add(new Pedido(
                    rs.getString("id"),
                    rs.getString("clienteId"),
                    rs.getDouble("valorTotal"),
                    rs.getDate("data").toLocalDate(),
                    rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar pedidos: " + e.getMessage());
        }
        return pedidos;
    }
}
