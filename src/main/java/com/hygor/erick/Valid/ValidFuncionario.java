package com.hygor.erick.Valid;

import com.hygor.erick.entities.Funcionario;
import com.hygor.erick.entities.Endereço;
import com.hygor.erick.exception.FuncionarioException;

public class ValidFuncionario {

    public Funcionario validacao(String id, String nome, String cpf, String email, String cargo,
                                 String rua, String numero, String complemento, String bairro,
                                 String cidade, String estado, String cep) {

        Funcionario funcionario = new Funcionario();

        if (id == null || id.isEmpty()) throw new FuncionarioException("Erro - Campo vazio: 'id'");
        funcionario.setId(id);

        if (nome == null || nome.isEmpty()) throw new FuncionarioException("Erro - Campo vazio: 'nome'");
        funcionario.setNome(nome);

        if (cpf == null || cpf.isEmpty()) throw new FuncionarioException("Erro - Campo vazio: 'cpf'");
        funcionario.setCpf(cpf);

        if (email == null || email.isEmpty()) throw new FuncionarioException("Erro - Campo vazio: 'email'");
        funcionario.setEmail(email);

        if (cargo == null || cargo.isEmpty()) throw new FuncionarioException("Erro - Campo vazio: 'cargo'");
        funcionario.setCargo(cargo);

        // Validação do endereço
        ValidEndereço validadorEndereco = new ValidEndereço();
        Endereço endereco = validadorEndereco.validacao(rua, numero, complemento, bairro, cidade, estado, cep);
        funcionario.setEndereco(endereco);

        return funcionario;
    }
}
