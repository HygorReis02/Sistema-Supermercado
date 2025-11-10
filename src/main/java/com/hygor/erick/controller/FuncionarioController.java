package com.hygor.erick.controller;

import com.hygor.erick.DAO.IDAO;
import com.hygor.erick.entities.Funcionario;
import com.hygor.erick.entities.Endereço;

import java.util.List;

public class FuncionarioController {
    private IDAO<Funcionario> repositorio;

    public FuncionarioController(IDAO<Funcionario> repositorio) {
        this.repositorio = repositorio;
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        repositorio.save(funcionario);
    }

    public Funcionario buscarFuncionario(String id) {
        return repositorio.find(id);
    }

    public List<Funcionario> listarFuncionarios() {
        return repositorio.findAll();
    }

    public void removerFuncionario(String id) {
        repositorio.delete(id);
    }

    public void exibirFuncionariosFormatados() {
        System.out.println("👥 Lista de funcionários:");
        for (Funcionario f : repositorio.findAll()) {
            Endereço e = f.getEndereco();
            System.out.println("- " + f.getNome() + " | CPF: " + f.getCpf() + " | Cargo: " + f.getCargo());
            System.out.println("  Email: " + f.getEmail());
            System.out.println("  Endereço: " + e.getRua() + ", " + e.getNumero() + " - " + e.getBairro() +
                               ", " + e.getCidade() + " - " + e.getEstado() + " | CEP: " + e.getCep());
        }
    }
}
