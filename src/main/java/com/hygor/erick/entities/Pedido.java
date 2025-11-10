package com.hygor.erick.entities;

import java.time.LocalDate;
import java.util.Objects;

public class Pedido {
    private String id;
    private String clienteId;
    private double valorTotal;
    private LocalDate data;
    private String status;

    public Pedido() {
        this.id = "";
        this.clienteId = "";
        this.valorTotal = 0.0;
        this.data = LocalDate.now();
        this.status = "PENDENTE";
    }

    public Pedido(String id, String clienteId, double valorTotal, LocalDate data, String status) {
        this.id = id;
        this.clienteId = clienteId;
        this.valorTotal = valorTotal;
        this.data = data;
        this.status = status;
    }

    public Pedido(Pedido other) {
        this.id = other.getId();
        this.clienteId = other.getClienteId();
        this.valorTotal = other.getValorTotal();
        this.data = other.getData();
        this.status = other.getStatus();
}

    public String getId() {
        return id;
    }

    public String getClienteId() {
        return clienteId;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public LocalDate getData() {
        return data;
    }

    public String getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pedido{id=" + id + ", clienteId=" + clienteId + ", valorTotal=" + valorTotal +
               ", data=" + data + ", status=" + status + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clienteId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pedido other = (Pedido) obj;
        return Objects.equals(this.id, other.id) && Objects.equals(this.clienteId, other.clienteId);
    }
}
