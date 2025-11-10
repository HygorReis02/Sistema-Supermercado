package com.hygor.erick.TableModel;
/**
 *
 * @author Érick
 */

import javax.swing.table.AbstractTableModel;
import java.util.List;
import com.hygor.erick.entities.Pedido;

public class TMCadPedido extends AbstractTableModel {

    private List<Pedido> lista;

    private final int COL_ID = 0;
    private final int COL_CLIENTE = 1;
    private final int COL_VALOR = 2;
    private final int COL_DATA = 3;
    private final int COL_STATUS = 4;

    public TMCadPedido(List<Pedido> lstPedidos) {
        this.lista = lstPedidos;
    }

    @Override
    public int getRowCount() {
        return this.lista.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pedido aux = new Pedido();
        if (lista.isEmpty()) return aux;
        aux = lista.get(rowIndex);
        return switch (columnIndex) {
            case -1 -> aux;
            case COL_ID -> aux.getId();
            case COL_CLIENTE -> aux.getClienteId();
            case COL_VALOR -> aux.getValorTotal();
            case COL_DATA -> aux.getData();
            case COL_STATUS -> aux.getStatus();
            default -> aux;
        };
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case COL_ID -> "ID";
            case COL_CLIENTE -> "Cliente";
            case COL_VALOR -> "Valor Total";
            case COL_DATA -> "Data";
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
        return String.class;
    }
}

