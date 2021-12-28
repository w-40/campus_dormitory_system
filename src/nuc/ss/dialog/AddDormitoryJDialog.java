package nuc.ss.dialog;
/**
 * @author 卫黎明，王志凯
 * @description 添加宿舍楼对话框
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import nuc.ss.controller.SystemController_DormitoryManage_Controller;
import nuc.ss.domain.Dormitory;

public class AddDormitoryJDialog extends JDialog{
	
	private JLabel l_id, l_name;
    private JTextField t_id, t_name;
    private JButton b_add,b_reset;
	Frame frame;

    
    public AddDormitoryJDialog(Frame frame, String title, boolean modal) {
		//super(frame, title, modal);
		this.setTitle("添加宿舍楼信息");
		this.setSize(350, 450);
		this.setLocation(300,200);
		this.setLocationRelativeTo(null);
		init();
		this.setVisible(true);
	}
    
    
    
    public void init() {
    	this.setLayout(new GridLayout(7,2,5,5));
    	
    	l_id = new JLabel("宿舍楼号",JLabel.CENTER);
    	l_name = new JLabel("宿舍楼名称",JLabel.CENTER);
    	
    	t_id = new JTextField();
    	t_name = new JTextField();
    	
    	
    	
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

				
			}
    		
    	});
    	
    	this.add(l_id);
    	this.add(t_id);
    	
    	this.add(l_name);
    	this.add(t_name);
    	
    	this.add(b_add);
    	this.add(b_reset);

    }
    public boolean addHouseMaster() {
    	String id = t_id.getText();
		String name = t_name.getText();
		
		Dormitory dormitory = new Dormitory(id, name);
		try {
			SystemController_DormitoryManage_Controller.addDormitory(dormitory);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return true;
	}
}
