package nuc.ss.informationtable;
/**
 * @author
 * @description 籍乃博
 * @description 定义学生违纪信息表格
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class StudentViolatinOfDisciplineTable extends JTable {
    public static DefaultTableModel studentViolatinOfDisciplineModel;

    public StudentViolatinOfDisciplineTable(TableModel dm) {
        super(dm);
    }

    public boolean isCellEditable(int row, int column) {
        if (column == 0) return false;//防止主键被更改
        else return true;
    }
}
