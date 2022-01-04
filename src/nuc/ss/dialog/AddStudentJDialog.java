package nuc.ss.dialog;
/**
 * @author 娄靖彬，王志凯
 * @description 添加宿舍管理员对话框
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import nuc.ss.controller.SystemController_StudentManage_Controller;
import nuc.ss.domain.Student;

public class AddStudentJDialog extends JDialog {

    private JLabel l_id, l_name, l_password, l_sex, l_dormitoryId, l_phoneNumber, l_grade, l_bed, l_apartmentId;
    private JTextField t_id, t_name, t_password, t_dormitoryId, t_phoneNumber, t_grade, t_bed, t_apartmentId;
    private JRadioButton r_male, r_female;
    private JButton b_add, b_reset;
    Frame frame;


    public AddStudentJDialog(Frame frame, String title, boolean modal) {
        //super(frame, title, modal);
        this.setTitle("添加学生信息");
        this.setSize(500, 450);
        this.setLocationRelativeTo(null);
        init();
        this.setVisible(true);
    }


    public void init() {
        this.setLayout(new GridLayout(10, 2, 5, 5));

        l_id = new JLabel("学号", JLabel.CENTER);
        l_name = new JLabel("姓名", JLabel.CENTER);
        l_password = new JLabel("密码", JLabel.CENTER);
        l_sex = new JLabel("性别", JLabel.CENTER);
        l_dormitoryId = new JLabel("宿舍楼号", JLabel.CENTER);
        l_phoneNumber = new JLabel("联系电话", JLabel.CENTER);
        l_grade = new JLabel("年级", JLabel.CENTER);
        l_bed = new JLabel("床位", JLabel.CENTER);
        l_apartmentId = new JLabel("宿舍号", JLabel.CENTER);

        t_id = new JTextField();
        t_name = new JTextField();
        t_password = new JTextField();
        t_dormitoryId = new JTextField();
        t_phoneNumber = new JTextField();
        t_grade = new JTextField();
        t_bed = new JTextField();
        t_apartmentId = new JTextField();

        Font font = new Font("TimesNewRoman", Font.BOLD, 20);
        l_id.setFont(font);
        l_name.setFont(font);
        l_password.setFont(font);
        l_sex.setFont(font);
        l_dormitoryId.setFont(font);
        l_phoneNumber.setFont(font);
        l_grade.setFont(font);
        l_bed.setFont(font);
        l_apartmentId.setFont(font);

        t_id.setFont(font);
        t_name.setFont(font);
        t_password.setFont(font);
        t_dormitoryId.setFont(font);
        t_phoneNumber.setFont(font);
        t_grade.setFont(font);
        t_bed.setFont(font);
        t_apartmentId.setFont(font);


        ButtonGroup bg = new ButtonGroup();
        r_male = new JRadioButton("男");
        r_female = new JRadioButton("女");
        r_male.setFont(font);
        r_female.setFont(font);
        bg.add(r_male);
        bg.add(r_female);
        JPanel p = new JPanel();
        p.add(r_male);
        p.add(r_female);


        b_add = new JButton("添加");
        b_add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                boolean flag = addStudent();
                if (flag == true) {
                    JOptionPane.showMessageDialog(frame, "添加成功，请点击查询按钮刷新表格");
                    dispose();

                } else {
                    JOptionPane.showMessageDialog(frame, "添加失败");
                }
            }

        });
        b_add.setFont(font);

        b_reset = new JButton("重置");
        b_reset.setFont(font);
        b_reset.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                t_id.setText("");
                t_name.setText("");
                t_password.setText("");
                t_dormitoryId.setText("");
                t_phoneNumber.setText("");
                t_bed.setText("");
                t_apartmentId.setText("");
                t_grade.setText("");
            }


        });

        this.add(l_id);
        this.add(t_id);

        this.add(l_name);
        this.add(t_name);

        this.add(l_password);
        this.add(t_password);


        this.add(l_sex);
        this.add(p);

        this.add(l_dormitoryId);
        this.add(t_dormitoryId);

        this.add(l_phoneNumber);
        this.add(t_phoneNumber);

        this.add(l_grade);
        this.add(t_grade);

        this.add(l_bed);
        this.add(t_bed);

        this.add(l_apartmentId);
        this.add(t_apartmentId);

        this.add(b_add);
        this.add(b_reset);

    }

    public boolean addStudent() {
        String id = t_id.getText();
        String name = t_name.getText();
        String password = t_password.getText();
        String dormitoryId = t_dormitoryId.getText();
        String phoneNumber = t_phoneNumber.getText();
        int bed = Integer.parseInt(t_bed.getText());
        String grade = t_grade.getText();
        String apartmentId = t_apartmentId.getText();

        char sex;
        if (r_male.isSelected()) {
            sex = '男';
        } else {
            sex = '女';
        }
        Student student = new Student(grade, id, name, password, sex, dormitoryId, apartmentId, bed, phoneNumber);
        try {
            SystemController_StudentManage_Controller.addStudent(student);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }
}
