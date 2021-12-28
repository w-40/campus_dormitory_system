package nuc.ss.component;
/**
 * @author 王志凯
 * @description 宿舍楼管理页面
 */

import nuc.ss.controller.SystemController_DormitoryManage_Controller;
import nuc.ss.dao.SystemController_DormitoryManage_JDBC;
import nuc.ss.dialog.AddDormitoryJDialog;
import nuc.ss.domain.Dormitory;
import nuc.ss.informationtable.DormitoryTable;
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

import static nuc.ss.informationtable.DormitoryTable.dormitoryModel;

public class DormitoryManageComponent extends Box {


    public DormitoryManageComponent(JFrame frame) {
        super(BoxLayout.X_AXIS);
        init();
    }

    private JFrame frame;
    private ArrayList<String> tableHeadList;
    private DormitoryTable dormitoryTable;

    public static JPanel tablepanel = new JPanel();//创建一个JPanel,放置显示数据的表格
    public static JScrollPane tablePane = null;
    private Vector<Vector<String>> dormitoryTableData = new Vector<Vector<String>>();


    public void init() {
        JSplitPane jsp = new JSplitPane();
        jsp.setEnabled(false);
        //支持连续布局
        jsp.setContinuousLayout(true);
        jsp.setDividerLocation(900);
        jsp.setDividerSize(7);

        tableHeadList = new ArrayList<String>();
        tableHeadList.add("宿舍楼号");
        tableHeadList.add("宿舍楼名称");

        Vector<String> titles = new Vector<>(tableHeadList);//创建存放表头的Vector
        //adminTable = new AdminTable(tableData, titles);//初始化整个数据表格
        dormitoryModel = new DefaultTableModel(dormitoryTableData, titles);
        dormitoryTable = new DormitoryTable(dormitoryModel);
        dormitoryTable.setFont(new Font("微软雅黑", Font.BOLD, 20));

        dormitoryTable.setPreferredScrollableViewportSize(new Dimension(900, 800));//设置表格大小
        dormitoryTable.setRowHeight(35);

        dormitoryTable.getTableHeader().setBackground(new Color(150, 150, 231));//设置表头颜色
        dormitoryTable.getTableHeader().setPreferredSize(new Dimension(35, 50));//设置表头大小
        dormitoryTable.getTableHeader().setFont(new Font("宋体", Font.BOLD, 25));

        dormitoryTable.setSelectionBackground(new Color(216, 133, 222));//设置单元格选中的背景色
        dormitoryTable.setBackground(new Color(214, 203, 238, 255));

        dormitoryTable.getColumnModel().getColumn(0).setPreferredWidth(500);//设置列的宽度
        dormitoryTable.getColumnModel().getColumn(1).setPreferredWidth(500);

        //表格内容居中
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(JLabel.CENTER);
        dormitoryTable.setDefaultRenderer(Object.class, tcr);

        //表头内容居中
        DefaultTableCellHeaderRenderer thr = new DefaultTableCellHeaderRenderer();
        thr.setHorizontalAlignment(JLabel.CENTER);
        dormitoryTable.getTableHeader().setDefaultRenderer(thr);


        JPanel btnPanel = new JPanel();

        JButton b1 = new JButton("查询");
        b1.setFont(new Font("宋体", Font.BOLD, 25));


        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getDormitoryInfo();
            }
        });

        JButton b2 = new JButton("添加");
        b2.setFont(new Font("宋体", Font.BOLD, 25));

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDormitoryJDialog(frame, "添加宿管楼信息", true).setVisible(true);
            }
        });


        JButton b3 = new JButton("修改");
        b3.setFont(new Font("宋体", Font.BOLD, 25));

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = dormitoryTable.getSelectedRow();//获取选中的行
                int column = 0;
                String val = "";
                try {
                    column = dormitoryTable.getSelectedColumn();//获取选中的列
                    val = dormitoryTableData.get(row).get(column);//被选中的列的值
                } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                    JOptionPane.showMessageDialog(frame, "请选中一个条目");
                }
                boolean flag = false;
                try {
                    String tid = dormitoryTableData.get(row).get(0);//取得tid
                    flag = SystemController_DormitoryManage_Controller.updateDormitory(val, tid, tableHeadList, column);
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
                int row = dormitoryTable.getSelectedRow();//获取被选中的行
                String tid = dormitoryTableData.get(row).get(0);//获得第1列，也就是tid，按tid执行删除
                boolean flag = false;
                try {
                    flag = SystemController_DormitoryManage_Controller.deleteDormitory(tid);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
                if (flag) {
                    JOptionPane.showMessageDialog(frame,"删除成功");
                }else {
                    JOptionPane.showMessageDialog(frame,"删除失败");
                }



                dormitoryTableData.remove(row);//从表格中移出一行
                //更新整个表格数据，删掉的那条记录将不再显示
                dormitoryTable.validate();
                dormitoryTable.updateUI();
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
        btnPanel.add(vBox);


        jsp.setDividerLocation(900);
        dormitoryTable.setBounds(350, 70, 900, 775);

        tablepanel.add(dormitoryTable.getTableHeader());
        tablePane = new JScrollPane(dormitoryTable);
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
    private void getDormitoryInfo() {//获取数据
        try {
            dormitoryTableData.clear();
            ArrayList<Dormitory> dormitorys = SystemController_DormitoryManage_Controller.searchDormitory();
            for (int i = 0; i < dormitorys.size(); i++) {
                Vector<String> record = new Vector<String>();
                for (int j = 0; j < 2; j++) {
                    record.add(dormitorys.get(i).getId());
                    record.add(dormitorys.get(i).getName());
                }
                dormitoryTableData.add(record);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
        dormitoryTable.validate();
        dormitoryTable.updateUI();
    }
}
