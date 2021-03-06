package nuc.ss.informationtable;
/**
 * @author hsystart
 * @create 2021-12-27 20:45
 * @description 定义宿舍楼信息表格
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class DormitoryTable extends JTable {
    public static DefaultTableModel dormitoryModel;

    public DormitoryTable(TableModel dm) {
        super(dm);
    }

    public boolean isCellEditable(int row, int column) {
        if (column == 0) return false;//防止主键被更改
        else return true;
    }
}
