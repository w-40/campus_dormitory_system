package nuc.ss.view;
/**
 * @author 王志凯，韩思远
 * @description 系统管理员主页面
 */

import nuc.ss.controller.SystemController_HouseMasterManage_Controller;
import nuc.ss.domain.HouseMaster;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.RandomAccess;
import java.util.Vector;

import javax.naming.InitialContext;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.tree.DefaultTreeModel;


import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import java.awt.Font;
import java.awt.Color;

public class ManageInterface {

    private JFrame frame;
    public static JPanel tablepanel = new JPanel();//创建一个JPanel,放置显示数据的表格
    public static JScrollPane tablePane = null;

    //手工添加
    private AdminTable adminTable;
    private ArrayList<String> tableHeadList;
    private Vector<Vector<String>> tableData = new Vector<Vector<String>>();


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ManageInterface window = new ManageInterface();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public ManageInterface() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(135, 206, 235));
        frame.setBounds(100, 100, 822, 515);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JTree tree = new JTree();
        DefaultMutableTreeNode t1 = new DefaultMutableTreeNode("宿管管理");
        DefaultMutableTreeNode t2 = new DefaultMutableTreeNode("学生管理");
        DefaultMutableTreeNode t3 = new DefaultMutableTreeNode("宿舍楼管理");
        DefaultMutableTreeNode t4 = new DefaultMutableTreeNode("宿舍管理");
        DefaultMutableTreeNode t5 = new DefaultMutableTreeNode("宿舍房间管理");
        DefaultMutableTreeNode t6 = new DefaultMutableTreeNode("学生服务管理");
        DefaultMutableTreeNode t7 = new DefaultMutableTreeNode("密码修改");
        Color color = new Color(135, 206, 235);
        tree.setBackground(new Color(135, 206, 235));
        DefaultTreeCellRenderer cellRenderer = new DefaultTreeCellRenderer();
        cellRenderer.setBackgroundNonSelectionColor(new Color(135, 206, 235));
        cellRenderer.setBackgroundSelectionColor(new Color(135, 206, 235));
        tree.setFont(new Font("隶书", Font.PLAIN, 20));
        tree.setModel(new DefaultTreeModel(
                new DefaultMutableTreeNode("系统管理员") {
                    {
                        add(t1);
                        add(t2);
                        add(t3);
                        t4.add(t5);
                        t4.add(t6);
                        add(t4);
                        add(t7);
                    }
                }
        ));
        tree.setBounds(0, 0, 197, 428);
        tree.setCellRenderer(cellRenderer);
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            //当条目选中变化后，这个方法会执行
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                //得到当前选中的结点对象
                Object lastPathComponent = e.getNewLeadSelectionPath().getLastPathComponent();
                if (t1.equals(lastPathComponent)) {
                    init();
                    tablepanel.add(adminTable.getTableHeader());//将表头放到Jpanel里
                    tablePane = new JScrollPane(adminTable);
                    tablePane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                    tablepanel.add(tablePane);//设置tablePane的大小
                }
//	                    else if(bookManage.equals(lastPathComponent)){
//	                    //sp.setRightComponent(new JLabel("这里进行图书管理..."));
//	                    sp.setRightComponent(new BookManageComponent(jf));
//	                    sp.setDividerLocation(150);
//
            }
        });
        tree.setShowsRootHandles(true);

        tree.setRootVisible(true);
        frame.getContentPane().add(tree);


        tablepanel.setBackground(new Color(135, 206, 235));
        tablepanel.setForeground(new Color(224, 255, 255));
        tablepanel.setBounds(202, 0, 474, 413);
        //tablepanel.add(adminTable.getTableHeader());
        frame.getContentPane().add(tablepanel);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(135, 206, 235));
        frame.setJMenuBar(menuBar);

        JMenu mnNewMenu = new JMenu("设置");
        menuBar.add(mnNewMenu);

        JMenuItem mntmNewMenuItem = new JMenuItem("返回");
        mnNewMenu.add(mntmNewMenuItem);

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("退出");
        mnNewMenu.add(mntmNewMenuItem_1);
    }
    public void init(){
        tableHeadList = new ArrayList<String>();
        tableHeadList.add("工号");
        tableHeadList.add("姓名");
        tableHeadList.add("性别");
        tableHeadList.add("密码");
        tableHeadList.add("管理宿舍楼号");
        tableHeadList.add("联系电话");

        Vector<String> titles = new Vector<>(tableHeadList);//创建存放表头的Vector
        adminTable = new AdminTable(tableData, titles);//初始化整个数据表格
        adminTable.getColumnModel().getColumn(0).setPreferredWidth(300);//设置列的宽度
        adminTable.getColumnModel().getColumn(1).setPreferredWidth(300);
        adminTable.getColumnModel().getColumn(2).setPreferredWidth(300);
        adminTable.getColumnModel().getColumn(3).setPreferredWidth(300);
        adminTable.getColumnModel().getColumn(4).setPreferredWidth(500);
        adminTable.getColumnModel().getColumn(5).setPreferredWidth(500);
        //表格内容居中
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(JLabel.CENTER);
        adminTable.setDefaultRenderer(Object.class, tcr);
        JButton b1 = new JButton("查询");
        b1.setBounds(683, 47, 110, 42);
        frame.getContentPane().add(b1);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
        });


        JButton b2 = new JButton("添加");
        b2.setBounds(683, 109, 110, 42);
        frame.getContentPane().add(b2);

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddHouseMasterJDialog(frame, "添加图书", true).setVisible(true);
            }
        });


        JButton b3 = new JButton("修改");
        b3.setBounds(683, 168, 110, 42);
        frame.getContentPane().add(b3);


        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = adminTable.getSelectedRow();//获取选中的行
                int column = adminTable.getSelectedColumn();//获取选中的列
                String val = tableData.get(row).get(column);//被选中的列的值
                String tid = tableData.get(row).get(0);//取得tid
                try {
                    SystemController_HouseMasterManage_Controller.updateHouseMaster(val,tid,tableHeadList,column);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        });



        JButton b4 = new JButton("删除");
        b4.setBounds(683, 229, 110, 42);
        frame.getContentPane().add(b4);

        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = adminTable.getSelectedRow();//获取被选中的行
                String tid = tableData.get(row).get(0);//获得第1列，也就是tid，按tid执行删除
                try {
                    SystemController_HouseMasterManage_Controller.deleteHouseMaster(tid);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
                tableData.remove(row);//从表格中移出一行
                //更新整个表格数据，删掉的那条记录将不再显示
                adminTable.validate();
                adminTable.updateUI();
            }
        });
        frame.validate();
        frame.repaint();
    }
}
