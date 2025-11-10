package com.hygor.erick.DAO;

import com.hygor.erick.entities.Pagamento;
import com.hygor.erick.entities.MetodoPagamento;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PagamentoBancoDeDados implements IDAO<Pagamento> {
    private Connection connection;

    public PagamentoBancoDeDados(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Pagamento pagamento) {
        String sql = "INSERT INTO pagamento (id, pedidoId, metodo, valorPago, status, dataPagamento) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, pagamento.getId());
            stmt.setString(2, pagamento.getPedido().getId());
            stmt.setString(3, pagamento.getMetodo().name());
            stmt.setDouble(4, pagamento.getValorPago());
            stmt.setString(5, pagamento.getStatus());
            stmt.setDate(6, Date.valueOf(pagamento.getDataPagamento()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar pagamento: " + e.getMessage());
        }
    }

    @Override
    public void update(String id, Pagamento pagamento) {
        String sql = "UPDATE pagamento SET pedidoId = ?, metodo = ?, valorPago = ?, status = ?, dataPagamento = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, pagamento.getPedido().getId());
            stmt.setString(2, pagamento.getMetodo().name());
            stmt.setDouble(3, pagamento.getValorPago());
            stmt.setString(4, pagamento.getStatus());
            stmt.setDate(5, Date.valueOf(pagamento.getDataPagamento()));
            stmt.setString(6, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar pagamento: " + e.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM pagamento WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar pagamento: " + e.getMessage());
        }
    }

    @Override
    public Pagamento find(String id) {
        String sql = "SELECT * FROM pagamento WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Pagamento pagamento = new Pagamento();
                    pagamento.setId(rs.getString("id"));
                    pagamento.setValorPago(rs.getDouble("valorPago"));
                    pagamento.setStatus(rs.getString("status"));
                    pagamento.setMetodo(MetodoPagamento.valueOf(rs.getString("metodo")));
                    pagamento.setDataPagamento(rs.getDate("dataPagamento").toLocalDate());
                    // pedido deve ser buscado separadamente
                    return pagamento;
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar pagamento: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Pagamento> findAll() {
        String sql = "SELECT * FROM pagamento";
        List<Pagamento> pagamentos = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Pagamento pagamento = new Pagamento();
                pagamento.setId(rs.getString("id"));
                pagamento.setValorPago(rs.getDouble("valorPago"));
                pagamento.setStatus(rs.getString("status"));
                pagamento.setMetodo(MetodoPagamento.valueOf(rs.getString("metodo")));
                pagamento.setDataPagamento(rs.getDate("dataPagamento").toLocalDate());
                pagamentos.add(pagamento);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar pagamentos: " + e.getMessage());
        }
        return pagamentos;
    }
}
