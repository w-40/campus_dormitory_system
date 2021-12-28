package nuc.ss.view;
/**
 * @author 段福泉，籍乃博
 * @description 展示学生登录后，与自己有关的所有信息
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.TableColumn;

import nuc.ss.controller.SystemController_Student_Controller;
import nuc.ss.dao.SystemController_Student_JDBC;
import nuc.ss.dialog.UpdateStudentNumberJDialog;
import nuc.ss.dialog.UpdateStudentPasswordJDialog;
import nuc.ss.domain.Student;
import nuc.ss.domain.StudentViolationOfDiscipline;

public class StudentLoginFrame extends JFrame{
	 private JLabel l_id, l_name, l_sex, l_grade, l_dormitoryBudingId,l_dormitoryId, l_bed, l_phoneNumber,t_id, t_name, t_sex, t_grade, t_dormitoryBudingId,t_dormitoryId, t_bed, t_phoneNumber;
	 private JLabel l_message;
	 private JTextField t_message;
	 private JButton add;
	 public static JPanel t = new JPanel();
	 

	    
	    public StudentLoginFrame(String name,String username) throws ClassNotFoundException, SQLException,NullPointerException {
	    	this.setTitle(name +  "的个人信息界面");
	    	this.setSize(600, 500);
	    	init(username);
	    	this.setLocation(350, 100);
	    	this.setVisible(true);
	    }
	    
	    public void init(String username) throws ClassNotFoundException, SQLException {
	    	
	    	this.setLayout(new GridLayout(6, 2));
	    	
	    	l_id = new JLabel("学号:");
	    	l_name = new JLabel("姓名:");
	    	l_sex = new JLabel("性别:");
	    	l_grade = new JLabel("年级:");
	    	l_dormitoryBudingId = new JLabel("宿舍楼号:");
	    	l_dormitoryId = new JLabel("宿舍号:");
	    	l_bed = new JLabel("床号:");
	    	l_phoneNumber = new JLabel("联系方式:");
	    	
	    	
	    	
	    	t_id = new JLabel(username);
	    	t_name = new JLabel(SystemController_Student_Controller.student(username).getName());
	    	t_sex = new JLabel(SystemController_Student_Controller.student(username).getSex() + "");
	    	t_grade = new JLabel(SystemController_Student_Controller.student(username).getGrade());
	    	t_dormitoryId = new JLabel(SystemController_Student_Controller.student(username).getDormitoryId());
	    	t_dormitoryBudingId = new JLabel(SystemController_Student_Controller.student(username).getApartmentId());
	    	t_bed = new JLabel(SystemController_Student_Controller.student(username).getBed() + "");
	    	t_phoneNumber = new JLabel(SystemController_Student_Controller.student(username).getPhoneNumber());
	    	
	    	
	    	JPanel p1 = new JPanel();
	    	p1.add(l_id);
	    	p1.add(t_id);
	    	p1.setBackground(Color.white);
	    	p1.setPreferredSize(new Dimension(2, 2));
	    	
	    	JPanel p2 = new JPanel();
	    	p2.add(l_name);
	    	p2.add(t_name);
	    	p2.setBackground(Color.white);
	    	p2.setPreferredSize(new Dimension(2, 2));
	    	
	    	JPanel p3 = new JPanel();
	    	p3.add(l_sex);
	    	p3.add(t_sex);
	    	p3.setBackground(Color.white);
	    	p3.setPreferredSize(new Dimension(2, 2));
	    	
	    	JPanel p4 = new JPanel();
	    	p4.add(l_grade);
	    	p4.add(t_grade);
	    	p4.setBackground(Color.white);
	    	p4.setPreferredSize(new Dimension(2, 2));
	    	
	    	JPanel p5 = new JPanel();
	    	p5.add(l_dormitoryBudingId);
	    	p5.add(t_dormitoryBudingId);
	    	p5.setBackground(Color.white);
	    	
	    	JPanel p6 = new JPanel();
	    	p6.add(l_dormitoryId);
	    	p6.add(t_dormitoryId);
	    	p6.setBackground(Color.white);
	    	
	    	JPanel p7 = new JPanel();
	    	p7.add(l_bed);
	    	p7.add(t_bed);
	    	p7.setBackground(Color.white);
	    	
	    	JPanel p8 = new JPanel();
	    	p8.add(l_phoneNumber);
	    	p8.add(t_phoneNumber);
	    	p8.setBackground(Color.white);
	    	
	    	
	    	
	    	this.add(p1);
	    	this.add(p2);
	    	
	    	this.add(p3);
	    	this.add(p4);
	    	
	    	this.add(p5);
	    	this.add(p6);
	    	
	    	this.add(p7);
	    	this.add(p8);
	    	
	    	
	    	
	    	Object[][] rowData = null;
	    	try {
	    		ArrayList<StudentViolationOfDiscipline> stlist = SystemController_Student_Controller.violation(username);
		    	rowData = new Object[stlist.size()][2];
		    	for (int i = 0;i<stlist.size(); i++) {
	                rowData[i][0] = stlist.get(i).getContent();
	                rowData[i][1] = stlist.get(i).getTime();
	                
		    	}
			} catch (SQLException e) {
				// TODO: handle exception
			}catch (NullPointerException c) {
				
			}
	    	Object[] columnNames = {"违纪内容", "违纪时间"};
	    	JTable table = new JTable(rowData, columnNames);
	    	table.setSize(200, 20);
	    	
	    	TableColumn column = table.getColumnModel().getColumn( 0 );
	    	column.setPreferredWidth( 100 );
	    	table.setRowHeight(20);
	    	
	    	
	    	
	    	t.add(table.getTableHeader(), BorderLayout.NORTH);
	    	t.add(table, BorderLayout.CENTER);
	    	t.add(table);
	    	t.setBackground(Color.white);
	    	t.setPreferredSize(new Dimension(200,100));
	    	this.add(t);
	    	
	    	l_message = new JLabel("如有需要，请在下方留言");
	    	t_message = new JTextField();
	    	
	    	add = new JButton("提交");
	    	add.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                addMessage();
	                JOptionPane.showMessageDialog(add,"提交成功");
	                dispose();
	            }
	        }); 
	    	
	    	JPanel p9 = new JPanel();
	    	p9.add(l_message);
	    	p9.setBackground(Color.white);
	    	this.add(p9);
	    	
	    	t_message.setBackground(Color.white);
	    	t_message.setPreferredSize(new Dimension (100,30));
	    	this.add(t_message);
	    	
	    	
	    	JPanel p11 = new JPanel();
	    	p11.add(add);
	    	p11.setBackground(Color.white);
	    	
	    	this.add(p11);
	    	
	    	JMenuBar menuBar = new JMenuBar();
	        menuBar.setBackground(Color.pink);
	        this.setJMenuBar(menuBar);

	        JMenu mnNewMenu = new JMenu("设置");
	        menuBar.add(mnNewMenu);
	        
	        JMenuItem mntmNewMenuItem2 = new JMenuItem("修改联系方式");
	        mntmNewMenuItem2.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	new UpdateStudentNumberJDialog(this, "修改联系电话", true, username).setVisible(true);
	            }
	        });
	        mnNewMenu.add(mntmNewMenuItem2);

	        JMenuItem mntmNewMenuItem = new JMenuItem("修改密码");
	        mntmNewMenuItem.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	new UpdateStudentPasswordJDialog(this, "修改密码", true,username).setVisible(true);
	            }
	        });
	        mnNewMenu.add(mntmNewMenuItem);

	        JMenuItem mntmNewMenuItem_1 = new JMenuItem("退出");
	        mntmNewMenuItem_1.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                dispose();
	            }
	        });
	        mnNewMenu.add(mntmNewMenuItem_1);
	    	
	    	
	    }     
	    public boolean addMessage() {
	    	String message = t_message.getText();
            String id = t_id.getText();
            Student st = new Student(id,message);
			try {
//				SystemController_Student_JDBC.addMessage(st);
				SystemController_Student_Controller.addMessage(st);
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return true;
		}
	    
	    
	        
}