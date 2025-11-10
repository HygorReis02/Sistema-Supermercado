package com.hygor.erick.controller;

import com.hygor.erick.DAO.IDAO;
import com.hygor.erick.entities.Pagamento;


import java.util.List;

public class PagamentoController {
    private IDAO<Pagamento> repositorio;

    public PagamentoController(IDAO<Pagamento> repositorio) {
        this.repositorio = repositorio;
    }

    public void registrarPagamento(Pagamento pagamento) {
        pagamento.confirmarPagamento();
        repositorio.save(pagamento);
    }

    public Pagamento buscarPagamento(String id) {
        return repositorio.find(id);
    }

    public List<Pagamento> listarPagamentos() {
        return repositorio.findAll();
    }

    public void removerPagamento(String id) {
        repositorio.delete(id);
    }
}
