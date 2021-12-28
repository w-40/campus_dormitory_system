package nuc.ss.dialog;
/**
 * @author 娄靖彬，王志凯
 * @description 添加访客信息
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import nuc.ss.controller.SystemController_VisitorManage_Controller;
import nuc.ss.domain.Visitor;

public class AddVisitorJDialog extends JDialog{
	
	private JLabel l_tel, l_name, l_identity, l_visitMatters,l_time;
    private JTextField t_tel, t_name,t_identity, t_visitMatters, t_time;
    private JButton b_add,b_reset;
	Frame frame;

    
    public AddVisitorJDialog(Frame frame, String title, boolean modal) {
		//super(frame, title, modal);
		this.setTitle("添加访客信息");
		this.setSize(350, 450);
		this.setLocation(300,200);
		this.setLocationRelativeTo(null);
		init();
		this.setVisible(true);
	}
    
    
    
    public void init() {
    	this.setLayout(new GridLayout(6,2,5,5));
    	
    	l_tel = new JLabel("联系方式",JLabel.CENTER);
    	l_name = new JLabel("姓名",JLabel.CENTER);
    	l_visitMatters = new JLabel("来访事宜",JLabel.CENTER);
    	l_identity = new JLabel("身份",JLabel.CENTER);
    	l_time  = new JLabel("来访时间",JLabel.CENTER);
    	
    	
    	t_tel = new JTextField();
    	t_name = new JTextField();
    	t_visitMatters = new JTextField();
    	t_identity = new JTextField();
    	t_time = new JTextField();



    	
    	b_add = new JButton("添加");
    	b_add.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
				boolean flag = addVisitor();
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
				t_tel.setText("");
				t_name.setText("");
		    	t_visitMatters.setText("");
		    	t_identity.setText("");
		    	t_time.setText("");
			}
    		
    	});
    	this.add(l_name);
    	this.add(t_name);
    	
    	this.add(l_tel);
    	this.add(t_tel);
    	
     	this.add(l_time);
    	this.add(t_time);
    
    	
    	this.add(l_visitMatters);
    	this.add(t_visitMatters);
    	
    	
    	this.add(l_identity);
    	this.add(t_identity);
    	
    	
    	this.add(b_add);
    	this.add(b_reset);

    }
    public boolean addVisitor() {
		String name = t_name.getText();
		String tel = t_tel.getText();
		String time = t_time.getText();
		String visitMatters = t_visitMatters.getText();
		String identity = t_identity.getText();

		Visitor visitor = new Visitor(name,tel,time, visitMatters, identity);
		try {
			SystemController_VisitorManage_Controller.addVisitor(visitor);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return true;
	}
}
