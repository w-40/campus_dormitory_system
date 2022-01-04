package nuc.ss.dialog;
import java.awt.Font;
/**
 * @author 段福泉
 */
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import nuc.ss.controller.AllocateDormitory_Controller;

public class AllocateDormitoryJDialog extends JDialog {
	
	private JLabel l_1, l_2,l_3;
	private JTextField t_Num1, t_Num2,t_Num3;
	private JButton b_update,b_reset;
    
	public AllocateDormitoryJDialog(ActionListener actionListener, boolean modal,String username) {
		//super(frame, title, modal);
		this.setTitle("正在分配" + username + "的宿舍");
		this.setSize(350, 251);
		this.setLocationRelativeTo(null);
		init(username);
		this.setVisible(true);
	}
    
    
    
    public void init(String username) {
    	this.setLayout(new GridLayout(4,2,5,5));
    	
    	l_1 = new JLabel("宿舍楼号", JLabel.CENTER);
    	l_2 = new JLabel("宿舍号", JLabel.CENTER);
    	l_3 = new JLabel("床位号", JLabel.CENTER);
        
        t_Num1 = new JTextField();
        t_Num2 = new JTextField();
        t_Num3 = new JTextField();
    	
        Font font = new Font("TimesNewRoman", Font.BOLD, 20);
        
        l_1.setFont(font);
        l_2.setFont(font);
        l_3.setFont(font);
        
        t_Num1.setFont(font);
        t_Num2.setFont(font);
        t_Num3.setFont(font);
        
    	b_update = new JButton("分配");
    	b_update.setFont(font);
    	b_update.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			String l_1 = new String(t_Num1.getText());
                String l_2 = new String(t_Num2.getText());
                String l_3 = new String(t_Num3.getText());
                boolean f = true;
                try {
                	f = AllocateDormitory_Controller.searchDormitory(l_1, l_2, l_3);
                	if(f) {
                		
        				t_Num3.setText("");
        				showMessage();
                		
                	} else {
                		AllocateDormitory_Controller.allocateDormitory(username, l_1, l_2, l_3);
                		AllocateDormitory_Controller.updateDormitory(l_1, l_2);
					    showMessage2();
					    dispose();
                	}
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
                
              
    		}
    		
        });                              
    	
    	b_reset = new JButton("重置");
    	b_reset.setFont(font);
    	b_reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				t_Num1.setText("");
				t_Num2.setText("");
				t_Num3.setText("");
				
				
			}
    		
    	});
    	
    	
    	this.add(l_1);
    	this.add(t_Num1);
    	
    	this.add(l_2);
    	this.add(t_Num2);
    	
    	this.add(l_3);
    	this.add(t_Num3);
    	
    	this.add(b_update);
    	this.add(b_reset);

    }
    public void showMessage() {
        JOptionPane.showMessageDialog(this,"该床位已经有人，请重新分配",
                "提示",JOptionPane.WARNING_MESSAGE);
    }
    
    public void showMessage2() {
        JOptionPane.showMessageDialog(this,"分配成功",
                "提示",JOptionPane.CANCEL_OPTION);
    }

}
	


