package com.hygor.erick.TableModel;
/**
 *
 * @author Érick
 */

import com.hygor.erick.entities.Endereço;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TMCadEndereco extends AbstractTableModel {

    private List<Endereço> lista;

    private final int COL_RUA = 0;
    private final int COL_NUMERO = 1;
    private final int COL_COMPLEMENTO = 2;
    private final int COL_BAIRRO = 3;
    private final int COL_CIDADE = 4;
    private final int COL_ESTADO = 5;
    private final int COL_CEP = 6;

    public TMCadEndereco(List<Endereço> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return this.lista.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Endereço aux = new Endereço();
        if (lista.isEmpty()) return aux;
        aux = lista.get(rowIndex);
        return switch (columnIndex) {
            case -1 -> aux;
            case COL_RUA -> aux.getRua();
            case COL_NUMERO -> aux.getNumero();
            case COL_COMPLEMENTO -> aux.getComplemento();
            case COL_BAIRRO -> aux.getBairro();
            case COL_CIDADE -> aux.getCidade();
            case COL_ESTADO -> aux.getEstado();
            case COL_CEP -> aux.getCep();
            default -> aux;
        };
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case COL_RUA -> "Rua";
            case COL_NUMERO -> "Número";
            case COL_COMPLEMENTO -> "Complemento";
            case COL_BAIRRO -> "Bairro";
            case COL_CIDADE -> "Cidade";
            case COL_ESTADO -> "Estado";
            case COL_CEP -> "CEP";
            default -> "";
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }
}
