package com.hygor.erick.Valid;

import com.hygor.erick.entities.NotaFiscal;
import com.hygor.erick.entities.ItemPedido;
import com.hygor.erick.entities.Usuario;
import com.hygor.erick.entities.Pagamento;
import com.hygor.erick.exception.NotaFiscalException;

import java.time.LocalDate;
import java.util.List;

public class ValidNotaFiscal {

    public NotaFiscal validacao(String id, String pedidoId, LocalDate dataEmissao,
                                List<ItemPedido> itens, Usuario cliente, Pagamento pagamento) {

        if (id == null || id.isEmpty()) throw new NotaFiscalException("Erro - Campo vazio: 'id'");
        if (pedidoId == null || pedidoId.isEmpty()) throw new NotaFiscalException("Erro - Campo vazio: 'pedidoId'");
        if (dataEmissao == null) throw new NotaFiscalException("Erro - Data de emissão inválida");
        if (itens == null || itens.isEmpty()) throw new NotaFiscalException("Erro - Nota fiscal sem itens");
        if (cliente == null) throw new NotaFiscalException("Erro - Cliente não informado");
        if (pagamento == null) throw new NotaFiscalException("Erro - Pagamento não informado");

        return new NotaFiscal(id, pedidoId, dataEmissao, itens, cliente, pagamento);
    }
}
