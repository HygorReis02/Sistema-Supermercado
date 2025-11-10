package com.hygor.erick.Valid;

import com.hygor.erick.entities.ItemPedido;
import com.hygor.erick.exception.ItemPedidoException;

public class ValidItemPedido {

    public ItemPedido validacao(String id, String pedidoId, String produtoId, int quantidade, double precoUnitario) {
        ItemPedido item = new ItemPedido();

        if (id == null || id.isEmpty()) throw new ItemPedidoException("Erro - Campo vazio: 'id'");
        item.setId(id);

        if (pedidoId == null || pedidoId.isEmpty()) throw new ItemPedidoException("Erro - Campo vazio: 'pedidoId'");
        item.setPedidoId(pedidoId);

        if (produtoId == null || produtoId.isEmpty()) throw new ItemPedidoException("Erro - Campo vazio: 'produtoId'");
        item.setProdutoId(produtoId);

        if (quantidade <= 0) throw new ItemPedidoException("Erro - Quantidade deve ser maior que zero");
        item.setQuantidade(quantidade);

        if (precoUnitario <= 0) throw new ItemPedidoException("Erro - Preço unitário deve ser maior que zero");
        item.setPrecoUnitario(precoUnitario);

        item.calcularSubtotal();
        return item;
    }
}
