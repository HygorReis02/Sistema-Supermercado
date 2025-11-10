package com.hygor.erick.Valid;

import com.hygor.erick.entities.Pedido;
import com.hygor.erick.exception.PedidoException;

import java.time.LocalDate;

public class ValidPedido {

    public Pedido validacao(String id, String clienteId, double valorTotal, LocalDate data, String status) {
        Pedido pedido = new Pedido();

        if (id == null || id.isEmpty()) throw new PedidoException("Erro - Campo vazio: 'id'");
        pedido.setId(id);

        if (clienteId == null || clienteId.isEmpty()) throw new PedidoException("Erro - Campo vazio: 'clienteId'");
        pedido.setClienteId(clienteId);

        if (valorTotal <= 0) throw new PedidoException("Erro - Valor total deve ser maior que zero");
        pedido.setValorTotal(valorTotal);

        if (data == null) throw new PedidoException("Erro - Data inválida");
        pedido.setData(data);

        if (status == null || status.isEmpty()) throw new PedidoException("Erro - Campo vazio: 'status'");
        pedido.setStatus(status);

        return pedido;
    }
}
