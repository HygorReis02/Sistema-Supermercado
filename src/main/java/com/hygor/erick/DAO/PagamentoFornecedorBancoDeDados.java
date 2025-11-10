package com.hygor.erick.DAO;

import com.hygor.erick.entities.PagamentoFornecedor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PagamentoFornecedorBancoDeDados implements IDAO<PagamentoFornecedor> {
    private Connection connection;

    public PagamentoFornecedorBancoDeDados(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(PagamentoFornecedor pagamento) {
        String sql = "INSERT INTO pagamento_fornecedor (id, fornecedorId, valorPago, dataPagamento, metodoPagamento, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, pagamento.getId());
            stmt.setString(2, pagamento.getFornecedorId());
            stmt.setDouble(3, pagamento.getValorPago());
            stmt.setDate(4, Date.valueOf(pagamento.getDataPagamento()));
            stmt.setString(5, pagamento.getMetodoPagamento());
            stmt.setString(6, pagamento.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar pagamento fornecedor: " + e.getMessage());
        }
    }

    @Override
    public void update(String id, PagamentoFornecedor pagamento) {
        String sql = "UPDATE pagamento_fornecedor SET fornecedorId = ?, valorPago = ?, dataPagamento = ?, metodoPagamento = ?, status = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, pagamento.getFornecedorId());
            stmt.setDouble(2, pagamento.getValorPago());
            stmt.setDate(3, Date.valueOf(pagamento.getDataPagamento()));
            stmt.setString(4, pagamento.getMetodoPagamento());
            stmt.setString(5, pagamento.getStatus());
            stmt.setString(6, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar pagamento fornecedor: " + e.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM pagamento_fornecedor WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar pagamento fornecedor: " + e.getMessage());
        }
    }

    @Override
    public PagamentoFornecedor find(String id) {
        String sql = "SELECT * FROM pagamento_fornecedor WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new PagamentoFornecedor(
                        rs.getString("id"),
                        rs.getString("fornecedorId"),
                        rs.getDouble("valorPago"),
                        rs.getDate("dataPagamento").toLocalDate(),
                        rs.getString("metodoPagamento"),
                        rs.getString("status")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar pagamento fornecedor: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<PagamentoFornecedor> findAll() {
        String sql = "SELECT * FROM pagamento_fornecedor";
        List<PagamentoFornecedor> lista = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                lista.add(new PagamentoFornecedor(
                    rs.getString("id"),
                    rs.getString("fornecedorId"),
                    rs.getDouble("valorPago"),
                    rs.getDate("dataPagamento").toLocalDate(),
                    rs.getString("metodoPagamento"),
                    rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar pagamentos fornecedor: " + e.getMessage());
        }
        return lista;
    }
}
