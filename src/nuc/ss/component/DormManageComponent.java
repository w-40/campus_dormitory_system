package nuc.ss.component;

import nuc.ss.controller.SystemController_DormManage_Controller;
import nuc.ss.controller.SystemController_DormitoryManage_Controller;
import nuc.ss.dialog.AddDormJDialog;
import nuc.ss.dialog.AddDormitoryJDialog;
import nuc.ss.domain.Dorm;
import nuc.ss.domain.Dormitory;
import nuc.ss.informationtable.DormTable;
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

import static javax.swing.BoxLayout.*;
import static nuc.ss.informationtable.DormTable.DormModel;

/**
 * @author hsystart
 * @create 2021-12-28 18:32
 * @description 宿舍房间管理
 */
public class DormManageComponent extends Box {

    public DormManageComponent(JFrame frame) {
        super(X_AXIS);
        init();
    }

    private JFrame frame;
    private ArrayList<String> tableHeadList;
    private nuc.ss.informationtable.DormTable DormTable;

    public static JPanel tablepanel = new JPanel();//创建一个JPanel,放置显示数据的表格
    public static JScrollPane tablePane = null;
    private Vector<Vector<String>> DormTableData = new Vector<Vector<String>>();


    public void init() {
        JSplitPane jsp = new JSplitPane();
        jsp.setEnabled(false);
        //支持连续布局
        jsp.setContinuousLayout(true);
        jsp.setDividerLocation(900);
        jsp.setDividerSize(7);

        tableHeadList = new ArrayList<String>();
        tableHeadList.add("宿舍号");
        tableHeadList.add("宿舍楼号");
        tableHeadList.add("人数");

        Vector<String> titles = new Vector<>(tableHeadList);//创建存放表头的Vector
        //adminTable = new AdminTable(tableData, titles);//初始化整个数据表格
        DormModel = new DefaultTableModel(DormTableData, titles);
        DormTable = new DormTable(DormModel);
        DormTable.setFont(new Font("微软雅黑", Font.BOLD, 20));

        DormTable.setPreferredScrollableViewportSize(new Dimension(900, 800));//设置表格大小
        DormTable.setRowHeight(35);

        DormTable.getTableHeader().setBackground(new Color(150, 150, 231));//设置表头颜色
        DormTable.getTableHeader().setPreferredSize(new Dimension(35, 50));//设置表头大小
        DormTable.getTableHeader().setFont(new Font("宋体", Font.BOLD, 25));

        DormTable.setSelectionBackground(new Color(216, 133, 222));//设置单元格选中的背景色
        DormTable.setBackground(new Color(214, 203, 238, 255));

        DormTable.getColumnModel().getColumn(0).setPreferredWidth(500);//设置列的宽度
        DormTable.getColumnModel().getColumn(1).setPreferredWidth(500);
        DormTable.getColumnModel().getColumn(2).setPreferredWidth(500);

        //表格内容居中
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(JLabel.CENTER);
        DormTable.setDefaultRenderer(Object.class, tcr);

        //表头内容居中
        DefaultTableCellHeaderRenderer thr = new DefaultTableCellHeaderRenderer();
        thr.setHorizontalAlignment(JLabel.CENTER);
        DormTable.getTableHeader().setDefaultRenderer(thr);


        JPanel btnPanel = new JPanel();

        JButton b1 = new JButton("查询");
        b1.setFont(new Font("宋体", Font.BOLD, 25));


        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getDormInfo();
            }
        });

        JButton b2 = new JButton("添加");
        b2.setFont(new Font("宋体", Font.BOLD, 25));

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDormJDialog(frame, "添加宿舍信息", true).setVisible(true);
            }
        });


        JButton b3 = new JButton("修改");
        b3.setFont(new Font("宋体", Font.BOLD, 25));

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = DormTable.getSelectedRow();//获取选中的行
                int column = 0;
                String val = "";
                try {
                    column = DormTable.getSelectedColumn();//获取选中的列
                    val = DormTableData.get(row).get(column);//被选中的列的值

                    if (column == 0 || column == 1) {
                        JOptionPane.showMessageDialog(frame, "修改失败，宿舍号和宿舍所在楼号不允许修改(点击查询进行刷新)");
                        return;
                    }

                } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                    JOptionPane.showMessageDialog(frame, "请选中一个条目");
                }
                boolean flag = false;
                try {
                    String tid = DormTableData.get(row).get(0);//取得tid
                    flag = SystemController_DormManage_Controller.updateDorm(val, tid, tableHeadList, column);
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
                int row = DormTable.getSelectedRow();//获取被选中的行
                String tid = DormTableData.get(row).get(0);//获得第1列，也就是tid，按tid执行删除
                boolean flag = false;
                try {
                    flag = SystemController_DormManage_Controller.deleteDorm(tid);
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


                DormTableData.remove(row);//从表格中移出一行
                //更新整个表格数据，删掉的那条记录将不再显示
                DormTable.validate();
                DormTable.updateUI();
            }
        });


        JButton b5 = new JButton("查询有空余床位的宿舍");
        b5.setFont(new Font("宋体", Font.BOLD, 25));


        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getDormInfo();
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
        DormTable.setBounds(350, 70, 900, 775);

        tablepanel.add(DormTable.getTableHeader());
        tablePane = new JScrollPane(DormTable);
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

    private void getDormInfo() {//获取数据
        try {
            DormTableData.clear();
            ArrayList<Dorm> Dorms = SystemController_DormManage_Controller.searchDorm();
            for (int i = 0; i < Dorms.size(); i++) {
                Vector<String> record = new Vector<String>();
                for (int j = 0; j < 3; j++) {
                    record.add(Dorms.get(i).getId() + "");
                    record.add(Dorms.get(i).getDormitoryId());
                    record.add(Dorms.get(i).getNum() + "");
                }
                DormTableData.add(record);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
        DormTable.validate();
        DormTable.updateUI();

    }

}

