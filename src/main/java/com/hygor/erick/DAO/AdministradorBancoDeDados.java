package com.hygor.erick.DAO;

import com.hygor.erick.entities.Administrador;
import com.hygor.erick.entities.Endereço;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdministradorBancoDeDados implements IDAO<Administrador> {
    private Connection connection;

    public AdministradorBancoDeDados(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Administrador admin) {
        String sql = "INSERT INTO administrador (id, nome, cpf, telefone, email, rua, numero, complemento, bairro, cidade, estado, cep) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            Endereço e = admin.getEndereco();
            stmt.setString(1, admin.getId());
            stmt.setString(2, admin.getNome());
            stmt.setString(3, admin.getCpf());
            stmt.setString(4, admin.getTelefone());
            stmt.setString(5, admin.getEmail());
            stmt.setString(6, e.getRua());
            stmt.setString(7, e.getNumero());
            stmt.setString(8, e.getComplemento());
            stmt.setString(9, e.getBairro());
            stmt.setString(10, e.getCidade());
            stmt.setString(11, e.getEstado());
            stmt.setString(12, e.getCep());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar administrador: " + ex.getMessage());
        }
    }

    @Override
    public void update(String id, Administrador admin) {
        String sql = "UPDATE administrador SET nome = ?, cpf = ?, telefone = ?, email = ?, rua = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, estado = ?, cep = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            Endereço e = admin.getEndereco();
            stmt.setString(1, admin.getNome());
            stmt.setString(2, admin.getCpf());
            stmt.setString(3, admin.getTelefone());
            stmt.setString(4, admin.getEmail());
            stmt.setString(5, e.getRua());
            stmt.setString(6, e.getNumero());
            stmt.setString(7, e.getComplemento());
            stmt.setString(8, e.getBairro());
            stmt.setString(9, e.getCidade());
            stmt.setString(10, e.getEstado());
            stmt.setString(11, e.getCep());
            stmt.setString(12, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar administrador: " + ex.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM administrador WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao deletar administrador: " + ex.getMessage());
        }
    }

    @Override
    public Administrador find(String id) {
        String sql = "SELECT * FROM administrador WHERE id = ?";
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
                    return new Administrador(
                        rs.getString("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        e
                    );
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar administrador: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Administrador> findAll() {
        String sql = "SELECT * FROM administrador";
        List<Administrador> lista = new ArrayList<>();
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
                lista.add(new Administrador(
                    rs.getString("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("telefone"),
                    rs.getString("email"),
                    e
                ));
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar administradores: " + ex.getMessage());
        }
        return lista;
    }
}
