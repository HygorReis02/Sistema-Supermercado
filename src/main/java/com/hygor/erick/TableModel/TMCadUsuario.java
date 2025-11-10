package com.hygor.erick.TableModel;
/**
 *
 * @author Érick
 */
import javax.swing.table.AbstractTableModel;
import java.util.List;
import com.hygor.erick.entities.Usuario;

public class TMCadUsuario extends AbstractTableModel {

    private List<Usuario> lista;

    private final int COL_ID = 0;
    private final int COL_NOME = 1;
    private final int COL_EMAIL = 2;
    private final int COL_PERFIL = 3;

    public TMCadUsuario(List<Usuario> lstUsuarios) {
        this.lista = lstUsuarios;
    }

    @Override
    public int getRowCount() {
        return this.lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario aux = new Usuario();
        if (lista.isEmpty()) {
            return aux;
        } else {
            aux = lista.get(rowIndex);
            switch (columnIndex) {
                case -1: return aux;
                case COL_ID: return aux.getId();
                case COL_NOME: return aux.getNome();
                case COL_EMAIL: return aux.getEmail();
                case COL_PERFIL: return aux.getPerfil();
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
            case COL_EMAIL: return "Email";
            case COL_PERFIL: return "Perfil";
            default: return "";
        }
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        return String.class;
    }
}
