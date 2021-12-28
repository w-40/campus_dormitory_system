package nuc.ss.view;
/**
 * @author 籍乃博
 * @description 宿舍管理员主页面
 */

import nuc.ss.controller.HouseMasterManager_StudentViolatinOfDiscipline_Controller;
import nuc.ss.controller.SystemController_HouseMasterManage_Controller;
import nuc.ss.domain.StudentViolationOfDiscipline;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultTreeModel;


import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import static nuc.ss.view.AdminTable.adminModel;


public class HouseMasterInterface {

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
                    HouseMasterInterface window = new HouseMasterInterface();
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
    public HouseMasterInterface() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        frame = new JFrame();
        frame.setTitle("校园宿舍管理系统_宿舍管理员主界面");
        frame.getContentPane().setBackground(new Color(135, 206, 235));
        frame.setBounds(100, 100, 1600, 915);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JTree tree = new JTree();
        DefaultMutableTreeNode t1 = new DefaultMutableTreeNode("学生违纪管理");
        DefaultMutableTreeNode t2 = new DefaultMutableTreeNode("访客信息管理");
        DefaultMutableTreeNode t3 = new DefaultMutableTreeNode("学生留言查看");
        DefaultMutableTreeNode t4 = new DefaultMutableTreeNode("个人账户信息");
        Color color = new Color(135, 206, 235);
        tree.setBackground(new Color(135, 206, 235));
        DefaultTreeCellRenderer cellRenderer = new DefaultTreeCellRenderer();
        cellRenderer.setBackgroundNonSelectionColor(new Color(135, 206, 235));
        cellRenderer.setBackgroundSelectionColor(new Color(135, 206, 235));
        //tree.setFont(new Font("TimesNewRoman", Font.PLAIN, 30));
        tree.setFont(new Font("Courier", Font.PLAIN, 30));
        tree.setModel(new DefaultTreeModel(
                new DefaultMutableTreeNode("宿舍管理员") {
                    {
                        add(t1);
                        add(t2);
                        add(t3);
                        add(t4);
                    }
                }
        ));
        tree.setBounds(0, 0, 350, 428);
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
        tablepanel.setBounds(350, 0, 900, 800);
        //tablepanel.add(adminTable.getTableHeader());
        frame.getContentPane().add(tablepanel);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(135, 206, 235));
        frame.setJMenuBar(menuBar);

        JMenu mnNewMenu = new JMenu("设置");
        mnNewMenu.setFont(new Font("宋体", Font.PLAIN, 25));
        menuBar.add(mnNewMenu);

        JMenuItem mntmNewMenuItem = new JMenuItem("返回");
        mntmNewMenuItem.setFont(new Font("宋体", Font.PLAIN, 25));
        mnNewMenu.add(mntmNewMenuItem);
        mntmNewMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new LoginFrame();
            }
        });

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("退出");
        mntmNewMenuItem_1.setFont(new Font("宋体", Font.PLAIN, 25));
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mnNewMenu.addSeparator();
        mnNewMenu.add(mntmNewMenuItem_1);
        frame.setVisible(true);
    }

    public void init() {
        tableHeadList = new ArrayList<String>();
        tableHeadList.add("学号");
        tableHeadList.add("姓名");
        tableHeadList.add("宿舍号");
        tableHeadList.add("违纪内容");
        tableHeadList.add("违纪时间");

        Vector<String> titles = new Vector<>(tableHeadList);//创建存放表头的Vector


        //adminTable = new AdminTable(tableData, titles);//初始化整个数据表格
        adminModel = new DefaultTableModel(tableData, titles);
        adminTable = new AdminTable(adminModel);
        adminTable.setFont(new Font("微软雅黑", Font.BOLD, 20));

        adminTable.setPreferredScrollableViewportSize(new Dimension(900, 800));//设置表格大小
        adminTable.setRowHeight(35);

        adminTable.getTableHeader().setBackground(new Color(255, 0, 0));//设置表头颜色
        adminTable.getTableHeader().setPreferredSize(new Dimension(35, 50));//设置表头大小
        adminTable.getTableHeader().setFont(new Font("宋体", Font.BOLD, 25));

        adminTable.setSelectionBackground(new Color(216, 133, 222));//设置单元格选中的背景色
        adminTable.setBackground(new Color(214, 203, 238, 255));

        adminTable.getColumnModel().getColumn(0).setPreferredWidth(500);//设置列的宽度
        adminTable.getColumnModel().getColumn(1).setPreferredWidth(500);
        adminTable.getColumnModel().getColumn(2).setPreferredWidth(500);
        adminTable.getColumnModel().getColumn(3).setPreferredWidth(500);
        adminTable.getColumnModel().getColumn(4).setPreferredWidth(700);
        //表格内容居中
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(JLabel.CENTER);
        adminTable.setDefaultRenderer(Object.class, tcr);

        JButton b1 = new JButton("查询");
        b1.setBounds(1320, 90, 200, 50);
        frame.getContentPane().add(b1);
        b1.setFont(new Font("宋体", Font.BOLD, 25));


        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getDisciplinaryInfo();
            }
        });

        JButton b2 = new JButton("添加");
        b2.setBounds(1320, 180, 200, 50);
        frame.getContentPane().add(b2);
        b2.setFont(new Font("宋体", Font.BOLD, 25));

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDisciplinaryInformationDialog(frame, "添加违纪信息", true).setVisible(true);
            }
        });


        JButton b3 = new JButton("修改");
        b3.setBounds(1320, 270, 200, 50);
        frame.getContentPane().add(b3);
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

                try {
                    String tid = tableData.get(row).get(0);//取得tid
                    HouseMasterManager_StudentViolatinOfDiscipline_Controller.updateStudentViolatinOfDiscipline(val, tid, tableHeadList, column);
                } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        });


        JButton b4 = new JButton("删除");
        b4.setBounds(1320, 360, 200, 50);
        frame.getContentPane().add(b4);
        b4.setFont(new Font("宋体", Font.BOLD, 25));

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

    private void getDisciplinaryInfo() {//获取数据
        try {
            tableData.clear();
            ArrayList<StudentViolationOfDiscipline> svodlist = HouseMasterManager_StudentViolatinOfDiscipline_Controller.searchStudentViolatinOfDiscipline();
            for (int i = 0; i < svodlist.size(); i++) {
                Vector<String> record = new Vector<String>();
                for (int j = 0; j < 6; j++) {
                    record.add(svodlist.get(i).getId());
                    record.add(svodlist.get(i).getName());
                    record.add(svodlist.get(i).getDormId() + "");
                    record.add(svodlist.get(i).getContent());
                    record.add(svodlist.get(i).getTime());
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
