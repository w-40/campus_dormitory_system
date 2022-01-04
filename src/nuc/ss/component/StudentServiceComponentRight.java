package nuc.ss.component;
/**
 * @author 王志凯，籍乃博
 * @description 学生服务管理
 */

import nuc.ss.controller.SystemController_StudentManage_Controller;
import nuc.ss.controller.SystemController_StudentServiceManage_Controller;
import nuc.ss.dao.SystemController_StudentManage_JDBC;
import nuc.ss.dialog.AddStudentJDialog;
import nuc.ss.dialog.AllocateDormitoryJDialog;
import nuc.ss.domain.Student;
import nuc.ss.informationtable.StudentTable;
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

import static nuc.ss.informationtable.StudentTable.studentModel;

public class StudentServiceComponentRight extends Box {

    public StudentServiceComponentRight(JFrame frame) {
        super(BoxLayout.X_AXIS);
        init();
    }

    private JFrame frame;
    public static JPanel tablepanel = new JPanel();//创建一个JPanel,放置显示数据的表格
    public static JScrollPane tablePane = null;

    //手工添加
    private StudentTable studentTable;
    private ArrayList<String> tableHeadList;
    private Vector<Vector<String>> studentData = new Vector<Vector<String>>();


    public void init() {
        JSplitPane jsp = new JSplitPane();
        jsp.setEnabled(false);
        //支持连续布局
        jsp.setContinuousLayout(true);

        tableHeadList = new ArrayList<String>();
        tableHeadList.add("学号");
        tableHeadList.add("性别");
        tableHeadList.add("宿舍楼号");
        tableHeadList.add("宿舍号");
        tableHeadList.add("床位");

        Vector<String> titles = new Vector<>(tableHeadList);//创建存放表头的Vector


        studentModel = new DefaultTableModel(studentData, titles);
        studentTable = new StudentTable(studentModel);
        studentTable.setFont(new Font("微软雅黑", Font.BOLD, 20));

        studentTable.setPreferredScrollableViewportSize(new Dimension(600, 800));//设置表格大小
        studentTable.setRowHeight(35);

        studentTable.getTableHeader().setBackground(new Color(150, 150, 231));//设置表头颜色
        studentTable.getTableHeader().setPreferredSize(new Dimension(35, 50));//设置表头大小
        studentTable.getTableHeader().setFont(new Font("宋体", Font.BOLD, 25));

        studentTable.setSelectionBackground(new Color(216, 133, 222));//设置单元格选中的背景色
        studentTable.setBackground(new Color(214, 203, 238, 255));

        studentTable.getColumnModel().getColumn(0).setPreferredWidth(700);//设置列的宽度
        studentTable.getColumnModel().getColumn(1).setPreferredWidth(400);
        studentTable.getColumnModel().getColumn(2).setPreferredWidth(500);
        studentTable.getColumnModel().getColumn(3).setPreferredWidth(500);
        studentTable.getColumnModel().getColumn(4).setPreferredWidth(500);
        //表格内容居中
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(JLabel.CENTER);
        studentTable.setDefaultRenderer(Object.class, tcr);

        //表头内容居中
        DefaultTableCellHeaderRenderer thr = new DefaultTableCellHeaderRenderer();
        thr.setHorizontalAlignment(JLabel.CENTER);
        studentTable.getTableHeader().setDefaultRenderer(thr);

        JPanel btnPanel = new JPanel();

        JButton b1 = new JButton("查询未分配宿舍学生");
        b1.setFont(new Font("宋体", Font.BOLD, 25));


        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getNotHaveDormStudentInfo();
            }
        });

        JButton b2 = new JButton("分配宿舍");
        b2.setFont(new Font("宋体", Font.BOLD, 25));


        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int row = studentTable.getSelectedRow();
                    //int col = studentTable.getSelectedColumn();
                    String col = studentData.get(row).get(0);
                    String id = col;
                    new AllocateDormitoryJDialog(this, true, id).setVisible(true);
                } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                    JOptionPane.showMessageDialog(frame, "请选中一个条目");
                }
            }
        });
        JButton b3 = new JButton("刷新");
        b3.setFont(new Font("宋体", Font.BOLD, 25));

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getNotHaveDormStudentInfo();
            }
        });

        btnPanel.add(b1);
        btnPanel.add(b2);
        btnPanel.add(b3);

        jsp.setDividerLocation(900);
        studentTable.setBounds(350, 70, 625, 775);

        tablepanel.add(studentTable.getTableHeader());
        tablePane = new JScrollPane(studentTable);
        tablePane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        tablepanel.add(tablePane);//设置tablePane的大小

        tablepanel.setBackground(new Color(135, 206, 235));

        Box vBox = Box.createVerticalBox();
        vBox.add(btnPanel);
        vBox.add(tablepanel);

        jsp.setLeftComponent(vBox);
        btnPanel.setBackground(new Color(135, 206, 235));
        tablepanel.setBackground(new Color(135, 206, 235));
        this.add(jsp);
        this.validate();
        this.repaint();
    }


    private void getNotHaveDormStudentInfo() {//获取数据
        try {
            studentData.clear();
            ArrayList<Student> students = SystemController_StudentServiceManage_Controller.searchNotHaveDormStudent();
            for (int i = 0; i < students.size(); i++) {
                Vector<String> record = new Vector<String>();
                for (int j = 0; j < 9; j++) {
                    record.add(students.get(i).getId());
                    record.add(students.get(i).getSex() + "");
                    record.add(students.get(i).getDormitoryId());
                    record.add(students.get(i).getApartmentId());
                    record.add(students.get(i).getBed() + " ");
                }
                studentData.add(record);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
        studentTable.validate();
        studentTable.updateUI();
    }
}