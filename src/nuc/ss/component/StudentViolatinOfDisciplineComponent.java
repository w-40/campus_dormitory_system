package nuc.ss.component;
/**
 * @author 王志凯
 * @description 学生违纪管理页面
 */
import nuc.ss.controller.HouseMasterManager_StudentViolatinOfDiscipline_Controller;
import nuc.ss.controller.SystemController_HouseMasterManage_Controller;
import nuc.ss.domain.StudentViolationOfDiscipline;
import nuc.ss.dialog.AddDisciplinaryInformationDialog;
import nuc.ss.informationtable.StudentViolatinOfDisciplineTable;
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

import static nuc.ss.informationtable.StudentViolatinOfDisciplineTable.studentViolatinOfDisciplineModel;


public class StudentViolatinOfDisciplineComponent extends Box {
    private JFrame frame;
    public static JPanel tablepanel = new JPanel();//创建一个JPanel,放置显示数据的表格
    public static JScrollPane tablePane = null;

    //手工添加
    private StudentViolatinOfDisciplineTable studentViolatinOfDisciplineTable;
    private ArrayList<String> tableHeadList;
    private Vector<Vector<String>> studentViolatinOfDisciplineData = new Vector<Vector<String>>();

    public StudentViolatinOfDisciplineComponent(JFrame frame,String username) {
        super(BoxLayout.X_AXIS);
        init(username);
    }

    private void getDisciplinaryInfo(String username) {//获取数据
        try {
            studentViolatinOfDisciplineData.clear();
            ArrayList<StudentViolationOfDiscipline> svodlist = HouseMasterManager_StudentViolatinOfDiscipline_Controller.searchStudentViolatinOfDiscipline(username);
            for (int i = 0; i < svodlist.size(); i++) {
                Vector<String> record = new Vector<String>();
                for (int j = 0; j < 6; j++) {
                    record.add(svodlist.get(i).getId());
                    record.add(svodlist.get(i).getName());
                    record.add(svodlist.get(i).getDormId() + "");
                    record.add(svodlist.get(i).getContent());
                    record.add(svodlist.get(i).getTime());
                }
                studentViolatinOfDisciplineData.add(record);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
        studentViolatinOfDisciplineTable.validate();
        studentViolatinOfDisciplineTable.updateUI();
    }

    public void init(String username) {
        JSplitPane jsp = new JSplitPane();
        jsp.setEnabled(false);
        //支持连续布局
        jsp.setContinuousLayout(true);
        jsp.setDividerLocation(900);
        jsp.setDividerSize(0);

        tableHeadList = new ArrayList<String>();
        tableHeadList.add("学号");
        tableHeadList.add("姓名");
        tableHeadList.add("宿舍号");
        tableHeadList.add("违纪内容");
        tableHeadList.add("违纪时间");

        Vector<String> titles = new Vector<>(tableHeadList);//创建存放表头的Vector

        //adminTable = new AdminTable(tableData, titles);//初始化整个数据表格
        studentViolatinOfDisciplineModel = new DefaultTableModel(studentViolatinOfDisciplineData, titles);
        studentViolatinOfDisciplineTable = new StudentViolatinOfDisciplineTable(studentViolatinOfDisciplineModel);
        studentViolatinOfDisciplineTable.setFont(new Font("微软雅黑", Font.BOLD, 20));

        studentViolatinOfDisciplineTable.setPreferredScrollableViewportSize(new Dimension(900, 800));//设置表格大小
        studentViolatinOfDisciplineTable.setRowHeight(35);

        studentViolatinOfDisciplineTable.getTableHeader().setBackground(new Color(255, 0, 0));//设置表头颜色
        studentViolatinOfDisciplineTable.getTableHeader().setPreferredSize(new Dimension(35, 50));//设置表头大小
        studentViolatinOfDisciplineTable.getTableHeader().setFont(new Font("宋体", Font.BOLD, 25));

        studentViolatinOfDisciplineTable.setSelectionBackground(new Color(216, 133, 222));//设置单元格选中的背景色
        studentViolatinOfDisciplineTable.setBackground(new Color(214, 203, 238, 255));

        studentViolatinOfDisciplineTable.getColumnModel().getColumn(0).setPreferredWidth(500);//设置列的宽度
        studentViolatinOfDisciplineTable.getColumnModel().getColumn(1).setPreferredWidth(500);
        studentViolatinOfDisciplineTable.getColumnModel().getColumn(2).setPreferredWidth(500);
        studentViolatinOfDisciplineTable.getColumnModel().getColumn(3).setPreferredWidth(500);
        studentViolatinOfDisciplineTable.getColumnModel().getColumn(4).setPreferredWidth(700);
        //表格内容居中
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(JLabel.CENTER);
        studentViolatinOfDisciplineTable.setDefaultRenderer(Object.class, tcr);

        //表头内容居中
        DefaultTableCellHeaderRenderer thr = new DefaultTableCellHeaderRenderer();
        thr.setHorizontalAlignment(JLabel.CENTER);
        studentViolatinOfDisciplineTable.getTableHeader().setDefaultRenderer(thr);

        JPanel btnPanel = new JPanel();


        JButton b1 = new JButton("查询");
        b1.setFont(new Font("宋体", Font.BOLD, 25));

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getDisciplinaryInfo(username);
            }
        });

