package com.hygor.erick.TableModel;
/**
 *
 * @author Érick
 */

import javax.swing.table.AbstractTableModel;
import java.util.List;
import com.hygor.erick.entities.ItemPedido;

public class TMCadItemPedido extends AbstractTableModel {

    private List<ItemPedido> lista;

    private final int COL_ID = 0;
    private final int COL_PEDIDO = 1;
    private final int COL_PRODUTO = 2;
    private final int COL_QUANTIDADE = 3;
    private final int COL_PRECO_UNIT = 4;
    private final int COL_SUBTOTAL = 5;

    public TMCadItemPedido(List<ItemPedido> lstItens) {
        this.lista = lstItens;
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
        ItemPedido aux = new ItemPedido();
        if (lista.isEmpty()) return aux;
        aux = lista.get(rowIndex);
        return switch (columnIndex) {
            case -1 -> aux;
            case COL_ID -> aux.getId();
            case COL_PEDIDO -> aux.getPedidoId();
            case COL_PRODUTO -> aux.getProdutoId();
            case COL_QUANTIDADE -> aux.getQuantidade();
            case COL_PRECO_UNIT -> aux.getPrecoUnitario();
            case COL_SUBTOTAL -> aux.getSubtotal();
            default -> aux;
        };
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case COL_ID -> "ID";
            case COL_PEDIDO -> "Pedido";
            case COL_PRODUTO -> "Produto";
            case COL_QUANTIDADE -> "Quantidade";
            case COL_PRECO_UNIT -> "Preço Unitário";
            case COL_SUBTOTAL -> "Subtotal";
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

