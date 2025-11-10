package com.hygor.erick.entities;

import java.util.Objects;

public class ItemPedido {
    private String id;
    private String pedidoId;
    private String produtoId;
    private int quantidade;
    private double precoUnitario;
    private double subtotal;

    public ItemPedido() {
        this.id = "";
        this.pedidoId = "";
        this.produtoId = "";
        this.quantidade = 0;
        this.precoUnitario = 0.0;
        this.subtotal = 0.0;
    }

    public ItemPedido(String id, String pedidoId, String produtoId, int quantidade, double precoUnitario) {
        this.id = id;
        this.pedidoId = pedidoId;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.subtotal = quantidade * precoUnitario;
    }

    //Outro
    public ItemPedido(ItemPedido other) {
        this.id = other.getId();
        this.pedidoId = other.getPedidoId();
        this.produtoId = other.getProdutoId();
        this.quantidade = other.getQuantidade();
        this.precoUnitario = other.getPrecoUnitario();
        this.subtotal = other.getSubtotal();
    }

    //Copiar
    public void copy(ItemPedido other) {
        this.id = other.getId();
        this.pedidoId = other.getPedidoId();
        this.produtoId = other.getProdutoId();
        this.quantidade = other.getQuantidade();
        this.precoUnitario = other.getPrecoUnitario();
        this.subtotal = other.getSubtotal();
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getPedidoId() {
        return pedidoId;
    }

    public String getProdutoId() {
        return produtoId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setPedidoId(String pedidoId) {
        this.pedidoId = pedidoId;
    }

    public void setProdutoId(String produtoId) {
        this.produtoId = produtoId;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        calcularSubtotal();
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
        calcularSubtotal();
    }

    public void calcularSubtotal() {
        this.subtotal = this.quantidade * this.precoUnitario;
    }

    @Override
    public String toString() {
        return "ItemPedido{id=" + id + ", pedidoId=" + pedidoId + ", produtoId=" + produtoId +
               ", quantidade=" + quantidade + ", precoUnitario=" + precoUnitario +
               ", subtotal=" + subtotal + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pedidoId, produtoId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ItemPedido other = (ItemPedido) obj;
        return Objects.equals(this.id, other.id) &&
               Objects.equals(this.pedidoId, other.pedidoId) &&
               Objects.equals(this.produtoId, other.produtoId);
    }
}
