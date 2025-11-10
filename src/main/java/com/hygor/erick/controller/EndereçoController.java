package com.hygor.erick.controller;

import com.hygor.erick.DAO.IDAO;
import com.hygor.erick.entities.Endereço;

import java.util.List;

public class EndereçoController {
    private IDAO<Endereço> repositorio;

    public EndereçoController(IDAO<Endereço> repositorio) {
        this.repositorio = repositorio;
    }

    public void adicionarEndereco(Endereço endereco) {
        repositorio.save(endereco);
    }

    public Endereço buscarEndereco(String id) {
        return repositorio.find(id);
    }

    public List<Endereço> listarEnderecos() {
        return repositorio.findAll();
    }

    public void removerEndereco(String id) {
        repositorio.delete(id);
    }

    public void exibirEnderecosFormatados() {
        System.out.println("📍 Endereços cadastrados:");
        for (Endereço e : repositorio.findAll()) {
            System.out.println("- " + e.toString());
        }
    }
}
