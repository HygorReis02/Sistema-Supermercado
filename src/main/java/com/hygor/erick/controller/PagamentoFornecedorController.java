package com.hygor.erick.controller;

import com.hygor.erick.DAO.IDAO;
import com.hygor.erick.entities.PagamentoFornecedor;

import java.util.List;

public class PagamentoFornecedorController {
    private IDAO<PagamentoFornecedor> repositorio;

    public PagamentoFornecedorController(IDAO<PagamentoFornecedor> repositorio) {
        this.repositorio = repositorio;
    }

    public void registrarPagamento(PagamentoFornecedor pagamento) {
        repositorio.save(pagamento);
    }

    public PagamentoFornecedor buscarPagamento(String id) {
        return repositorio.find(id);
    }

    public List<PagamentoFornecedor> listarPagamentos() {
        return repositorio.findAll();
    }

    public void removerPagamento(String id) {
        repositorio.delete(id);
    }

    public void exibirPagamentosFormatados() {
        System.out.println("💸 Pagamentos realizados a fornecedores:");
        for (PagamentoFornecedor p : repositorio.findAll()) {
            System.out.println("- ID: " + p.getId() + " | Fornecedor: " + p.getFornecedorId() +
                               " | Valor: R$" + p.getValorPago() + " | Data: " + p.getDataPagamento() +
                               " | Método: " + p.getMetodoPagamento() + " | Status: " + p.getStatus());
        }
    }
}
