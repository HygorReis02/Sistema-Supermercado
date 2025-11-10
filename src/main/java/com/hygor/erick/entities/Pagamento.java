package com.hygor.erick.entities;

import java.time.LocalDate;
import java.util.Objects;

public class Pagamento {
    private String id;
    private Pedido pedido;
    private MetodoPagamento metodo;
    private double valorPago;
    private String status;
    private LocalDate dataPagamento;

    public Pagamento() {
        this.id = "";
        this.pedido = new Pedido();
        this.metodo = MetodoPagamento.DINHEIRO;
        this.valorPago = 0.0;
        this.status = "PENDENTE";
        this.dataPagamento = LocalDate.now();
    }

    public Pagamento(String id, Pedido pedido, MetodoPagamento metodo, double valorPago, String status, LocalDate dataPagamento) {
        this.id = id;
        this.pedido = pedido;
        this.metodo = metodo;
        this.valorPago = valorPago;
        this.status = status;
        this.dataPagamento = dataPagamento;
    }

    public Pagamento(Pagamento other) {
    this.id = other.getId();
    this.pedido = other.getPedido();
    this.metodo = other.getMetodo();
    this.valorPago = other.getValorPago();
    this.status = other.getStatus();
    this.dataPagamento = other.getDataPagamento();
}

    //Validar Pagamento
    public boolean validarPagamento() {
        switch (metodo) {
            case DINHEIRO:
                return valorPago >= pedido.getValorTotal();
            case CARTAO_CREDITO:
            case CARTAO_DEBITO:
            case PIX:
                return valorPago == pedido.getValorTotal();
            default:
                return false;
        }
    }

    //Troco
    public double calcularTroco() {
        if (metodo == MetodoPagamento.DINHEIRO && valorPago > pedido.getValorTotal()) {
            return valorPago - pedido.getValorTotal();
        }
        return 0.0;
    }

    //Confirmar
    public void confirmarPagamento() {
        if (validarPagamento()) {
            this.status = "CONFIRMADO";
            this.dataPagamento = LocalDate.now();
            pedido.setStatus("PAGO");
        } else {
            this.status = "FALHA";
        }
    }

    public String getId() {
        return id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public MetodoPagamento getMetodo() {
        return metodo;
    }

    public double getValorPago() {
        return valorPago;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void setMetodo(MetodoPagamento metodo) {
        this.metodo = metodo;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    @Override
    public String toString() {
        return "Pagamento{id=" + id + ", pedidoId=" + pedido.getId() + ", metodo=" + metodo +
               ", valorPago=" + valorPago + ", status=" + status + ", dataPagamento=" + dataPagamento + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pedido.getId());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pagamento other = (Pagamento) obj;
        return Objects.equals(this.id, other.id) && Objects.equals(this.pedido.getId(), other.pedido.getId());
    }
}
