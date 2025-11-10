package com.hygor.erick.DAO;

import com.hygor.erick.entities.Funcionario;
import com.hygor.erick.entities.Endereço;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioBancoDeDados implements IDAO<Funcionario> {
    private Connection connection;

    public FuncionarioBancoDeDados(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario (id, nome, cpf, email, cargo, rua, numero, complemento, bairro, cidade, estado, cep) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            Endereço e = funcionario.getEndereco();
            stmt.setString(1, funcionario.getId());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getCpf());
            stmt.setString(4, funcionario.getEmail());
            stmt.setString(5, funcionario.getCargo());
            stmt.setString(6, e.getRua());
            stmt.setString(7, e.getNumero());
            stmt.setString(8, e.getComplemento());
            stmt.setString(9, e.getBairro());
            stmt.setString(10, e.getCidade());
            stmt.setString(11, e.getEstado());
            stmt.setString(12, e.getCep());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar funcionário: " + e.getMessage());
        }
    }

    @Override
    public void update(String id, Funcionario funcionario) {
        String sql = "UPDATE funcionario SET nome = ?, cpf = ?, email = ?, cargo = ?, rua = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, estado = ?, cep = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            Endereço e = funcionario.getEndereco();
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setString(3, funcionario.getEmail());
            stmt.setString(4, funcionario.getCargo());
            stmt.setString(5, e.getRua());
            stmt.setString(6, e.getNumero());
            stmt.setString(7, e.getComplemento());
            stmt.setString(8, e.getBairro());
            stmt.setString(9, e.getCidade());
            stmt.setString(10, e.getEstado());
            stmt.setString(11, e.getCep());
            stmt.setString(12, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar funcionário: " + e.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM funcionario WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar funcionário: " + e.getMessage());
        }
    }

    @Override
    public Funcionario find(String id) {
        String sql = "SELECT * FROM funcionario WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Endereço e = new Endereço(
                        rs.getString("rua"),
                        rs.getString("numero"),
                        rs.getString("complemento"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("estado"),
                        rs.getString("cep")
                    );
                    return new Funcionario(
                        rs.getString("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        e,
                        rs.getString("cargo")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar funcionário: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Funcionario> findAll() {
        String sql = "SELECT * FROM funcionario";
        List<Funcionario> lista = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Endereço e = new Endereço(
                    rs.getString("rua"),
                    rs.getString("numero"),
                    rs.getString("complemento"),
                    rs.getString("bairro"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getString("cep")
                );
                lista.add(new Funcionario(
                    rs.getString("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("email"),
                    e,
                    rs.getString("cargo")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar funcionários: " + e.getMessage());
        }
        return lista;
    }
}
