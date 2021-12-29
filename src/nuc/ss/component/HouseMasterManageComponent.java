package nuc.ss.component;
/**
 * @author 王志凯
 * @description 宿管管理页面
 */

import nuc.ss.controller.SystemController_HouseMasterManage_Controller;
import nuc.ss.domain.HouseMaster;
import nuc.ss.dialog.AddHouseMasterJDialog;
import nuc.ss.informationtable.AdminTable;
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

import static nuc.ss.informationtable.AdminTable.adminModel;

public class HouseMasterManageComponent extends Box {
    private JFrame frame;
    public static JPanel tablepanel = new JPanel();//创建一个JPanel,放置显示数据的表格
    public static JScrollPane tablePane = null;

    //手工添加
    private ArrayList<String> tableHeadList;
    private AdminTable adminTable;
    private Vector<Vector<String>> tableData = new Vector<Vector<String>>();

    public HouseMasterManageComponent(JFrame frame) {
        super(BoxLayout.X_AXIS);
        init();
    }

    public void init() {

        JSplitPane jsp = new JSplitPane();
        jsp.setEnabled(false);
        //支持连续布局
        jsp.setContinuousLayout(true);
        jsp.setDividerLocation(900);
        jsp.setDividerSize(7);

        tableHeadList = new ArrayList<String>();
        tableHeadList.add("工号");
        tableHeadList.add("姓名");
        tableHeadList.add("性别");
        tableHeadList.add("密码");
        tableHeadList.add("管理宿舍楼号");
        tableHeadList.add("联系电话");

        Vector<String> titles = new Vector<>(tableHeadList);//创建存放表头的Vector

        adminModel = new DefaultTableModel(tableData, titles);
        adminTable = new AdminTable(adminModel);
        adminTable.setFont(new Font("微软雅黑", Font.BOLD, 20));

        adminTable.setPreferredScrollableViewportSize(new Dimension(900, 800));//设置表格大小
        adminTable.setRowHeight(35);

        adminTable.getTableHeader().setBackground(new Color(150, 150, 231));//设置表头颜色
        adminTable.getTableHeader().setPreferredSize(new Dimension(35, 50));//设置表头大小
        adminTable.getTableHeader().setFont(new Font("宋体", Font.BOLD, 25));

        adminTable.setSelectionBackground(new Color(216, 133, 222));//设置单元格选中的背景色
        adminTable.setBackground(new Color(214, 203, 238, 255));

        adminTable.getColumnModel().getColumn(0).setPreferredWidth(500);//设置列的宽度
        adminTable.getColumnModel().getColumn(1).setPreferredWidth(500);
        adminTable.getColumnModel().getColumn(2).setPreferredWidth(500);
        adminTable.getColumnModel().getColumn(3).setPreferredWidth(500);
        adminTable.getColumnModel().getColumn(4).setPreferredWidth(700);
        adminTable.getColumnModel().getColumn(5).setPreferredWidth(700);
        //表格内容居中
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(JLabel.CENTER);
        adminTable.setDefaultRenderer(Object.class, tcr);

        //表头内容居中
        DefaultTableCellHeaderRenderer thr = new DefaultTableCellHeaderRenderer();
        thr.setHorizontalAlignment(JLabel.CENTER);
        adminTable.getTableHeader().setDefaultRenderer(thr);


        JPanel btnPanel = new JPanel();

        JButton b1 = new JButton("查询");
        b1.setFont(new Font("宋体", Font.BOLD, 25));


        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getHouseMasterInfo();
            }
        });

        JButton b2 = new JButton("添加");
        b2.setFont(new Font("宋体", Font.BOLD, 25));

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddHouseMasterJDialog(frame, "添加宿管", true).setVisible(true);
            }
        });


        JButton b3 = new JButton("修改");
        b3.setBounds(1320, 270, 200, 50);
        b3.setFont(new Font("宋体", Font.BOLD, 25));

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = adminTable.getSelectedRow();//获取选中的行
                int column = 0;
                String val = "";
                try {
                    column = adminTable.getSelectedColumn();//获取选中的列
                    val = tableData.get(row).get(column);//被选中的列的值
                } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                    JOptionPane.showMessageDialog(frame, "请选中一个条目");
                }

                boolean flag = false;
                try {
                    String tid = tableData.get(row).get(0);//取得tid
                    flag = SystemController_HouseMasterManage_Controller.updateHouseMaster(val, tid, tableHeadList, column);
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
        JButton b5 = new JButton("重置密码");
        b5.setBounds(1320, 270, 200, 50);
        b5.setFont(new Font("宋体", Font.BOLD, 25));

        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = adminTable.getSelectedRow();//获取选中的行
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
                    String tid = tableData.get(row).get(0);//取得tid
                    flag = SystemController_HouseMasterManage_Controller.updateHouseMaster(val, tid, tableHeadList, column);
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


        JButton b4 = new JButton("删除");
        b4.setBounds(1320, 360, 200, 50);
        b4.setFont(new Font("宋体", Font.BOLD, 25));

        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = adminTable.getSelectedRow();//获取被选中的行
                String tid = tableData.get(row).get(0);//获得第1列，也就是tid，按tid执行删除
                boolean flag = false;
                try {
                    flag = SystemController_HouseMasterManage_Controller.deleteHouseMaster(tid);
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

                tableData.remove(row);//从表格中移出一行
                //更新整个表格数据，删掉的那条记录将不再显示
                adminTable.validate();
                adminTable.updateUI();
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
        adminTable.setBounds(350, 70, 900, 775);

        tablepanel.add(adminTable.getTableHeader());
        tablePane = new JScrollPane(adminTable);
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

    private void getHouseMasterInfo() {//获取数据
        try {
            tableData.clear();
            ArrayList<HouseMaster> houseMasters = SystemController_HouseMasterManage_Controller.searchHouseMaster();
            for (int i = 0; i < houseMasters.size(); i++) {
                Vector<String> record = new Vector<String>();
                for (int j = 0; j < 6; j++) {
                    record.add(houseMasters.get(i).getId());
                    record.add(houseMasters.get(i).getName());
                    record.add(houseMasters.get(i).getSex() + "");
                    record.add(houseMasters.get(i).getPassword());
                    record.add(houseMasters.get(i).getDormitoryId());
                    record.add(houseMasters.get(i).getPhoneNumber());
                }
                tableData.add(record);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
        adminTable.validate();
        adminTable.updateUI();
    }

}
