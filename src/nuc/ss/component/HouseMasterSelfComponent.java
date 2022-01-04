package nuc.ss.component;
/**
 * @author 籍乃博
 * @description 个人账户管理界面
 */

import nuc.ss.controller.HouseMasterManager_HouseMasterSelf_Controller;

import nuc.ss.controller.SystemController_HouseMasterManage_Controller;
import nuc.ss.domain.HouseMaster;
import nuc.ss.dialog.AddHouseMasterJDialog;
import nuc.ss.dialog.ModifyPasswordDialog;
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

public class HouseMasterSelfComponent extends Box {

    private JFrame frame;
    private JLabel l_name, l_id, l_dormitoryId, l_phoneNumber, l_sex;
    private JLabel lname, lid, ldormitoryId, phoneNumber, lsex;
    private JButton b_modify;

    //手工添加
    public HouseMasterSelfComponent(JFrame frame, String username) throws ClassNotFoundException, SQLException {
        super(BoxLayout.X_AXIS);
        init(username);
    }

    public void init(String username) throws ClassNotFoundException, SQLException {

        HouseMaster hm = new HouseMaster();
        hm = HouseMasterManager_HouseMasterSelf_Controller.searchHouseMasterSelf(username);

        JLabel l_name = new JLabel("姓名:");
        JLabel l_id = new JLabel("工号:");
        JLabel l_dormitoryId = new JLabel("管理宿舍楼号:");
        JLabel l_phoneNumber = new JLabel("联系电话:");
        JLabel l_sex = new JLabel("性别:");

        JLabel lname = new JLabel(hm.getName());
        JLabel lid = new JLabel(hm.getId());
        JLabel ldormitoryId = new JLabel(hm.getDormitoryId());
        JLabel lphoneNumber = new JLabel(hm.getPhoneNumber());
        JLabel lsex = new JLabel(String.valueOf(hm.getSex()));

        Font font = new Font("宋体", Font.PLAIN, 30);

        l_name.setFont(font);
        l_id.setFont(font);
        l_dormitoryId.setFont(font);
        l_phoneNumber.setFont(font);
        l_sex.setFont(font);

        lname.setFont(font);
        lid.setFont(font);
        ldormitoryId.setFont(font);
        lphoneNumber.setFont(font);
        lsex.setFont(font);

        String id = hm.getId();

        JButton b_modify = new JButton("修改密码");
        b_modify.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                new ModifyPasswordDialog(frame, "修改密码", true, id).setVisible(true);
                ;
            }

        });
        b_modify.setFont(font);

        Box id_name = Box.createHorizontalBox();
        id_name.add(l_id);
        id_name.add(Box.createHorizontalStrut(20));
        id_name.add(lid);
        id_name.add(Box.createHorizontalStrut(350));
        id_name.add(l_name);
        id_name.add(Box.createHorizontalStrut(20));
        id_name.add(lname);
        id_name.add(Box.createHorizontalStrut(240));


        Box sex_dormitory = Box.createHorizontalBox();
        sex_dormitory.add(l_sex);
        sex_dormitory.add(Box.createHorizontalStrut(20));
        sex_dormitory.add(lsex);
        sex_dormitory.add(Box.createHorizontalStrut(350));
        sex_dormitory.add(l_dormitoryId);
        sex_dormitory.add(Box.createHorizontalStrut(20));
        sex_dormitory.add(ldormitoryId);
        sex_dormitory.add(Box.createHorizontalStrut(200));

        Box bphoneNumber = Box.createHorizontalBox();
        bphoneNumber.add(Box.createHorizontalGlue());
        bphoneNumber.add(l_phoneNumber);
        bphoneNumber.add(lphoneNumber);
        bphoneNumber.add(Box.createHorizontalStrut(770));

        Box bbutton = Box.createHorizontalBox();
        bbutton.add(b_modify);
        bbutton.add(Box.createHorizontalStrut(750));


        Box bigBox = Box.createVerticalBox();
        bigBox.add(id_name);
        bigBox.add(sex_dormitory);
        bigBox.add(bphoneNumber);
        bigBox.add(bbutton);
        bigBox.add(Box.createVerticalStrut(400));

        this.add(bigBox);


    }
}
