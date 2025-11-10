package com.hygor.erick.Valid;

import com.hygor.erick.entities.PagamentoFornecedor;
import com.hygor.erick.exception.PagamentoFornecedorException;

import java.time.LocalDate;

public class ValidPagamentoFornecedor {

    public PagamentoFornecedor validacao(String id, String fornecedorId, double valorPago,
                                         LocalDate dataPagamento, String metodoPagamento, String status) {

        PagamentoFornecedor pagamento = new PagamentoFornecedor();

        if (id == null || id.isEmpty()) throw new PagamentoFornecedorException("Erro - Campo vazio: 'id'");
        pagamento.setId(id);

        if (fornecedorId == null || fornecedorId.isEmpty()) throw new PagamentoFornecedorException("Erro - Campo vazio: 'fornecedorId'");
        pagamento.setFornecedorId(fornecedorId);

        if (valorPago <= 0) throw new PagamentoFornecedorException("Erro - Valor pago deve ser maior que zero");
        pagamento.setValorPago(valorPago);

        if (dataPagamento == null) throw new PagamentoFornecedorException("Erro - Data de pagamento inválida");
        pagamento.setDataPagamento(dataPagamento);

        if (metodoPagamento == null || metodoPagamento.isEmpty()) throw new PagamentoFornecedorException("Erro - Campo vazio: 'metodoPagamento'");
        pagamento.setMetodoPagamento(metodoPagamento);

        if (status == null || status.isEmpty()) throw new PagamentoFornecedorException("Erro - Campo vazio: 'status'");
        pagamento.setStatus(status);

        return pagamento;
    }
}
