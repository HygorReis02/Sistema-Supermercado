package com.hygor.erick.controller;

import com.hygor.erick.DAO.IDAO;
import com.hygor.erick.entities.Fornecedor;


import java.util.List;

public class FornecedorController {
    private IDAO<Fornecedor> repositorio;

    public FornecedorController(IDAO<Fornecedor> repositorio) {
        this.repositorio = repositorio;
    }

    public void adicionarFornecedor(Fornecedor fornecedor) {
        repositorio.save(fornecedor);
    }

    public Fornecedor buscarFornecedor(String id) {
        return repositorio.find(id);
    }

    public List<Fornecedor> listarFornecedores() {
        return repositorio.findAll();
    }

    public void removerFornecedor(String id) {
        repositorio.delete(id);
    }
}
