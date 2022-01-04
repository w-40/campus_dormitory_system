package nuc.ss.component;

import nuc.ss.controller.HouseMasterManager_StudentMessage_Controller;
/**
 * @author 王志凯, 卫黎明
 * @description 学生留言查看页面
 */
import nuc.ss.controller.SystemController_HouseMasterManage_Controller;
import nuc.ss.domain.Student;
import nuc.ss.informationtable.StudentMessageTable;
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

public class StudentMessageComponent extends Box {

    private JFrame frame;
    public static JPanel tablepanel = new JPanel();//创建一个JPanel,放置显示数据的表格
    public static JScrollPane tablePane = null;

    //手工添加
    private StudentMessageTable studentMessageTable;
    private ArrayList<String> tableHeadList;
    private Vector<Vector<String>> studentMessageData = new Vector<Vector<String>>();


    public StudentMessageComponent(JFrame frame) {
        super(BoxLayout.X_AXIS);
        init();
    }

    private void getMessageInfo() {//获取数据
        try {
            studentMessageData.clear();
            ArrayList<Student> stllist = HouseMasterManager_StudentMessage_Controller.searchStudentMessage();
            for (int i = 0; i < stllist.size(); i++) {
                Vector<String> record = new Vector<String>();
                for (int j = 0; j < 3; j++) {
                    record.add(stllist.get(i).getId());
                    record.add(stllist.get(i).getMessage());
                }
                studentMessageData.add(record);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
        studentMessageTable.validate();
        studentMessageTable.updateUI();
    }


    public void init() {

        JSplitPane jsp = new JSplitPane();
        jsp.setEnabled(false);
        //支持连续布局
        jsp.setContinuousLayout(true);
        jsp.setDividerLocation(900);
        jsp.setDividerSize(0);

        tableHeadList = new ArrayList<String>();
        tableHeadList.add("学号");
        tableHeadList.add("留言");

        Vector<String> titles = new Vector<>(tableHeadList);//创建存放表头的Vector


        //adminTable = new AdminTable(tableData, titles);//初始化整个数据表格
        studentViolatinOfDisciplineModel = new DefaultTableModel(studentMessageData, titles);
        studentMessageTable = new StudentMessageTable(studentViolatinOfDisciplineModel);
        studentMessageTable.setFont(new Font("微软雅黑", Font.BOLD, 20));

        studentMessageTable.setPreferredScrollableViewportSize(new Dimension(900, 800));//设置表格大小
        studentMessageTable.setRowHeight(35);

        studentMessageTable.getTableHeader().setBackground(new Color(255, 0, 0));//设置表头颜色
        studentMessageTable.getTableHeader().setPreferredSize(new Dimension(35, 50));//设置表头大小
        studentMessageTable.getTableHeader().setFont(new Font("宋体", Font.BOLD, 25));

        studentMessageTable.setSelectionBackground(new Color(216, 133, 222));//设置单元格选中的背景色
        studentMessageTable.setBackground(new Color(214, 203, 238, 255));

        studentMessageTable.getColumnModel().getColumn(0).setPreferredWidth(700);//设置列的宽度
        studentMessageTable.getColumnModel().getColumn(1).setPreferredWidth(700);
        //表格内容居中
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(JLabel.CENTER);
        studentMessageTable.setDefaultRenderer(Object.class, tcr);

        //表头内容居中
        DefaultTableCellHeaderRenderer thr = new DefaultTableCellHeaderRenderer();
        thr.setHorizontalAlignment(JLabel.CENTER);
        studentMessageTable.getTableHeader().setDefaultRenderer(thr);

        JPanel btnPanel = new JPanel();


        JButton b1 = new JButton("查询");
        b1.setFont(new Font("宋体", Font.BOLD, 25));


        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getMessageInfo();
            }
        });


        JButton b4 = new JButton("删除");
        b4.setFont(new Font("宋体", Font.BOLD, 25));

        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = studentMessageTable.getSelectedRow();//获取被选中的行
                String tid;
                String message;
                try {
                    tid = studentMessageData.get(row).get(0);//获得第1列，也就是tid
                    message = studentMessageData.get(row).get(1);//获得第2列，也就是留言内容，按tid和留言内容执行删除
                    HouseMasterManager_StudentMessage_Controller.deleteStudentMessage(tid, message);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                    JOptionPane.showMessageDialog(frame, "请选择一个项目");
                }

                try {
                    studentMessageData.remove(row);//从表格中移出一行
                } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {

                }
                //更新整个表格数据，删掉的那条记录将不再显示
                studentMessageTable.validate();
                studentMessageTable.updateUI();
            }
        });


        Box vBox = Box.createVerticalBox();
        vBox.add(Box.createVerticalStrut(80));
        vBox.add(b1);
        vBox.add(Box.createVerticalStrut(80));
        vBox.add(b4);
        btnPanel.add(vBox);

        jsp.setDividerLocation(900);
        studentMessageTable.setBounds(350, 70, 900, 775);


        tablepanel.add(studentMessageTable.getTableHeader());//将表头放到Jpanel里
        tablePane = new JScrollPane(studentMessageTable);
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