        JButton b2 = new JButton("添加");
        b2.setFont(new Font("宋体", Font.BOLD, 25));

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDisciplinaryInformationDialog(frame, "添加违纪信息", true,username).setVisible(true);
            }
        });


//        JButton b3 = new JButton("修改");
//        b3.setFont(new Font("宋体", Font.BOLD, 25));
//
//        b3.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                int row = studentViolatinOfDisciplineTable.getSelectedRow();//获取选中的行
//                int column = 0;
//                String val = "";
//                try {
//                    column = studentViolatinOfDisciplineTable.getSelectedColumn();//获取选中的列
//                    val = studentViolatinOfDisciplineData.get(row).get(column);//被选中的列的值
//                } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
//                    JOptionPane.showMessageDialog(frame, "请选中一个条目");
//                }
//                boolean flag = false;
//                try {
//                    String tid = studentViolatinOfDisciplineData.get(row).get(0);//取得tid
//                    flag = HouseMasterManager_StudentViolatinOfDiscipline_Controller.updateStudentViolatinOfDiscipline(val, tid, tableHeadList, column);
//                } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
//
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                } catch (ClassNotFoundException classNotFoundException) {
//                    classNotFoundException.printStackTrace();
//                }
//                if (flag) {
//                    JOptionPane.showMessageDialog(frame, "修改成功");
//                }
//            }
//        });


        JButton b4 = new JButton("删除");
        b4.setFont(new Font("宋体", Font.BOLD, 25));

        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = studentViolatinOfDisciplineTable.getSelectedRow();//获取被选中的行
                String tid;
                String time;
                boolean flag = false;
                try {
                    tid = studentViolatinOfDisciplineData.get(row).get(0);//获得第1列，也就是tid，按tid执行删除
                    time = studentViolatinOfDisciplineData.get(row).get(4);
                    flag = HouseMasterManager_StudentViolatinOfDiscipline_Controller.deleteStudentViolatinOfDiscipline(tid,time);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                    JOptionPane.showMessageDialog(frame, "请选择一个项目");
                }

                try {
                    studentViolatinOfDisciplineData.remove(row);//从表格中移出一行
                } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {

                }
                if (flag) {
                    JOptionPane.showMessageDialog(frame, "删除成功");
                } else {
                    JOptionPane.showMessageDialog(frame, "删除失败");
                }

                //更新整个表格数据，删掉的那条记录将不再显示
                studentViolatinOfDisciplineTable.validate();
                studentViolatinOfDisciplineTable.updateUI();
            }
        });


        Box vBox = Box.createVerticalBox();
        vBox.add(Box.createVerticalStrut(80));
        vBox.add(b1);
        vBox.add(Box.createVerticalStrut(80));
        vBox.add(b2);
        vBox.add(Box.createVerticalStrut(80));
//        vBox.add(b3);
//        vBox.add(Box.createVerticalStrut(80));
        vBox.add(b4);
        btnPanel.add(vBox);

        jsp.setDividerLocation(900);
        studentViolatinOfDisciplineTable.setBounds(350, 70, 900, 775);


        tablepanel.add(studentViolatinOfDisciplineTable.getTableHeader());//将表头放到Jpanel里
        tablePane = new JScrollPane(studentViolatinOfDisciplineTable);
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
}
