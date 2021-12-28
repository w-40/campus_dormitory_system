package nuc.ss.informationtable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class VisitorTable extends JTable {
    public static DefaultTableModel visitorModel;
    public VisitorTable(TableModel dm) {
        super(dm);
    }

    public boolean isCellEditable(int row, int column){
        if (column==0) return false;//防止主键被更改
        else return true;
    }
}
