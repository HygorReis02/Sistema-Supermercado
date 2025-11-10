package com.hygor.erick.TableModel;
/**
 *
 * @author Érick
 */


import javax.swing.table.AbstractTableModel;
import java.util.List;
import com.hygor.erick.entities.Administrador;

public class TMCadAdministrador extends AbstractTableModel {

    private List<Administrador> lista;

    private final int COL_ID = 0;
    private final int COL_NOME = 1;
    private final int COL_CPF = 2;
    private final int COL_TELEFONE = 3;
    private final int COL_EMAIL = 4;
    private final int COL_ENDERECO = 5;

    public TMCadAdministrador(List<Administrador> lstAdministradores) {
        this.lista = lstAdministradores;
    }

    @Override
    public int getRowCount() {
        return this.lista.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Administrador aux = new Administrador();
        if (lista.isEmpty()) return aux;
        aux = lista.get(rowIndex);
        return switch (columnIndex) {
            case -1 -> aux;
            case COL_ID -> aux.getId();
            case COL_NOME -> aux.getNome();
            case COL_CPF -> aux.getCpf();
            case COL_TELEFONE -> aux.getTelefone();
            case COL_EMAIL -> aux.getEmail();
            case COL_ENDERECO -> aux.getEndereco();
            default -> aux;
        };
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case COL_ID -> "ID";
            case COL_NOME -> "Nome";
            case COL_CPF -> "CPF";
            case COL_TELEFONE -> "Telefone";
            case COL_EMAIL -> "Email";
            case COL_ENDERECO -> "Endereço";
            default -> "";
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        return String.class;
    }
}
