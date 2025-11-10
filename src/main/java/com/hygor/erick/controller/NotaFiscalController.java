package com.hygor.erick.controller;

import com.hygor.erick.DAO.IDAO;
import com.hygor.erick.Valid.ValidNotaFiscal;
import com.hygor.erick.entities.NotaFiscal;

import java.time.LocalDate;
import java.util.List;

public class NotaFiscalController {
    private IDAO<NotaFiscal> repositorio;

    public NotaFiscalController(IDAO<NotaFiscal> repositorio) {
        this.repositorio = repositorio;
    }

    public void emitirNotaFiscal(String id, String pedidoId, LocalDate dataEmissao,
                                  List<com.hygor.erick.entities.ItemPedido> itens,
                                  com.hygor.erick.entities.Usuario cliente,
                                  com.hygor.erick.entities.Pagamento pagamento) {
        ValidNotaFiscal valid = new ValidNotaFiscal();
        NotaFiscal nota = valid.validacao(id, pedidoId, dataEmissao, itens, cliente, pagamento);
        repositorio.save(nota);
    }

    public NotaFiscal buscarNotaFiscal(String id) {
        return repositorio.find(id);
    }

    public List<NotaFiscal> listarNotasFiscais() {
        return repositorio.findAll();
    }

    public void cancelarNotaFiscal(String id) {
        repositorio.delete(id);
    }
}
