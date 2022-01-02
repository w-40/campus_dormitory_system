package nuc.ss.dialog;
/**
 * @author 籍乃博
 * @description 添加学生违纪信息对话框
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;

import javax.swing.*;

import nuc.ss.controller.HouseMasterManager_StudentViolatinOfDiscipline_Controller;
import nuc.ss.domain.StudentViolationOfDiscipline;

public class AddDisciplinaryInformationDialog extends JDialog {
    private JLabel l_id, l_content, l_time;
    private JTextField t_id, t_content, t_time;
    private JRadioButton r_male, r_female;
    private JButton b_add, b_reset;
    Frame frame;


    public AddDisciplinaryInformationDialog(Frame frame, String title, boolean modal) {
        //super(frame, title, modal);
        this.setTitle("添加违纪信息");
        this.setSize(550, 350);
        this.setLocationRelativeTo(null);
        init();
        this.setVisible(true);
    }

    public void init() {
        this.setLayout(new GridLayout(4, 2, 5, 5));

        l_id = new JLabel("学号", JLabel.CENTER);
        l_content = new JLabel("违纪内容", JLabel.CENTER);
        l_time = new JLabel("违纪时间", JLabel.CENTER);

        l_id.setFont(new Font("TimesNewRoman", Font.BOLD, 20));
        l_content.setFont(new Font("TimesNewRoman", Font.BOLD, 20));
        l_time.setFont(new Font("TimesNewRoman", Font.BOLD, 20));
        t_id = new JTextField();

        t_content = new JTextField();
        t_id.setFont(new Font("TimesNewRoman", Font.BOLD, 20));
        t_content.setFont(new Font("TimesNewRoman", Font.BOLD, 20));
        t_content.setText(String.valueOf(LocalDateTime.now()));
        t_content.setEditable(false);
        t_time = new JTextField();
        t_time.setFont(new Font("TimesNewRoman", Font.BOLD, 20));

        b_add = new JButton("添加");
        b_add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                boolean flag = addStudentViolationOfDiscipline();
                if (flag == true) {
                    JOptionPane.showMessageDialog(frame, "添加成功，请点击查询按钮刷新表格");
                    dispose();

                } else {
                    JOptionPane.showMessageDialog(frame, "添加失败");
                }
            }

        });

        b_reset = new JButton("重置");
        b_reset.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                t_id.setText("");
                t_content.setText("");
                t_time.setText("");

            }

        });

        this.add(l_id);
        this.add(t_id);

        this.add(l_content);
        this.add(t_content);

        this.add(l_time);
        this.add(t_time);

        this.add(b_add);
        this.add(b_reset);

    }

    public boolean addStudentViolationOfDiscipline() {
        String id = t_id.getText();
        String content = t_content.getText();
        String time = t_time.getText();

        StudentViolationOfDiscipline svod = new StudentViolationOfDiscipline(id, content, time);

        try {
            HouseMasterManager_StudentViolatinOfDiscipline_Controller.addHouseMaster(svod);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }
}
