package nuc.ss.informationtable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * @author hsystart
 * @create 2021-12-28 18:34
 * @description 定义宿舍房间表格
 */
public class DormTable extends JTable {
    public static DefaultTableModel DormModel;

    public DormTable(TableModel dm) {
        super(dm);
    }

    public boolean isCellEditable(int row, int column) {
        if (column == 0) return false;//防止主键被更改
        else return true;
    }
}
