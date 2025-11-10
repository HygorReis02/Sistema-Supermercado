package com.hygor.erick.controller;

import com.hygor.erick.DAO.IDAO;
import com.hygor.erick.entities.Cliente;
import com.hygor.erick.entities.Endereço;

import java.util.List;

public class ClienteController {
    private IDAO<Cliente> repositorio;

    public ClienteController(IDAO<Cliente> repositorio) {
        this.repositorio = repositorio;
    }

    public void adicionarCliente(Cliente cliente) {
        repositorio.save(cliente);
    }

    public Cliente buscarCliente(String id) {
        return repositorio.find(id);
    }

    public List<Cliente> listarClientes() {
        return repositorio.findAll();
    }

    public void removerCliente(String id) {
        repositorio.delete(id);
    }

    public void exibirClientesFormatados() {
        System.out.println("📋 Lista de clientes cadastrados:");
        for (Cliente c : repositorio.findAll()) {
            Endereço e = c.getEndereco();
            System.out.println("- " + c.getNome() + " | CPF: " + c.getCpf() + " | Email: " + c.getEmail());
            System.out.println("  Endereço: " + e.getRua() + ", " + e.getNumero() + " - " + e.getBairro() +
                               ", " + e.getCidade() + " - " + e.getEstado() + " | CEP: " + e.getCep());
        }
    }
}
