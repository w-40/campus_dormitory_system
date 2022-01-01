package nuc.ss.dialog;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import nuc.ss.controller.SystemController_Student_Controller;

public class UpdateStudentNumberJDialog extends JDialog {
	private JLabel l_Num1, l_Num2;
	private JTextField t_Num1, t_Num2;
	private JButton b_update,b_reset;
    
	public UpdateStudentNumberJDialog(ActionListener actionListener, String title, boolean modal,String username) {
		//super(frame, title, modal);
		this.setTitle("修改联系方式");
		this.setSize(250, 150);
		this.setLocationRelativeTo(null);
		init(username);
		this.setVisible(true);
	}
    
    
    
    public void init(String username) {
    	this.setLayout(new GridLayout(3,2,5,5));
    	
    	l_Num1 = new JLabel("联系方式", JLabel.CENTER);
    	l_Num2 = new JLabel("请再次输入", JLabel.CENTER);
        
        t_Num1 = new JTextField();
        t_Num2 = new JTextField();
    	
    	b_update = new JButton("修改");
    	b_update.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			String num = new String(t_Num1.getText());
                String num1 = new String(t_Num2.getText());
                if (!num.equals(num1)) {
                    showMessage();
                    t_Num1.setText("");
                    t_Num2.setText("");
                    return;
                } else {

                }
                try {
					SystemController_Student_Controller.updateNum(username, num);
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
				t_Num1.setText("");
				t_Num2.setText("");
				
			}
    		
    	});
    	
    	
    	this.add(l_Num1);
    	this.add(t_Num1);
    	
    	this.add(l_Num2);
    	this.add(t_Num2);
    	
    	this.add(b_update);
    	this.add(b_reset);

    }
    public void showMessage() {
        JOptionPane.showMessageDialog(this,"两次输入不一致，请重新输入",
                "提示",JOptionPane.WARNING_MESSAGE);
    }
    
    public void showMessage2() {
        JOptionPane.showMessageDialog(this,"修改成功",
                "提示",JOptionPane.CANCEL_OPTION);
    }

}
