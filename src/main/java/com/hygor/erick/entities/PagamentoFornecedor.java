package com.hygor.erick.entities;

import java.time.LocalDate;
import java.util.Objects;

public class PagamentoFornecedor {
    private String id;
    private String fornecedorId;
    private double valorPago;
    private LocalDate dataPagamento;
    private String metodoPagamento;
    private String status;

    public PagamentoFornecedor() {
        this.id = "";
        this.fornecedorId = "";
        this.valorPago = 0.0;
        this.dataPagamento = LocalDate.now();
        this.metodoPagamento = "";
        this.status = "";
    }

    public PagamentoFornecedor(String id, String fornecedorId, double valorPago, LocalDate dataPagamento, String metodoPagamento, String status) {
        this.id = id;
        this.fornecedorId = fornecedorId;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.metodoPagamento = metodoPagamento;
        this.status = status;
    }

    //Outro
    public PagamentoFornecedor(PagamentoFornecedor other) {
        this.id = other.getId();
        this.fornecedorId = other.getFornecedorId();
        this.valorPago = other.getValorPago();
        this.dataPagamento = other.getDataPagamento();
        this.metodoPagamento = other.getMetodoPagamento();
        this.status = other.getStatus();
    }

    //Copiar
    public void copy(PagamentoFornecedor other) {
        this.id = other.getId();
        this.fornecedorId = other.getFornecedorId();
        this.valorPago = other.getValorPago();
        this.dataPagamento = other.getDataPagamento();
        this.metodoPagamento = other.getMetodoPagamento();
        this.status = other.getStatus();
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getFornecedorId() {
        return fornecedorId;
    }

    public double getValorPago() {
        return valorPago;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setFornecedorId(String fornecedorId) {
        this.fornecedorId = fornecedorId;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PagamentoFornecedor{id=" + id + ", fornecedorId=" + fornecedorId + ", valorPago=" + valorPago +
               ", dataPagamento=" + dataPagamento + ", metodoPagamento=" + metodoPagamento + ", status=" + status + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fornecedorId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PagamentoFornecedor other = (PagamentoFornecedor) obj;
        return Objects.equals(this.id, other.id) && Objects.equals(this.fornecedorId, other.fornecedorId);
    }
}
