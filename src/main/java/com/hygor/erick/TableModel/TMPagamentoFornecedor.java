package com.hygor.erick.TableModel;
/**
 *
 * @author Érick
 */

import com.hygor.erick.entities.PagamentoFornecedor;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TMPagamentoFornecedor extends AbstractTableModel {

    private List<PagamentoFornecedor> lista;

    private final int COL_ID = 0;
    private final int COL_FORNECEDOR = 1;
    private final int COL_VALOR = 2;
    private final int COL_DATA = 3;
    private final int COL_METODO = 4;
    private final int COL_STATUS = 5;

    public TMPagamentoFornecedor(List<PagamentoFornecedor> lista) {
        this.lista = lista;
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
        PagamentoFornecedor aux = new PagamentoFornecedor();
        if (lista.isEmpty()) return aux;
        aux = lista.get(rowIndex);
        return switch (columnIndex) {
            case -1 -> aux;
            case COL_ID -> aux.getId();
            case COL_FORNECEDOR -> aux.getFornecedorId();
            case COL_VALOR -> aux.getValorPago();
            case COL_DATA -> aux.getDataPagamento();
            case COL_METODO -> aux.getMetodoPagamento();
            case COL_STATUS -> aux.getStatus();
            default -> aux;
        };
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case COL_ID -> "ID";
            case COL_FORNECEDOR -> "Fornecedor";
            case COL_VALOR -> "Valor Pago";
            case COL_DATA -> "Data";
            case COL_METODO -> "Método";
            case COL_STATUS -> "Status";
            default -> "";
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        return switch (columnIndex) {
            case COL_VALOR -> Double.class;
            case COL_DATA -> java.time.LocalDate.class;
            default -> String.class;
        };
    }
}
