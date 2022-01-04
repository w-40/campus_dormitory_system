package nuc.ss.informationtable;
/**
 * @author 卫黎明
 * @description 学生留言表
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class StudentMessageTable extends JTable {
    public static DefaultTableModel studentMessageModel;

    public StudentMessageTable(TableModel dm) {
        super(dm);
    }

    public boolean isCellEditable(int row, int column) {
        if (column == 0) return false;//防止主键被更改
        else return true;
    }
}
