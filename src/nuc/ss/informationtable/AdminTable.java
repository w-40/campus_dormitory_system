package nuc.ss.informationtable;
/**
 * @author 韩思远
 * @description 定义系统管理员表格
 */

import nuc.ss.domain.HouseMaster;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class AdminTable extends JTable {

	public static DefaultTableModel adminModel;
	public AdminTable(TableModel dm) {
		super(dm);
	}

	public boolean isCellEditable(int row, int column){
		if (column==0) return false;//防止主键被更改
		else return true;
	}
	
}
