package nuc.ss.dialog;

import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import nuc.ss.controller.HouseMasterManager_HouseMasterSelf_Controller;
import nuc.ss.domain.HouseMaster;

public class ModifyPasswordDialog extends JDialog {

    private JLabel l_oldPassword, l_newPassword;
    private JTextField t_oldPassword, t_newPassword;
    private JButton b_modify, b_reset;
    Frame frame;


    public ModifyPasswordDialog(Frame frame, String title, boolean modal, String id) {
        this.setTitle("修改密码");
        this.setSize(450, 300);
        this.setLocationRelativeTo(null);
        init(id);
        this.setVisible(true);
    }

    public void init(String id) {
        this.setLayout(new GridLayout(3, 2, 5, 5));

        JLabel l_oldPassword = new JLabel("原密码", JLabel.CENTER);
        JLabel l_newPassword = new JLabel("新密码", JLabel.CENTER);

        JTextField t_oldPassword = new JTextField();
        JTextField t_newPassword = new JTextField();

        Font font = new Font("TimesNewRoman", Font.BOLD, 20);
        l_oldPassword.setFont(font);
        l_newPassword.setFont(font);

        t_oldPassword.setFont(font);
        t_newPassword.setFont(font);


        JButton b_modify = new JButton("修改");
        b_modify.setFont(font);
        b_modify.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String oldPassword = t_oldPassword.getText();
                String newPassword = t_newPassword.getText();
                String password = null;
//				System.out.println(oldPassword);
//				System.out.println(password);
                try {
                    password = HouseMasterManager_HouseMasterSelf_Controller.searchHouseMasterSelf(id).getPassword();
                    if (oldPassword.equals(password)) {
                        HouseMasterManager_HouseMasterSelf_Controller.updateHouseMasterPassWord(id, newPassword);
                        JOptionPane.showMessageDialog(frame, "修改成功");
                    } else {
                        JOptionPane.showMessageDialog(frame, "原密码错误,请重新输入");
                    }

                } catch (ClassNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }

        });


        JButton b_reset = new JButton("重置");
        b_reset.setFont(font);
        b_reset.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                t_oldPassword.setText("");
                t_newPassword.setText("");
            }

        });

        this.add(l_oldPassword);
        this.add(t_oldPassword);

        this.add(l_newPassword);
        this.add(t_newPassword);

        this.add(b_modify);
        this.add(b_reset);
    }
}
