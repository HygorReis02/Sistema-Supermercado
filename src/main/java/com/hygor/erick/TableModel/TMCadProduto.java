package com.hygor.erick.TableModel;
/**
 *
 * @author Érick
 */
import javax.swing.table.AbstractTableModel;
import java.util.List;
import com.hygor.erick.entities.Produto;

public class TMCadProduto extends AbstractTableModel {

    private List<Produto> lista;

    private final int COL_ID = 0;
    private final int COL_NOME = 1;
    private final int COL_DESCRICAO = 2;
    private final int COL_PRECO = 3;
    private final int COL_ESTOQUE = 4;
    private final int COL_FORNECEDOR = 5;

    public TMCadProduto(List<Produto> lstProdutos) {
        this.lista = lstProdutos;
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
        Produto aux = new Produto();
        if (lista.isEmpty()) {
            return aux;
        } else {
            aux = lista.get(rowIndex);
            switch (columnIndex) {
                case -1: return aux;
                case COL_ID: return aux.getId();
                case COL_NOME: return aux.getNome();
                case COL_DESCRICAO: return aux.getDescricao();
                case COL_PRECO: return aux.getPreco();
                case COL_ESTOQUE: return aux.getEstoque();
                case COL_FORNECEDOR: return aux.getFornecedorId();
                default: break;
            }
        }
        return aux;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case COL_ID: return "ID";
            case COL_NOME: return "Nome";
            case COL_DESCRICAO: return "Descrição";
            case COL_PRECO: return "Preço";
            case COL_ESTOQUE: return "Estoque";
            case COL_FORNECEDOR: return "Fornecedor";
            default: return "";
        }
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        return String.class;
    }
}

