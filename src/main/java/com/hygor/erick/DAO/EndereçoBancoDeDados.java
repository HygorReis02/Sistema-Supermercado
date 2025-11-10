package com.hygor.erick.DAO;

import com.hygor.erick.entities.Endereço;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EndereçoBancoDeDados implements IDAO<Endereço> {
    private Connection connection;

    public EndereçoBancoDeDados(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Endereço endereco) {
        String sql = "INSERT INTO endereco (rua, numero, complemento, bairro, cidade, estado, cep) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, endereco.getRua());
            stmt.setString(2, endereco.getNumero());
            stmt.setString(3, endereco.getComplemento());
            stmt.setString(4, endereco.getBairro());
            stmt.setString(5, endereco.getCidade());
            stmt.setString(6, endereco.getEstado());
            stmt.setString(7, endereco.getCep());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar endereço: " + e.getMessage());
        }
    }

    @Override
    public void update(String id, Endereço endereco) {
        String sql = "UPDATE endereco SET rua = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, estado = ?, cep = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, endereco.getRua());
            stmt.setString(2, endereco.getNumero());
            stmt.setString(3, endereco.getComplemento());
            stmt.setString(4, endereco.getBairro());
            stmt.setString(5, endereco.getCidade());
            stmt.setString(6, endereco.getEstado());
            stmt.setString(7, endereco.getCep());
            stmt.setString(8, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar endereço: " + e.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM endereco WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar endereço: " + e.getMessage());
        }
    }

    @Override
    public Endereço find(String id) {
        String sql = "SELECT * FROM endereco WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Endereço(
                        rs.getString("rua"),
                        rs.getString("numero"),
                        rs.getString("complemento"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("estado"),
                        rs.getString("cep")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar endereço: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Endereço> findAll() {
        String sql = "SELECT * FROM endereco";
        List<Endereço> lista = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                lista.add(new Endereço(
                    rs.getString("rua"),
                    rs.getString("numero"),
                    rs.getString("complemento"),
                    rs.getString("bairro"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getString("cep")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar endereços: " + e.getMessage());
        }
        return lista;
    }
}
