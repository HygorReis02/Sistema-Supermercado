package com.hygor.erick.DAO;

import com.hygor.erick.entities.Cliente;
import com.hygor.erick.entities.Endereço;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteBancoDeDados implements IDAO<Cliente> {
    private Connection connection;

    public ClienteBancoDeDados(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Cliente cliente) {
        String sql = "INSERT INTO cliente (id, nome, cpf, email, rua, numero, complemento, bairro, cidade, estado, cep) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            Endereço e = cliente.getEndereco();
            stmt.setString(1, cliente.getId());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, e.getRua());
            stmt.setString(6, e.getNumero());
            stmt.setString(7, e.getComplemento());
            stmt.setString(8, e.getBairro());
            stmt.setString(9, e.getCidade());
            stmt.setString(10, e.getEstado());
            stmt.setString(11, e.getCep());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar cliente: " + ex.getMessage());
        }
    }

    @Override
    public void update(String id, Cliente cliente) {
        String sql = "UPDATE cliente SET nome = ?, cpf = ?, email = ?, rua = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, estado = ?, cep = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            Endereço e = cliente.getEndereco();
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, e.getRua());
            stmt.setString(5, e.getNumero());
            stmt.setString(6, e.getComplemento());
            stmt.setString(7, e.getBairro());
            stmt.setString(8, e.getCidade());
            stmt.setString(9, e.getEstado());
            stmt.setString(10, e.getCep());
            stmt.setString(11, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar cliente: " + ex.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM cliente WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao deletar cliente: " + ex.getMessage());
        }
    }

    @Override
    public Cliente find(String id) {
        String sql = "SELECT * FROM cliente WHERE id = ?";
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
                    return new Cliente(
                        rs.getString("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        e
                    );
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar cliente: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Cliente> findAll() {
        String sql = "SELECT * FROM cliente";
        List<Cliente> lista = new ArrayList<>();
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
                lista.add(new Cliente(
                    rs.getString("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("email"),
                    e
                ));
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar clientes: " + ex.getMessage());
        }
        return lista;
    }
}
