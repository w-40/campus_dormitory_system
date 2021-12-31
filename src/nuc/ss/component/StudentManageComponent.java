package nuc.ss.component;
/**
 * @author 王志凯
 * @description 学生管理页面
 */

import nuc.ss.controller.SystemController_StudentManage_Controller;
import nuc.ss.dao.SystemController_StudentManage_JDBC;
import nuc.ss.domain.Student;

import nuc.ss.dialog.AddStudentJDialog;
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

public class StudentManageComponent extends Box {

    public StudentManageComponent(JFrame frame) {
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
        jsp.setDividerLocation(900);
        jsp.setDividerSize(0);

        tableHeadList = new ArrayList<String>();
        tableHeadList.add("年级");
        tableHeadList.add("学号");
        tableHeadList.add("姓名");
        tableHeadList.add("密码");
        tableHeadList.add("性别");
        tableHeadList.add("宿舍楼号");
        tableHeadList.add("宿舍号");
        tableHeadList.add("床位");
        tableHeadList.add("联系电话");

        Vector<String> titles = new Vector<>(tableHeadList);//创建存放表头的Vector


        //adminTable = new AdminTable(tableData, titles);//初始化整个数据表格
        studentModel = new DefaultTableModel(studentData, titles);
        studentTable = new StudentTable(studentModel);
        studentTable.setFont(new Font("微软雅黑", Font.BOLD, 20));

        studentTable.setPreferredScrollableViewportSize(new Dimension(900, 800));//设置表格大小
        studentTable.setRowHeight(35);

        studentTable.getTableHeader().setBackground(new Color(150, 150, 231));//设置表头颜色
        studentTable.getTableHeader().setPreferredSize(new Dimension(35, 50));//设置表头大小
        studentTable.getTableHeader().setFont(new Font("宋体", Font.BOLD, 25));

        studentTable.setSelectionBackground(new Color(216, 133, 222));//设置单元格选中的背景色
        studentTable.setBackground(new Color(214, 203, 238, 255));

        studentTable.getColumnModel().getColumn(0).setPreferredWidth(400);//设置列的宽度
        studentTable.getColumnModel().getColumn(1).setPreferredWidth(700);
        studentTable.getColumnModel().getColumn(2).setPreferredWidth(400);
        studentTable.getColumnModel().getColumn(3).setPreferredWidth(500);
        studentTable.getColumnModel().getColumn(4).setPreferredWidth(300);
        studentTable.getColumnModel().getColumn(5).setPreferredWidth(700);
        studentTable.getColumnModel().getColumn(6).setPreferredWidth(500);
        studentTable.getColumnModel().getColumn(7).setPreferredWidth(300);
        studentTable.getColumnModel().getColumn(8).setPreferredWidth(700);
        //表格内容居中
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(JLabel.CENTER);
        studentTable.setDefaultRenderer(Object.class, tcr);

        //表头内容居中
        DefaultTableCellHeaderRenderer thr = new DefaultTableCellHeaderRenderer();
        thr.setHorizontalAlignment(JLabel.CENTER);
        studentTable.getTableHeader().setDefaultRenderer(thr);

        JPanel btnPanel = new JPanel();

        JButton b1 = new JButton("查询");
        b1.setFont(new Font("宋体", Font.BOLD, 25));


        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getStudentInfo();
            }
        });

        JButton b2 = new JButton("添加");
        b2.setFont(new Font("宋体", Font.BOLD, 25));

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddStudentJDialog(frame, "添加学生", true).setVisible(true);
            }
        });


        JButton b3 = new JButton("修改");
        b3.setFont(new Font("宋体", Font.BOLD, 25));

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = studentTable.getSelectedRow();//获取选中的行
                int column = 0;
                String val = "";
                try {
                    column = studentTable.getSelectedColumn();//获取选中的列
                    val = studentData.get(row).get(column);//被选中的列的值

                    if (column == 5 || column == 6) {
                        JOptionPane.showMessageDialog(frame, "修改失败，修改宿舍信息请到学生服务管理中进行(点击查询进行刷新)");
                        return;
                    }

                } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                    JOptionPane.showMessageDialog(frame, "请选中一个条目");

                }
                boolean flag = false;
                try {
                    String tid = studentData.get(row).get(1);//取得tid
                    flag = SystemController_StudentManage_Controller.updateStudent(val, tid, tableHeadList, column);
                } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
                if (flag) {
                    JOptionPane.showMessageDialog(frame, "修改成功");
                }
            }
        });


        JButton b4 = new JButton("删除");
        b4.setFont(new Font("宋体", Font.BOLD, 25));

        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = studentTable.getSelectedRow();//获取被选中的行
                String tid = studentData.get(row).get(1);//获得第1列，也就是tid，按tid执行删除
                boolean flag = false;
                try {
                    flag = SystemController_StudentManage_Controller.deleteStudent(tid);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
                if (flag) {
                    JOptionPane.showMessageDialog(frame, "删除成功");
                } else {
                    JOptionPane.showMessageDialog(frame, "删除失败");
                }

                studentData.remove(row);//从表格中移出一行
                //更新整个表格数据，删掉的那条记录将不再显示
                studentTable.validate();
                studentTable.updateUI();
            }
        });
        JButton b5 = new JButton("重置密码");
        b5.setFont(new Font("宋体", Font.BOLD, 25));

        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = studentTable.getSelectedRow();//获取选中的行
                int column = 0;
                String val = "";
                try {
                    column = 3;//获取选中的列
                    val = "123456";//被选中的列的值
                } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                    JOptionPane.showMessageDialog(frame, "请选中一个条目");

                }
                boolean flag = false;
                try {
                    String tid = studentData.get(row).get(1);//取得tid
                    flag = SystemController_StudentManage_Controller.updateStudent(val, tid, tableHeadList, column);
                } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
                if (flag) {
                    JOptionPane.showMessageDialog(frame, "重置成功");
                }
            }
        });

        Box vBox = Box.createVerticalBox();
        vBox.add(Box.createVerticalStrut(80));
        vBox.add(b1);
        vBox.add(Box.createVerticalStrut(80));
        vBox.add(b2);
        vBox.add(Box.createVerticalStrut(80));
        vBox.add(b3);
        vBox.add(Box.createVerticalStrut(80));
        vBox.add(b4);
        vBox.add(Box.createVerticalStrut(80));
        vBox.add(b5);
        btnPanel.add(vBox);


        jsp.setDividerLocation(900);
        studentTable.setBounds(350, 70, 900, 775);

        tablepanel.add(studentTable.getTableHeader());
        tablePane = new JScrollPane(studentTable);
        tablePane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        tablepanel.add(tablePane);//设置tablePane的大小

        tablepanel.setBackground(new Color(135, 206, 235));

        jsp.setLeftComponent(tablepanel);
        jsp.setRightComponent(btnPanel);
        btnPanel.setBackground(new Color(135, 206, 235));
        tablepanel.setBackground(new Color(135, 206, 235));
        this.add(jsp);
        this.validate();
        this.repaint();
    }

    private void getStudentInfo() {//获取数据
        try {
            studentData.clear();
            ArrayList<Student> students = SystemController_StudentManage_Controller.searchStudent();
            for (int i = 0; i < students.size(); i++) {
                Vector<String> record = new Vector<String>();
                for (int j = 0; j < 9; j++) {
                    record.add(students.get(i).getGrade());
                    record.add(students.get(i).getId());
                    record.add(students.get(i).getName());
                    record.add(students.get(i).getPassword());
                    record.add(students.get(i).getSex() + "");
                    record.add(students.get(i).getDormitoryId());
                    record.add(students.get(i).getApartmentId());
                    record.add(students.get(i).getBed() + " ");
                    record.add(students.get(i).getPhoneNumber());
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




