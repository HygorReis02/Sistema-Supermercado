package com.hygor.erick.DAO;

import com.hygor.erick.entities.ItemPedido;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemPedidoBancoDeDados implements IDAO<ItemPedido> {
    private Connection connection;

    public ItemPedidoBancoDeDados(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(ItemPedido item) {
        String sql = "INSERT INTO item_pedido (id, pedidoId, produtoId, quantidade, precoUnitario, subtotal) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, item.getId());
            stmt.setString(2, item.getPedidoId());
            stmt.setString(3, item.getProdutoId());
            stmt.setInt(4, item.getQuantidade());
            stmt.setDouble(5, item.getPrecoUnitario());
            stmt.setDouble(6, item.getSubtotal());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar item do pedido: " + e.getMessage());
        }
    }

    @Override
    public void update(String id, ItemPedido item) {
        String sql = "UPDATE item_pedido SET pedidoId = ?, produtoId = ?, quantidade = ?, precoUnitario = ?, subtotal = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, item.getPedidoId());
            stmt.setString(2, item.getProdutoId());
            stmt.setInt(3, item.getQuantidade());
            stmt.setDouble(4, item.getPrecoUnitario());
            stmt.setDouble(5, item.getSubtotal());
            stmt.setString(6, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar item do pedido: " + e.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM item_pedido WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar item do pedido: " + e.getMessage());
        }
    }

    @Override
    public ItemPedido find(String id) {
        String sql = "SELECT * FROM item_pedido WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new ItemPedido(
                        rs.getString("id"),
                        rs.getString("pedidoId"),
                        rs.getString("produtoId"),
                        rs.getInt("quantidade"),
                        rs.getDouble("precoUnitario")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar item do pedido: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<ItemPedido> findAll() {
        String sql = "SELECT * FROM item_pedido";
        List<ItemPedido> itens = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                itens.add(new ItemPedido(
                    rs.getString("id"),
                    rs.getString("pedidoId"),
                    rs.getString("produtoId"),
                    rs.getInt("quantidade"),
                    rs.getDouble("precoUnitario")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar itens do pedido: " + e.getMessage());
        }
        return itens;
    }
}
