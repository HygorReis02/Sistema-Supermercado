package com.hygor.erick.Valid;

import com.hygor.erick.entities.Administrador;
import com.hygor.erick.entities.Endereço;
import com.hygor.erick.exception.AdministradorException;

public class ValidAdministrador {

    public Administrador validacao(String id, String nome, String cpf, String telefone, String email,
                                   String rua, String numero, String complemento, String bairro,
                                   String cidade, String estado, String cep) {

        Administrador admin = new Administrador();

        if (id == null || id.isEmpty()) throw new AdministradorException("Erro - Campo vazio: 'id'");
        admin.setId(id);

        if (nome == null || nome.isEmpty()) throw new AdministradorException("Erro - Campo vazio: 'nome'");
        admin.setNome(nome);

        if (cpf == null || cpf.isEmpty()) throw new AdministradorException("Erro - Campo vazio: 'cpf'");
        admin.setCpf(cpf);

        if (telefone == null || telefone.isEmpty()) throw new AdministradorException("Erro - Campo vazio: 'telefone'");
        admin.setTelefone(telefone);

        if (email == null || email.isEmpty()) throw new AdministradorException("Erro - Campo vazio: 'email'");
        admin.setEmail(email);

        // Validação do endereço
        ValidEndereço validadorEndereco = new ValidEndereço();
        Endereço endereco = validadorEndereco.validacao(rua, numero, complemento, bairro, cidade, estado, cep);
        admin.setEndereco(endereco);

        return admin;
    }
}
