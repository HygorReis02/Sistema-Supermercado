package com.hygor.erick.Valid;

import com.hygor.erick.entities.Pagamento;
import com.hygor.erick.entities.Pedido;
import com.hygor.erick.entities.MetodoPagamento;
import com.hygor.erick.exception.PagamentoException;

import java.time.LocalDate;

public class ValidPagamento {

    public Pagamento validacao(String id, Pedido pedido, MetodoPagamento metodo, double valorPago, String status, LocalDate dataPagamento) {
        Pagamento pagamento = new Pagamento();

        if (id == null || id.isEmpty()) throw new PagamentoException("Erro - Campo vazio: 'id'");
        pagamento.setId(id);

        if (pedido == null) throw new PagamentoException("Erro - Pedido não pode ser nulo");
        pagamento.setPedido(pedido);

        if (metodo == null) throw new PagamentoException("Erro - Método de pagamento inválido");
        pagamento.setMetodo(metodo);

        if (valorPago <= 0) throw new PagamentoException("Erro - Valor pago deve ser maior que zero");
        pagamento.setValorPago(valorPago);

        if (status == null || status.isEmpty()) throw new PagamentoException("Erro - Campo vazio: 'status'");
        pagamento.setStatus(status);

        if (dataPagamento == null) throw new PagamentoException("Erro - Data de pagamento inválida");
        pagamento.setDataPagamento(dataPagamento);

        return pagamento;
    }
}
