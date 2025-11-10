package com.hygor.erick.controller;

import com.hygor.erick.DAO.IDAO;
import com.hygor.erick.entities.Produto;


import java.util.List;

public class ProdutoController {
    private IDAO<Produto> repositorio;

    public ProdutoController(IDAO<Produto> repositorio) {
        this.repositorio = repositorio;
    }

    public void adicionarProduto(Produto produto) {
        repositorio.save(produto);
    }

    public Produto buscarProduto(String id) {
        return repositorio.find(id);
    }

    public List<Produto> listarProdutos() {
        return repositorio.findAll();
    }

    public void removerProduto(String id) {
        repositorio.delete(id);
    }
}
