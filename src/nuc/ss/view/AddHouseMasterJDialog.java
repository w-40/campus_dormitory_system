package nuc.ss.view;
/**
 * @author 段福泉，王志凯
 * @description 添加宿舍管理员对话框
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;

import nuc.ss.controller.SystemController_HouseMasterManage_Controller;
import nuc.ss.domain.HouseMaster;

import static nuc.ss.view.AdminTable.*;

public class AddHouseMasterJDialog extends JDialog{
	
	private JLabel l_id, l_name, l_password, l_sex,l_dormitoryId,l_phoneNumber;
    private JTextField t_id, t_name,t_password, t_dormitoryId, t_phoneNumber;
    private JRadioButton r_male, r_female;
    private JButton b_add,b_reset;
	Frame frame;

    
    public AddHouseMasterJDialog(Frame frame, String title, boolean modal) {
		//super(frame, title, modal);
		this.setTitle("添加宿管信息");
		this.setSize(350, 450);
		this.setLocation(300,200);
		this.setLocationRelativeTo(null);
		init();
		this.setVisible(true);
	}
    
    
    
    public void init() {
    	this.setLayout(new GridLayout(7,2,5,5));
    	
    	l_id = new JLabel("工号",JLabel.CENTER);
    	l_name = new JLabel("姓名",JLabel.CENTER);
    	l_password = new JLabel("密码",JLabel.CENTER);
    	l_sex = new JLabel("性别",JLabel.CENTER);
    	l_dormitoryId  = new JLabel("管理宿舍楼号",JLabel.CENTER);
    	l_phoneNumber = new JLabel("联系电话",JLabel.CENTER);
    	
    	t_id = new JTextField();
    	t_name = new JTextField();
    	t_password = new JTextField();
    	t_dormitoryId = new JTextField();
    	t_phoneNumber = new JTextField();
    	
    	
    	
    	ButtonGroup bg = new ButtonGroup();
    	r_male = new JRadioButton("男");
    	r_female = new JRadioButton("女");
    	bg.add(r_male);
    	bg.add(r_female);
    	JPanel p = new JPanel();
    	p.add(r_male);
    	p.add(r_female);
    	
    	
    	b_add = new JButton("添加");
    	b_add.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
				boolean flag = addHouseMaster();
				if (flag == true){
					JOptionPane.showMessageDialog(frame,"添加成功，请点击查询按钮刷新表格");
					dispose();

				}else {
					JOptionPane.showMessageDialog(frame,"添加失败");
				}
    		}
    		
        });                              
    	
    	b_reset = new JButton("重置");
    	b_reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				t_id.setText("");
				t_name.setText("");
		    	t_password.setText("");
		    	t_dormitoryId.setText("");
		    	t_phoneNumber.setText("");
				
			}
    		
    	});
    	
    	this.add(l_id);
    	this.add(t_id);
    	
    	this.add(l_name);
    	this.add(t_name);
    	
    	this.add(l_password);
    	this.add(t_password);
    	
    	
    	this.add(l_sex);
    	this.add(p);
    	
    	this.add(l_dormitoryId);
    	this.add(t_dormitoryId);
    	
    	this.add(l_phoneNumber);
    	this.add(t_phoneNumber);
    	
    	this.add(b_add);
    	this.add(b_reset);

    }
    public boolean addHouseMaster() {
    	String id = t_id.getText();
		String name = t_name.getText();
		String password = t_password.getText();
		String dormitoryId = t_dormitoryId.getText();
		String phoneNumber = t_phoneNumber.getText();
		char sex;
		if(r_male.isSelected()) {
			sex = '男';
		} else {
			sex = '女';
		}
		HouseMaster houseMaster = new HouseMaster(id, password, name, sex, dormitoryId, phoneNumber);
		try {
			SystemController_HouseMasterManage_Controller.addHouseMaster(houseMaster);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return true;
	}
}
