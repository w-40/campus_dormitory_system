package nuc.ss.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.Vector;

/**
 * @author hsystart
 * @create 2021-12-27 15:52
 */
public class StudentTable extends JTable {
//    public static Vector<Vector<String>> studentData=new Vector<Vector<String>>();
    public static DefaultTableModel studentModel;
    public StudentTable(TableModel dm) {
        super(dm);
    }

    public boolean isCellEditable(int row, int column){
        if (column==0) return false;//防止主键被更改
        else return true;
    }
}