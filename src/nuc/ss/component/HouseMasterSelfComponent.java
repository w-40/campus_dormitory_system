package nuc.ss.component;

/**
 * @author 籍乃博
 */
import nuc.ss.controller.HouseMasterManager_HouseMasterSelf_Controller;
/**
 * @author 籍乃博
 * @description 个人账户管理界面
 */
import nuc.ss.controller.SystemController_HouseMasterManage_Controller;
import nuc.ss.domain.HouseMaster;
import nuc.ss.dialog.AddHouseMasterJDialog;
import nuc.ss.informationtable.AdminTable;
import sun.swing.table.DefaultTableCellHeaderRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import static nuc.ss.informationtable.AdminTable.adminModel;

public class HouseMasterSelfComponent extends Box {

    private JFrame frame;
    private JLabel l_name, l_id, l_dormitoryId, l_phoneNumber, l_sex;
    private JLabel lname, lid , ldormitoryId, phoneNumber, lsex;

    //手工添加
    public HouseMasterSelfComponent(JFrame frame, String username) throws ClassNotFoundException, SQLException {
        super(BoxLayout.X_AXIS);
        init(username);
    }
    
    public void init(String username) throws ClassNotFoundException, SQLException {

    	//this.setLayout(null);
        
    	HouseMaster hm = new HouseMaster();
    	hm = HouseMasterManager_HouseMasterSelf_Controller.searchHouseMasterSelf(username);
    	
    	JLabel l_name = new JLabel("姓名");
    	JLabel l_id = new JLabel("工号");
    	JLabel l_dormitoryId = new JLabel("管理宿舍楼号");
    	JLabel l_phoneNumber = new JLabel("联系电话");
    	JLabel l_sex = new JLabel("性别");
    	
    	JLabel lname = new JLabel(hm.getName());
    	JLabel lid = new JLabel(hm.getId());
    	JLabel ldormitoryId = new JLabel(hm.getDormitoryId());
    	JLabel lphoneNumber = new JLabel(hm.getPhoneNumber());
       	JLabel lsex = new JLabel(String.valueOf(hm.getSex()));
       	
       	Font font = new Font("宋体",Font.PLAIN,30);
       	
       	l_name.setFont(font);
       	l_id.setFont(font);
       	l_dormitoryId.setFont(font);
       	l_phoneNumber.setFont(font);
       	l_sex.setFont(font);
       	
       	lname.setFont(font);
       	lid.setFont(font);
       	ldormitoryId.setFont(font);
       	lphoneNumber.setFont(font);
       	lsex.setFont(font);
       	
       	
       	this.add(l_id);
       	this.add(lid);
       	
       	this.add(l_name);
       	this.add(lname);
       	
       	this.add(l_sex);
       	this.add(lsex);
       	
       	this.add(l_dormitoryId);
       	this.add(ldormitoryId);
       	
       	this.add(l_phoneNumber);
       	this.add(lphoneNumber);
    }   
}
