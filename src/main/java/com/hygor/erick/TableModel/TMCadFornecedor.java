package com.hygor.erick.TableModel;
/**
 *
 * @author Érick
 */
import javax.swing.table.AbstractTableModel;
import java.util.List;
import com.hygor.erick.entities.Fornecedor;

public class TMCadFornecedor extends AbstractTableModel {

    private List<Fornecedor> lista;

    private final int COL_ID = 0;
    private final int COL_EMPRESA = 1;
    private final int COL_CNPJ = 2;
    private final int COL_EMAIL = 3;
    private final int COL_TELEFONE = 4;
    private final int COL_ENDERECO = 5;

    public TMCadFornecedor(List<Fornecedor> lstFornecedores) {
        this.lista = lstFornecedores;
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
        Fornecedor aux = new Fornecedor();
        if (lista.isEmpty()) return aux;
        aux = lista.get(rowIndex);
        return switch (columnIndex) {
            case -1 -> aux;
            case COL_ID -> aux.getId();
            case COL_EMPRESA -> aux.getNomeEmpresa();
            case COL_CNPJ -> aux.getCnpj();
            case COL_EMAIL -> aux.getEmail();
            case COL_TELEFONE -> aux.getTelefone();
            case COL_ENDERECO -> aux.getEndereco();
            default -> aux;
        };
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case COL_ID -> "ID";
            case COL_EMPRESA -> "Empresa";
            case COL_CNPJ -> "CNPJ";
            case COL_EMAIL -> "Email";
            case COL_TELEFONE -> "Telefone";
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
