package com.hygor.erick.DAO;

import com.hygor.erick.entities.Fornecedor;
import com.hygor.erick.entities.Endereço;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FornecedorBancoDeDados implements IDAO<Fornecedor> {
    private Connection connection;

    public FornecedorBancoDeDados(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Fornecedor fornecedor) {
        String sql = "INSERT INTO fornecedor (id, nomeEmpresa, cnpj, email, telefone, rua, numero, complemento, bairro, cidade, estado, cep) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            Endereço e = fornecedor.getEndereco();
            stmt.setString(1, fornecedor.getId());
            stmt.setString(2, fornecedor.getNomeEmpresa());
            stmt.setString(3, fornecedor.getCnpj());
            stmt.setString(4, fornecedor.getEmail());
            stmt.setString(5, fornecedor.getTelefone());
            stmt.setString(6, e.getRua());
            stmt.setString(7, e.getNumero());
            stmt.setString(8, e.getComplemento());
            stmt.setString(9, e.getBairro());
            stmt.setString(10, e.getCidade());
            stmt.setString(11, e.getEstado());
            stmt.setString(12, e.getCep());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar fornecedor: " + e.getMessage());
        }
    }

    @Override
    public void update(String id, Fornecedor fornecedor) {
        String sql = "UPDATE fornecedor SET nomeEmpresa = ?, cnpj = ?, email = ?, telefone = ?, rua = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, estado = ?, cep = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            Endereço e = fornecedor.getEndereco();
            stmt.setString(1, fornecedor.getNomeEmpresa());
            stmt.setString(2, fornecedor.getCnpj());
            stmt.setString(3, fornecedor.getEmail());
            stmt.setString(4, fornecedor.getTelefone());
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
            System.out.println("Erro ao atualizar fornecedor: " + e.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM fornecedor WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar fornecedor: " + e.getMessage());
        }
    }

    @Override
    public Fornecedor find(String id) {
        String sql = "SELECT * FROM fornecedor WHERE id = ?";
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
                    return new Fornecedor(
                        rs.getString("id"),
                        rs.getString("nomeEmpresa"),
                        rs.getString("cnpj"),
                        rs.getString("email"),
                        rs.getString("telefone"),
                        e
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar fornecedor: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Fornecedor> findAll() {
        String sql = "SELECT * FROM fornecedor";
        List<Fornecedor> lista = new ArrayList<>();
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
                lista.add(new Fornecedor(
                    rs.getString("id"),
                    rs.getString("nomeEmpresa"),
                    rs.getString("cnpj"),
                    rs.getString("email"),
                    rs.getString("telefone"),
                    e
                ));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar fornecedores: " + e.getMessage());
        }
        return lista;
    }
}
