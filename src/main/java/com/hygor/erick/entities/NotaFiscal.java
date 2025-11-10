package com.hygor.erick.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NotaFiscal {
    private String id;
    private String pedidoId;
    private LocalDate dataEmissao;
    private double valorTotal;
    private List<ItemPedido> itens;
    private Usuario dadosCliente;
    private Pagamento dadosPagamento;

    public NotaFiscal() {
        this.id = "";
        this.pedidoId = "";
        this.dataEmissao = LocalDate.now();
        this.valorTotal = 0.0;
        this.itens = new ArrayList<>();
        this.dadosCliente = new Usuario();
        this.dadosPagamento = new Pagamento();
    }

    public NotaFiscal(String id, String pedidoId, LocalDate dataEmissao,
                      List<ItemPedido> itens, Usuario dadosCliente, Pagamento dadosPagamento) {
        this.id = id;
        this.pedidoId = pedidoId;
        this.dataEmissao = dataEmissao;
        this.itens = itens;
        this.dadosCliente = dadosCliente;
        this.dadosPagamento = dadosPagamento;
        calcularValorTotal();
    }

    public NotaFiscal(NotaFiscal other) {
        this.id = other.getId();
        this.pedidoId = other.getPedidoId();
        this.dataEmissao = other.getDataEmissao();
        this.itens = new ArrayList<>(other.getItens());
        this.dadosCliente = new Usuario(other.getDadosCliente());
        this.dadosPagamento = new Pagamento(other.getDadosPagamento());
        this.valorTotal = other.getValorTotal();
    }

    public void copy(NotaFiscal other) {
        this.id = other.getId();
        this.pedidoId = other.getPedidoId();
        this.dataEmissao = other.getDataEmissao();
        this.itens = new ArrayList<>(other.getItens());
        this.dadosCliente = new Usuario(other.getDadosCliente());
        this.dadosPagamento = new Pagamento(other.getDadosPagamento());
        this.valorTotal = other.getValorTotal();
    }

    public void calcularValorTotal() {
        this.valorTotal = itens.stream()
                .mapToDouble(ItemPedido::getSubtotal)
                .sum();
    }

    public String gerarResumo() {
        StringBuilder sb = new StringBuilder();
        sb.append("📄 Nota Fiscal: ").append(id).append("\n");
        sb.append("Pedido: ").append(pedidoId).append(" | Emitida em: ").append(dataEmissao).append("\n");
        sb.append("Cliente: ").append(dadosCliente.getNome()).append(" | Email: ").append(dadosCliente.getEmail()).append("\n");
        sb.append("Pagamento: ").append(dadosPagamento.getMetodo()).append(" | Valor Pago: R$ ").append(dadosPagamento.getValorPago()).append("\n");
        sb.append("Itens:\n");
        for (ItemPedido item : itens) {
            sb.append("- ").append(item.getProdutoId())
              .append(" x").append(item.getQuantidade())
              .append(" @ R$").append(item.getPrecoUnitario())
              .append(" = R$").append(item.getSubtotal()).append("\n");
        }
        sb.append("Total: R$ ").append(valorTotal);
        return sb.toString();
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getPedidoId() {
        return pedidoId;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public Usuario getDadosCliente() {
        return dadosCliente;
    }

    public Pagamento getDadosPagamento() {
        return dadosPagamento;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setPedidoId(String pedidoId) {
        this.pedidoId = pedidoId;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
        calcularValorTotal();
    }

    public void setDadosCliente(Usuario dadosCliente) {
        this.dadosCliente = dadosCliente;
    }

    public void setDadosPagamento(Pagamento dadosPagamento) {
        this.dadosPagamento = dadosPagamento;
    }
    
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
}


    @Override
    public String toString() {
        return "NotaFiscal{id=" + id + ", pedidoId=" + pedidoId +
               ", dataEmissao=" + dataEmissao + ", valorTotal=" + valorTotal + "}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pedidoId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        NotaFiscal other = (NotaFiscal) obj;
        return Objects.equals(this.id, other.id) && Objects.equals(this.pedidoId, other.pedidoId);
    }
}
