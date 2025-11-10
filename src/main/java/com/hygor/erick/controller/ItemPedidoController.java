package com.hygor.erick.controller;

import com.hygor.erick.DAO.IDAO;
import com.hygor.erick.entities.ItemPedido;


import java.util.List;

public class ItemPedidoController {
    private IDAO<ItemPedido> repositorio;

    public ItemPedidoController(IDAO<ItemPedido> repositorio) {
        this.repositorio = repositorio;
    }

    public void adicionarItem(ItemPedido item) {
        item.calcularSubtotal();
        repositorio.save(item);
    }

    public ItemPedido buscarItem(String id) {
        return repositorio.find(id);
    }

    public List<ItemPedido> listarItens() {
        return repositorio.findAll();
    }

    public void removerItem(String id) {
        repositorio.delete(id);
    }
}
