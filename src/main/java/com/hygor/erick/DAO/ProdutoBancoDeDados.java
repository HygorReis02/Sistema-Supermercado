package com.hygor.erick.DAO;

import com.hygor.erick.entities.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoBancoDeDados implements IDAO<Produto> {
    private Connection connection;

    public ProdutoBancoDeDados(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Produto produto) {
        String sql = "INSERT INTO produto (id, nome, descricao, preco, estoque, fornecedorId) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, produto.getId());
            stmt.setString(2, produto.getNome());
            stmt.setString(3, produto.getDescricao());
            stmt.setDouble(4, produto.getPreco());
            stmt.setInt(5, produto.getEstoque());
            stmt.setString(6, produto.getFornecedorId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar produto: " + e.getMessage());
        }
    }

    @Override
    public void update(String id, Produto produto) {
        String sql = "UPDATE produto SET nome = ?, descricao = ?, preco = ?, estoque = ?, fornecedorId = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPreco());
            stmt.setInt(4, produto.getEstoque());
            stmt.setString(5, produto.getFornecedorId());
            stmt.setString(6, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar produto: " + e.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM produto WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar produto: " + e.getMessage());
        }
    }

    @Override
    public Produto find(String id) {
        String sql = "SELECT * FROM produto WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Produto(
                        rs.getString("id"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getDouble("preco"),
                        rs.getInt("estoque"),
                        rs.getString("fornecedorId")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar produto: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Produto> findAll() {
        String sql = "SELECT * FROM produto";
        List<Produto> lista = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                lista.add(new Produto(
                    rs.getString("id"),
                    rs.getString("nome"),
                    rs.getString("descricao"),
                    rs.getDouble("preco"),
                    rs.getInt("estoque"),
                    rs.getString("fornecedorId")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar produtos: " + e.getMessage());
        }
        return lista;
    }
}
