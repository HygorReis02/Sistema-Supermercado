package com.hygor.erick.Valid;

import com.hygor.erick.entities.Fornecedor;
import com.hygor.erick.entities.Endereço;
import com.hygor.erick.exception.FornecedorException;

public class ValidFornecedor {

    public Fornecedor validacao(String id, String nomeEmpresa, String cnpj, String email, String telefone,
                                String rua, String numero, String complemento, String bairro,
                                String cidade, String estado, String cep) {

        Fornecedor fornecedor = new Fornecedor();

        if (id == null || id.isEmpty()) throw new FornecedorException("Erro - Campo vazio: 'id'");
        fornecedor.setId(id);

        if (nomeEmpresa == null || nomeEmpresa.isEmpty()) throw new FornecedorException("Erro - Campo vazio: 'nomeEmpresa'");
        fornecedor.setNomeEmpresa(nomeEmpresa);

        if (cnpj == null || cnpj.isEmpty()) throw new FornecedorException("Erro - Campo vazio: 'cnpj'");
        fornecedor.setCnpj(cnpj);

        if (email == null || email.isEmpty()) throw new FornecedorException("Erro - Campo vazio: 'email'");
        fornecedor.setEmail(email);

        if (telefone == null || telefone.isEmpty()) throw new FornecedorException("Erro - Campo vazio: 'telefone'");
        fornecedor.setTelefone(telefone);

        // Validação do endereço
        ValidEndereço validadorEndereco = new ValidEndereço();
        Endereço endereco = validadorEndereco.validacao(rua, numero, complemento, bairro, cidade, estado, cep);
        fornecedor.setEndereco(endereco);

        return fornecedor;
    }
}
