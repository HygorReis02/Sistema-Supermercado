package com.hygor.erick.Valid;

import com.hygor.erick.exception.PessoaException;
import com.hygor.erick.entities.Usuario;

public class ValidUsuario {

    public Usuario validacao(String id, String nome, String email, String senha, String perfil) {
        Usuario usuario = new Usuario();

        if (id.isEmpty()) throw new PessoaException("Erro - Campo vazio: 'id'");
        usuario.setId(id);

        if (nome.isEmpty()) throw new PessoaException("Erro - Campo vazio: 'nome'");
        usuario.setNome(nome);

        if (email.isEmpty()) throw new PessoaException("Erro - Campo vazio: 'email'");
        usuario.setEmail(email);

        if (senha.isEmpty()) throw new PessoaException("Erro - Campo vazio: 'senha'");
        usuario.setSenha(senha);

        if (perfil.isEmpty()) throw new PessoaException("Erro - Campo vazio: 'perfil'");
        usuario.setPerfil(perfil);

        return usuario;
    }
}
