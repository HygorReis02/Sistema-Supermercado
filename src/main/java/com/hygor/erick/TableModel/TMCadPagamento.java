package com.hygor.erick.TableModel;
/**
 *
 * @author Érick
 */

import javax.swing.table.AbstractTableModel;
import java.util.List;
import com.hygor.erick.entities.Pagamento;

public class TMCadPagamento extends AbstractTableModel {

    private List<Pagamento> lista;

    private final int COL_ID = 0;
    private final int COL_PEDIDO = 1;
    private final int COL_METODO = 2;
    private final int COL_VALOR = 3;
    private final int COL_STATUS = 4;
    private final int COL_DATA = 5;

    public TMCadPagamento(List<Pagamento> lstPagamentos) {
        this.lista = lstPagamentos;
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
        Pagamento aux = new Pagamento();
        if (lista.isEmpty()) return aux;
        aux = lista.get(rowIndex);
        return switch (columnIndex) {
            case -1 -> aux;
            case COL_ID -> aux.getId();
            case COL_PEDIDO -> aux.getPedido().getId();
            case COL_METODO -> aux.getMetodo();
            case COL_VALOR -> aux.getValorPago();
            case COL_STATUS -> aux.getStatus();
            case COL_DATA -> aux.getDataPagamento();
            default -> aux;
        };
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case COL_ID -> "ID";
            case COL_PEDIDO -> "Pedido";
            case COL_METODO -> "Método";
            case COL_VALOR -> "Valor Pago";
            case COL_STATUS -> "Status";
            case COL_DATA -> "Data";
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

