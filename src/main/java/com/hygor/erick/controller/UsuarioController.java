package com.hygor.erick.controller;

import com.hygor.erick.entities.Usuario;
import com.hygor.erick.DAO.IDAO;

import java.util.List;

public class UsuarioController {
    private IDAO<Usuario> repositorio;

    public UsuarioController(IDAO<Usuario> repositorio) {
        this.repositorio = repositorio;
    }

    public void adicionarUsuario(Usuario usuario) {
        repositorio.save(usuario);
    }

    public Usuario buscarUsuario(String id) {
        return repositorio.find(id);
    }

    public List<Usuario> listarUsuarios() {
        return repositorio.findAll();
    }

    public void removerUsuario(String id) {
        repositorio.delete(id);
    }
}
