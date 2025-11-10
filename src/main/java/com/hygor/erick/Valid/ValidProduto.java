package com.hygor.erick.Valid;

import com.hygor.erick.entities.Produto;
import com.hygor.erick.exception.ProdutoException;

public class ValidProduto {

    public Produto validacao(String id, String nome, String descricao, double preco, int estoque, String fornecedorId) {
        Produto produto = new Produto();

        if (id == null || id.isEmpty()) throw new ProdutoException("Erro - Campo vazio: 'id'");
        produto.setId(id);

        if (nome == null || nome.isEmpty()) throw new ProdutoException("Erro - Campo vazio: 'nome'");
        produto.setNome(nome);

        if (descricao == null || descricao.isEmpty()) throw new ProdutoException("Erro - Campo vazio: 'descricao'");
        produto.setDescricao(descricao);

        if (preco <= 0) throw new ProdutoException("Erro - Preço deve ser maior que zero");
        produto.setPreco(preco);

        if (estoque < 0) throw new ProdutoException("Erro - Estoque não pode ser negativo");
        produto.setEstoque(estoque);

        if (fornecedorId == null || fornecedorId.isEmpty()) throw new ProdutoException("Erro - Campo vazio: 'fornecedorId'");
        produto.setFornecedorId(fornecedorId);

        return produto;
    }
}

