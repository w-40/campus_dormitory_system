package nuc.ss.view;
/**
 * @author 籍乃博，王志凯重构
 * @description 宿舍管理员主页面
 */

import nuc.ss.component.HouseMasterManageComponent;
import nuc.ss.component.StudentViolatinOfDisciplineComponent;
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

        //设置菜单栏
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
        frame.setJMenuBar(menuBar);


        //设置分割面板
        JSplitPane sp = new JSplitPane();
        sp.setEnabled(false);

        //支持连续布局
        sp.setContinuousLayout(true);
        sp.setDividerLocation(350);
        sp.setDividerSize(7);


        DefaultMutableTreeNode root = new DefaultMutableTreeNode("宿舍管理员");
        DefaultMutableTreeNode studentViolatinOfDisciplineManage = new DefaultMutableTreeNode("学生违纪管理");
        DefaultMutableTreeNode visitorInformationManage = new DefaultMutableTreeNode("访客信息管理");
        DefaultMutableTreeNode studentMessageManage = new DefaultMutableTreeNode("学生留言查看");
        DefaultMutableTreeNode individualAccountManage = new DefaultMutableTreeNode("个人账户信息");

        root.add(studentViolatinOfDisciplineManage);
        root.add(visitorInformationManage);
        root.add(studentMessageManage);
        root.add(individualAccountManage);
        JTree tree = new JTree(root);


        Color color = new Color(135, 206, 235);
        tree.setBackground(new Color(135, 206, 235));
        DefaultTreeCellRenderer cellRenderer = new DefaultTreeCellRenderer();
        cellRenderer.setBackgroundNonSelectionColor(new Color(135, 206, 235));
        cellRenderer.setBackgroundSelectionColor(new Color(135, 206, 235));
        //tree.setFont(new Font("TimesNewRoman", Font.PLAIN, 30));
        tree.setFont(new Font("Courier", Font.PLAIN, 30));


        tree.setBounds(0, 0, 350, 428);
        tree.setCellRenderer(cellRenderer);
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            //当条目选中变化后，这个方法会执行
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                //得到当前选中的结点对象
                Object lastPathComponent = e.getNewLeadSelectionPath().getLastPathComponent();
                if (studentViolatinOfDisciplineManage.equals(lastPathComponent)) {
                    sp.setRightComponent(new StudentViolatinOfDisciplineComponent(frame));
                    sp.setDividerLocation(350);
                }
//	                    else if(bookManage.equals(lastPathComponent)){
//	                    //sp.setRightComponent(new JLabel("这里进行图书管理..."));
//	                    sp.setRightComponent(new BookManageComponent(jf));
//	                    sp.setDividerLocation(150);
//
            }
        });

        sp.setLeftComponent(tree);

//        tablepanel.setBackground(new Color(135, 206, 235));
//        tablepanel.setForeground(new Color(224, 255, 255));
//        tablepanel.setBounds(350, 0, 900, 800);
//        //tablepanel.add(adminTable.getTableHeader());
//        frame.getContentPane().add(tablepanel);



        frame.add(sp);
        frame.setVisible(true);
    }


}
