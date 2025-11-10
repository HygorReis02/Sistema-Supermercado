package com.hygor.erick.TableModel;
/**
 *
 * @author Érick
 */

import javax.swing.table.AbstractTableModel;
import java.util.List;
import com.hygor.erick.entities.Feedback;

public class TMCadFeedback extends AbstractTableModel {

    private List<Feedback> lista;

    private final int COL_ID = 0;
    private final int COL_USUARIO = 1;
    private final int COL_COMENTARIO = 2;
    private final int COL_NOTA = 3;
    private final int COL_DATA = 4;

    public TMCadFeedback(List<Feedback> lstFeedbacks) {
        this.lista = lstFeedbacks;
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
        Feedback aux = new Feedback();
        if (lista.isEmpty()) return aux;
        aux = lista.get(rowIndex);
        return switch (columnIndex) {
            case -1 -> aux;
            case COL_ID -> aux.getId();
            case COL_USUARIO -> aux.getUsuarioId();
            case COL_COMENTARIO -> aux.getComentario();
            case COL_NOTA -> aux.getNota();
            case COL_DATA -> aux.getData();
            default -> aux;
        };
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case COL_ID -> "ID";
            case COL_USUARIO -> "Usuário";
            case COL_COMENTARIO -> "Comentário";
            case COL_NOTA -> "Nota";
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
