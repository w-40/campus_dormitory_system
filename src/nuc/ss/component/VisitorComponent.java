package nuc.ss.component;
import static nuc.ss.informationtable.VisitorTable.visitorModel;
/**
 * @author 娄靖彬，王志凯修复bug
 * @description 访客管理页面
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import nuc.ss.controller.SystemController_VisitorManage_Controller;
import nuc.ss.dao.SystemController_VisitorManage_JDBC;
import nuc.ss.dialog.AddVisitorJDialog;
import nuc.ss.domain.Visitor;
import nuc.ss.informationtable.VisitorTable;
import sun.swing.table.DefaultTableCellHeaderRenderer;

public class VisitorComponent extends Box {

    public VisitorComponent(JFrame frame) {
        super(BoxLayout.X_AXIS);
        init();
    }

    private JFrame frame;
    public static JPanel tablepanel = new JPanel();//创建一个JPanel,放置显示数据的表格
    public static JScrollPane tablePane = null;

    //手工添加
    private VisitorTable visitorTable;
    private ArrayList<String> tableHeadList;
    private Vector<Vector<String>> visitorData = new Vector<Vector<String>>();

    public void init() {
        JSplitPane jsp = new JSplitPane();
        jsp.setEnabled(false);
        //支持连续布局
        jsp.setContinuousLayout(true);
        jsp.setDividerLocation(900);
        jsp.setDividerSize(1);

        tableHeadList = new ArrayList<String>();
        tableHeadList.add("姓名");
        tableHeadList.add("联系方式");
        tableHeadList.add("来访时间");
        tableHeadList.add("来访事宜");
        tableHeadList.add("身份");
        Vector<String> titles = new Vector<>(tableHeadList);//创建存放表头的Vector

        visitorModel = new DefaultTableModel(visitorData, titles);
        visitorTable = new VisitorTable(visitorModel);
        visitorTable.setFont(new Font("微软雅黑", Font.BOLD, 20));

        visitorTable.setPreferredScrollableViewportSize(new Dimension(900, 800));//设置表格大小
        visitorTable.setRowHeight(35);

        visitorTable.getTableHeader().setBackground(new Color(150, 150, 231));//设置表头颜色
        visitorTable.getTableHeader().setPreferredSize(new Dimension(35, 50));//设置表头大小
        visitorTable.getTableHeader().setFont(new Font("宋体", Font.BOLD, 25));

        visitorTable.setSelectionBackground(new Color(216, 133, 222));//设置单元格选中的背景色
        visitorTable.setBackground(new Color(214, 203, 238, 255));

        visitorTable.getColumnModel().getColumn(0).setPreferredWidth(400);//设置列的宽度
        visitorTable.getColumnModel().getColumn(1).setPreferredWidth(700);
        visitorTable.getColumnModel().getColumn(2).setPreferredWidth(400);
        visitorTable.getColumnModel().getColumn(3).setPreferredWidth(500);
        visitorTable.getColumnModel().getColumn(4).setPreferredWidth(300);

        //表格内容居中
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(JLabel.CENTER);
        visitorTable.setDefaultRenderer(Object.class, tcr);

        //表头内容居中
        DefaultTableCellHeaderRenderer thr = new DefaultTableCellHeaderRenderer();
        thr.setHorizontalAlignment(JLabel.CENTER);
        visitorTable.getTableHeader().setDefaultRenderer(thr);

        JPanel btnPanel = new JPanel();

        JButton b1 = new JButton("查询");
        b1.setFont(new Font("宋体", Font.BOLD, 25));


        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getVisitorInfo();
            }
        });

        JButton b2 = new JButton("添加");
        b2.setFont(new Font("宋体", Font.BOLD, 25));

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddVisitorJDialog(frame, "添加访客", true).setVisible(true);
            }
        });


        JButton b3 = new JButton("修改");
        b3.setFont(new Font("宋体", Font.BOLD, 25));

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = visitorTable.getSelectedRow();//获取选中的行
                int column = 0;
                String val = "";
                try {
                    column = visitorTable.getSelectedColumn();//获取选中的列
                    val = visitorData.get(row).get(column);//被选中的列的值
                } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                    JOptionPane.showMessageDialog(frame, "请选中一个条目");
                }
                boolean flag = false;
                try {
                    String tid = visitorData.get(row).get(0);//取得tid
                    flag = SystemController_VisitorManage_Controller.updateVisitor(val, tid, tableHeadList, column);
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


  
        Box vBox = Box.createVerticalBox();
        vBox.add(Box.createVerticalStrut(80));
        vBox.add(b1);
        vBox.add(Box.createVerticalStrut(80));
        vBox.add(b2);
        vBox.add(Box.createVerticalStrut(80));
        vBox.add(b3);

        btnPanel.add(vBox);


        jsp.setDividerLocation(900);
        visitorTable.setBounds(350, 70, 900, 775);

        tablepanel.add(visitorTable.getTableHeader());
        tablePane = new JScrollPane(visitorTable);
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

    private void getVisitorInfo() {//获取数据
        try {
        	visitorData.clear();
            ArrayList<Visitor> visitors = SystemController_VisitorManage_JDBC.searchVisitor();
            for (int i = 0; i < visitors.size(); i++) {
                Vector<String> record = new Vector<String>();
                for (int j = 0; j < 9; j++) {
                    record.add(visitors.get(i).getName());
                    record.add(visitors.get(i).getTel());
                    record.add(visitors.get(i).getTime());
                    record.add(visitors.get(i).getVisitMatters());
                    record.add(visitors.get(i).getIdentity());
                }
                visitorData.add(record);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
        visitorTable.validate();
        visitorTable.updateUI();
    }
}




