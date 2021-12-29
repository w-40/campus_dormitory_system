package nuc.ss.view;
/**
 * @author 王志凯、韩思远，王志凯重构
 * @description 系统管理员主页面
 */


import nuc.ss.component.*;
import nuc.ss.informationtable.AdminTable;


import java.awt.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

//import static nuc.ss.informationtable.AdminTable.tableData;


public class ManageInterface {
    private JFrame frame;
    ;

    //手工添加
    private ArrayList<String> tableHeadList;
    private AdminTable adminTable;
    private Vector<Vector<String>> tableData = new Vector<Vector<String>>();


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


    public ManageInterface() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        frame = new JFrame();
        frame.setTitle("校园宿舍管理系统_系统管理员主界面");
        frame.setBackground(new Color(135, 206, 235));
        frame.setResizable(false);
        frame.setBounds(100, 100, 1600, 915);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //设置菜单栏
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(135, 206, 235));

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

        //设置左侧内容
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("系统管理员");
        DefaultMutableTreeNode houseMasterManage = new DefaultMutableTreeNode("宿管管理");
        DefaultMutableTreeNode studentManage = new DefaultMutableTreeNode("学生管理");
        DefaultMutableTreeNode dormitoryManage = new DefaultMutableTreeNode("宿舍楼管理");
        DefaultMutableTreeNode dormManage = new DefaultMutableTreeNode("宿舍管理");
        DefaultMutableTreeNode roomManage = new DefaultMutableTreeNode("宿舍房间管理");
        DefaultMutableTreeNode studentServiceManage = new DefaultMutableTreeNode("用户服务管理");

        root.add(houseMasterManage);
        root.add(studentManage);
        root.add(dormitoryManage);
        dormManage.add(roomManage);
        dormManage.add(studentServiceManage);
        root.add(dormManage);
        JTree tree = new JTree(root);


        expandAll(tree, new TreePath(root), true);//默认展开JTree所有结点

        tree.setBackground(new Color(135, 206, 235));
        DefaultTreeCellRenderer cellRenderer = new DefaultTreeCellRenderer();
        cellRenderer.setBackgroundNonSelectionColor(new Color(135, 206, 235));
        cellRenderer.setBackgroundSelectionColor(new Color(135, 206, 235));
        tree.setFont(new Font("TimesNewRoman", Font.PLAIN, 30));

        tree.setBounds(0, 0, 350, 428);
        tree.setCellRenderer(cellRenderer);
        //tree.setSelectionRow(2);

        JLabel rightLabel = new JLabel("请从左侧JTree进行业务选择", JLabel.CENTER);
        rightLabel.setFont(new Font("TimesNewRoman", Font.PLAIN, 60));

        sp.setRightComponent(rightLabel);
        sp.setDividerLocation(350);

        tree.addTreeSelectionListener(new TreeSelectionListener() {
            //当条目选中变化后，这个方法会执行
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                //得到当前选中的结点对象
                Object lastPathComponent = e.getNewLeadSelectionPath().getLastPathComponent();
                if (houseMasterManage.equals(lastPathComponent)) {
                    sp.setRightComponent(new HouseMasterManageComponent(frame));
                    sp.setDividerLocation(350);
                } else if (studentManage.equals(lastPathComponent)) {
                    sp.setRightComponent(new StudentManageComponent(frame));
                    sp.setDividerLocation(350);

                } else if (dormitoryManage.equals(lastPathComponent)) {
                    sp.setRightComponent(new DormitoryManageComponent(frame));
                    sp.setDividerLocation(350);
                } else if (roomManage.equals(lastPathComponent)) {
                    sp.setRightComponent(new DormManageComponent(frame));
                    sp.setDividerLocation(350);
                } else if (studentServiceManage.equals(lastPathComponent)) {
                    sp.setRightComponent(new StudentServiceComponent(frame));
                    sp.setDividerLocation(350);
                }

            }
        });


        sp.setLeftComponent(tree);

        frame.add(sp);
        frame.setVisible(true);
    }


    private static void expandAll(JTree tree, TreePath parent, boolean expand) {
        TreeNode node = (TreeNode) parent.getLastPathComponent();
        if (node.getChildCount() >= 0) {
            for (Enumeration e = node.children(); e.hasMoreElements(); ) {
                TreeNode n = (TreeNode) e.nextElement();
                TreePath path = parent.pathByAddingChild(n);
                expandAll(tree, path, expand);
            }
        }
        if (expand) {
            tree.expandPath(parent);
        } else {
            tree.collapsePath(parent);
        }
    }
}
