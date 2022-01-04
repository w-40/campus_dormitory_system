package nuc.ss.view;
/**
 * @author 段福泉，籍乃博
 * @description 展示学生登录后，与自己有关的所有信息
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
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
	    	this.setSize(1600, 915);
			this.setLocationRelativeTo(null);
	    	init(username);
	    	this.setVisible(true);
	    }
	    
	    public void init(String username) throws ClassNotFoundException, SQLException {
	    	
	    	this.setLayout(new GridLayout(1, 1));
	    	
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
	    	
	    	Font font = new Font("宋体",Font.PLAIN,30);
	    	l_id.setFont(font);
	    	l_name.setFont(font);
	    	l_sex.setFont(font);
	    	l_grade.setFont(font);
	    	l_dormitoryBudingId.setFont(font);
	    	l_dormitoryId.setFont(font);
	    	l_bed.setFont(font);
	    	l_phoneNumber.setFont(font);
	    	t_id.setFont(font);
	    	t_name.setFont(font);
	    	t_sex.setFont(font);
	    	t_grade.setFont(font);
	    	t_dormitoryId.setFont(font);
	    	t_dormitoryBudingId.setFont(font);
	    	t_bed.setFont(font);
	    	t_phoneNumber.setFont(font);
	    	
	    	Box b_info1 = Box.createVerticalBox();
	    	Box b_table = Box.createVerticalBox();
	    	Box b_bigBox = Box.createHorizontalBox();
	    	
	    	JPanel p1 = new JPanel();
	    	p1.add(l_id);
	    	p1.add(t_id);
	    	p1.setBackground(Color.white);
	    	
	    	JPanel p2 = new JPanel();
	    	p2.add(l_name);
	    	p2.add(t_name);
	    	p2.setBackground(Color.white);
	    	
	    	JPanel p3 = new JPanel();
	    	p3.add(l_sex);
	    	p3.add(t_sex);
	    	p3.setBackground(Color.white);
	    	
	    	JPanel p4 = new JPanel();
	    	p4.add(l_grade);
	    	p4.add(t_grade);
	    	p4.setBackground(Color.white);
	    	
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
	    	
	    	
            b_info1.add(p1);
            b_info1.add(p2);
            b_info1.add(p3);
            b_info1.add(p4);
            b_info1.add(p5);
            b_info1.add(p6);
            b_info1.add(p7);
            b_info1.add(p8);
            
            b_bigBox.add(b_info1);
            b_bigBox.add(Box.createHorizontalStrut(20));
            

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
	    	
	    	DefaultTableModel defaultTableModel = new DefaultTableModel(rowData, columnNames);
	    	
	    	JTable table = new JTable(defaultTableModel);
	    	JTableHeader head = table.getTableHeader();
	    	head.setFont(font);
            table.setRowHeight(100);
            table.setFont(font);
	    	table.setFillsViewportHeight(true);
	    	
	        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
	        tcr.setHorizontalAlignment(JLabel.CENTER);
	        table.setDefaultRenderer(Object.class, tcr);
	    	
	    	JScrollPane jsp = new JScrollPane(table);
	    	
	    	b_table.add(jsp);
	    	b_table.add(Box.createVerticalStrut(20));
	    	l_message = new JLabel("如有需要，请在下方留言");
	    	t_message = new JTextField();
	    	
	    	l_message.setFont(font);
	    	t_message.setFont(font);
	    	
	    	add = new JButton("提交");
	    	add.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                addMessage();
	                JOptionPane.showMessageDialog(add,"提交成功");
	                dispose();
	            }
	        }); 
	    	
	    	add.setFont(font);
	    	
	    	JPanel p9 = new JPanel();
	    	p9.add(l_message);
	    	p9.setBackground(Color.white);
	    	b_table.add(p9);
	    	
	    	t_message.setBackground(Color.white);
	    	t_message.setPreferredSize(new Dimension (100,30));
	    	b_table.add(t_message);
	    	
	    	
	    	JPanel p11 = new JPanel();
	    	p11.add(add);
	    	p11.setBackground(Color.white);
	    	
	    	b_table.add(p11);
	    	
	    	b_bigBox.add(b_table);
	    	b_bigBox.setLocation(0, 0);
	    	
	    	this.add(b_bigBox);
	    	
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