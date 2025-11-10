package com.hygor.erick.controller;

import com.hygor.erick.DAO.IDAO;
import com.hygor.erick.entities.Pedido;


import java.util.List;

public class pedidoController {
    private IDAO<Pedido> repositorio;

    public pedidoController(IDAO<Pedido> repositorio) {
        this.repositorio = repositorio;
    }

    public void adicionarPedido(Pedido pedido) {
        repositorio.save(pedido);
    }

    public Pedido buscarPedido(String id) {
        return repositorio.find(id);
    }

    public List<Pedido> listarPedidos() {
        return repositorio.findAll();
    }

    public void removerPedido(String id) {
        repositorio.delete(id);
    }
}
