package com.hygor.erick.Valid;

import com.hygor.erick.entities.Cliente;
import com.hygor.erick.entities.Endereço;
import com.hygor.erick.exception.ClienteException;

public class ValidCliente {

    public Cliente validacao(String id, String nome, String cpf, String email,
                             String rua, String numero, String complemento, String bairro,
                             String cidade, String estado, String cep) {

        Cliente cliente = new Cliente();

        if (id == null || id.isEmpty()) throw new ClienteException("Erro - Campo vazio: 'id'");
        cliente.setId(id);

        if (nome == null || nome.isEmpty()) throw new ClienteException("Erro - Campo vazio: 'nome'");
        cliente.setNome(nome);

        if (cpf == null || cpf.isEmpty()) throw new ClienteException("Erro - Campo vazio: 'cpf'");
        cliente.setCpf(cpf);

        if (email == null || email.isEmpty()) throw new ClienteException("Erro - Campo vazio: 'email'");
        cliente.setEmail(email);

        // Validação do endereço
        ValidEndereço validadorEndereco = new ValidEndereço();
        Endereço endereco = validadorEndereco.validacao(rua, numero, complemento, bairro, cidade, estado, cep);
        cliente.setEndereco(endereco);

        return cliente;
    }
}
