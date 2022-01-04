package nuc.ss.dialog;
/**
 * @author hsystart
 * @create 2021-12-28 18:34
 */
import nuc.ss.controller.SystemController_DormManage_Controller;
import nuc.ss.domain.Dorm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AddDormJDialog extends JDialog {
    private JLabel l_id, l_dormitoryId, l_num;
    private JTextField t_id, t_dormitoryId, t_num;
    private JButton b_add, b_reset;
    Frame frame;


    public AddDormJDialog(Frame frame, String title, boolean modal) {
        //super(frame, title, modal);
        this.setTitle("添加宿舍信息");
        this.setSize(350, 450);
        this.setLocationRelativeTo(null);
        init();
        this.setVisible(true);
    }


    public void init() {
        this.setLayout(new GridLayout(4, 2, 5, 5));

        l_id = new JLabel("宿舍号", JLabel.CENTER);
        l_dormitoryId = new JLabel("宿舍楼号", JLabel.CENTER);
        l_num = new JLabel("宿舍人数", JLabel.CENTER);

        t_id = new JTextField();
        t_dormitoryId = new JTextField();
        t_num = new JTextField();

        Font font = new Font("TimesNewRoman", Font.BOLD, 20);
        l_id.setFont(font);
        l_dormitoryId.setFont(font);
        l_num.setFont(font);

        t_id.setFont(font);
        t_dormitoryId.setFont(font);
        t_num.setFont(font);

        b_add = new JButton("添加");
        b_add.setFont(font);
        b_add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                boolean flag = addHouseMaster();
                if (flag == true) {
                    JOptionPane.showMessageDialog(frame, "添加成功，请点击查询按钮刷新表格");
                    dispose();

                } else {
                    JOptionPane.showMessageDialog(frame, "添加失败");
                }
            }

        });

        b_reset = new JButton("重置");
        b_reset.setFont(font);
        b_reset.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                t_id.setText("");
                t_dormitoryId.setText("");
                t_num.setText("");
            }

        });

        this.add(l_id);
        this.add(t_id);

        this.add(l_dormitoryId);
        this.add(t_dormitoryId);

        this.add(l_num);
        this.add(t_num);

        this.add(b_add);
        this.add(b_reset);
    }

    public boolean addHouseMaster() {
        int id = Integer.parseInt(t_id.getText());
        String dormitoryId = t_dormitoryId.getText();
        int num = Integer.parseInt(t_num.getText());

        Dorm Dorm = new Dorm(id, dormitoryId, num);
        try {
            SystemController_DormManage_Controller.addDorm(Dorm);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }
}
