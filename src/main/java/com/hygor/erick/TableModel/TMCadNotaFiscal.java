package com.hygor.erick.TableModel;
/**
 *
 * @author Érick
 */

import javax.swing.table.AbstractTableModel;
import java.util.List;
import com.hygor.erick.entities.NotaFiscal;

public class TMCadNotaFiscal extends AbstractTableModel {

    private List<NotaFiscal> lista;

    private final int COL_ID = 0;
    private final int COL_PEDIDO = 1;
    private final int COL_CLIENTE = 2;
    private final int COL_DATA = 3;
    private final int COL_TOTAL = 4;

    public TMCadNotaFiscal(List<NotaFiscal> lstNotas) {
        this.lista = lstNotas;
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
        NotaFiscal aux = new NotaFiscal();
        if (lista.isEmpty()) return aux;
        aux = lista.get(rowIndex);
        return switch (columnIndex) {
            case -1 -> aux;
            case COL_ID -> aux.getId();
            case COL_PEDIDO -> aux.getPedidoId();
            case COL_CLIENTE -> aux.getDadosCliente().getNome();
            case COL_DATA -> aux.getDataEmissao();
            case COL_TOTAL -> aux.getValorTotal();
            default -> aux;
        };
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case COL_ID -> "ID";
            case COL_PEDIDO -> "Pedido";
            case COL_CLIENTE -> "Cliente";
            case COL_DATA -> "Data Emissão";
            case COL_TOTAL -> "Total";
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
