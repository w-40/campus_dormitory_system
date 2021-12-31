package nuc.ss.component;

import nuc.ss.controller.SystemController_StudentServiceManage_Controller;
import nuc.ss.domain.Dorm;
import nuc.ss.informationtable.DormTable;
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

import static javax.swing.BoxLayout.X_AXIS;
import static nuc.ss.informationtable.DormTable.DormModel;

public class StudentServiceComponentLeft extends Box {
    public StudentServiceComponentLeft(JFrame frame) {
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
        jsp.setDividerSize(1);

        tableHeadList = new ArrayList<String>();
        tableHeadList.add("宿舍号");
        tableHeadList.add("宿舍楼号");
        tableHeadList.add("人数");

        Vector<String> titles = new Vector<>(tableHeadList);//创建存放表头的Vector
        //adminTable = new AdminTable(tableData, titles);//初始化整个数据表格
        DormModel = new DefaultTableModel(DormTableData, titles);
        DormTable = new DormTable(DormModel);
        DormTable.setFont(new Font("微软雅黑", Font.BOLD, 20));

        DormTable.setPreferredScrollableViewportSize(new Dimension(625, 800));//设置表格大小
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

        JButton b1 = new JButton("查询未满宿舍");
        b1.setFont(new Font("宋体", Font.BOLD, 25));

        JLabel tips = new JLabel("（s开头为女生宿舍）");
        tips.setFont(new Font("宋体", Font.PLAIN, 25));

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getNotFullDormInfo();
            }
        });

        btnPanel.add(b1);
        btnPanel.add(tips);

        jsp.setDividerLocation(625);
        DormTable.setBounds(350, 70, 625, 775);

        tablepanel.add(DormTable.getTableHeader());
        tablePane = new JScrollPane(DormTable);
        tablePane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        tablepanel.add(tablePane);//设置tablePane的大小

        tablepanel.setBackground(new Color(135, 206, 235));

        Box vBox = Box.createVerticalBox();
        vBox.add(btnPanel);
        vBox.add(tablepanel);

        jsp.setLeftComponent(vBox);
        jsp.setRightComponent(new StudentServiceComponentRight(frame));
        btnPanel.setBackground(new Color(135, 206, 235));
        tablepanel.setBackground(new Color(135, 206, 235));
        this.add(jsp);
        this.validate();
        this.repaint();
    }

    private void getNotFullDormInfo() {//获取数据
        DormTableData.clear();
        ArrayList<Dorm> NotFullDorms = null;
        try {
            NotFullDorms = SystemController_StudentServiceManage_Controller.searchNotFullDorm();
            for (int i = 0; i < NotFullDorms.size(); i++) {
                Vector<String> record = new Vector<String>();
                for (int j = 0; j < 3; j++) {
                    record.add(NotFullDorms.get(i).getId() + "");
                    record.add(NotFullDorms.get(i).getDormitoryId());
                    record.add(NotFullDorms.get(i).getNum() + "");
                }
                DormTableData.add(record);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        DormTable.validate();
        DormTable.updateUI();
    }
}
