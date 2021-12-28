package nuc.ss.dialog;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import nuc.ss.controller.SystemController_HouseMasterManage_Controller;
import nuc.ss.controller.SystemController_Student_Controller;
import nuc.ss.dao.SystemController_Student_JDBC;
import nuc.ss.domain.HouseMaster;

public class UpdateStudentPasswordJDialog extends JDialog {
	private JLabel l_password1, l_password2;
	private JPasswordField p_password1, p_password2;
	private JButton b_update,b_reset;
    
	public UpdateStudentPasswordJDialog(ActionListener actionListener, String title, boolean modal,String username) {
		//super(frame, title, modal);
		this.setTitle("修改密码");
		this.setSize(250, 150);
		this.setLocation(300,200);
		init(username);
		this.setVisible(true);
	}
    
    
    
    public void init(String username) {
    	this.setLayout(new GridLayout(3,2,5,5));
    	
    	l_password1 = new JLabel("密码", JLabel.CENTER);
        l_password2 = new JLabel("再次确认密码", JLabel.CENTER);
        
        p_password1 = new JPasswordField();
        p_password2 = new JPasswordField();
    	
    	
    	b_update = new JButton("修改");
    	b_update.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			String password = new String(p_password1.getPassword());
                String password1 = new String(p_password2.getPassword());
                if (!password.equals(password1)) {
                    showMessage();
                    p_password1.setText("");
                    p_password2.setText("");
                    return;
                } else {

                }
                try {
					SystemController_Student_Controller.updatePassword(username, password);
					showMessage2();
					dispose();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
              
    		}
    		
        });                              
    	
    	b_reset = new JButton("重置");
    	b_reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				p_password1.setText("");
				p_password2.setText("");
				
			}
    		
    	});
    	
    	
    	this.add(l_password1);
    	this.add(p_password1);
    	
    	this.add(l_password2);
    	this.add(p_password2);
    	
    	this.add(b_update);
    	this.add(b_reset);

    }
    public void showMessage() {
        JOptionPane.showMessageDialog(this,"两次密码输入不一致，请重新输入",
                "提示",JOptionPane.WARNING_MESSAGE);
    }
    
    public void showMessage2() {
        JOptionPane.showMessageDialog(this,"修改成功",
                "提示",JOptionPane.CANCEL_OPTION);
    }

}
