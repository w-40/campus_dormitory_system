package nuc.ss.view;
/**
 * @author 韩思远
 * @description 定义系统管理员表格
 */

import nuc.ss.domain.HouseMaster;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;

public class AdminTable extends JTable {
	public static AdminTable adminTable;
	public static ArrayList<String> tableHeadList;
	public static Vector<Vector<String>> tableData=new Vector<Vector<String>>();
	public AdminTable(Vector adminData,Vector title){
		super(adminData,title);
	}
	public boolean isCellEditable(int row,int column){
		if (column==0) return false;//防止主键被更改
		else return true;
	}
	
}
