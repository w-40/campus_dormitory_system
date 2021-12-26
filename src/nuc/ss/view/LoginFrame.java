package nuc.ss.view;
/**
 * @author 韩思远，王志凯
 * @description 登录界面
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Toolkit;

public class LoginFrame {

	private JFrame frame;
	private JTextField usernameField;
	private JTextField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame window = new LoginFrame();
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
	public LoginFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		//frame.setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("images/宿舍图片.jpg")));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(("images/宿舍图片.jpg")));
		frame.setTitle("校园宿舍管理系统——登录页面");
		frame.setBounds(100, 100, 878, 672);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ButtonGroup bg = new ButtonGroup();
		JRadioButton r_3 = new JRadioButton("系统管理员");
		r_3.setForeground(new Color(0, 255, 255));
		r_3.setBackground(null);
		r_3.setFont(new Font("楷体", Font.PLAIN, 25));
		r_3.setBounds(259, 428, 177, 29);
		r_3.setBorder(null);//取消边框
		r_3.setContentAreaFilled(false);//设置按钮透明
		
		JRadioButton r_1 = new JRadioButton("宿舍管理员");
		r_1.setForeground(new Color(0, 255, 255));
		r_1.setBackground(new Color(224, 255, 255));
		r_1.setFont(new Font("楷体", Font.PLAIN, 25));
		r_1.setBounds(451, 428, 177, 29);
		r_1.setBorder(null);//取消边框
		r_1.setContentAreaFilled(false);//设置按钮透明
		
		JRadioButton r_2 = new JRadioButton("学生");
		r_2.setForeground(new Color(0, 255, 255));
		r_2.setBackground(new Color(224, 255, 255));
		r_2.setFont(new Font("楷体", Font.PLAIN, 25));
		r_2.setBounds(643, 428, 97, 29);
		r_2.setBorder(null);//取消边框
		r_2.setContentAreaFilled(false);//设置按钮透明
		bg.add(r_3);
		bg.add(r_2);
		bg.add(r_1);
		
		usernameField = new JTextField();
		usernameField.setBounds(296, 179, 381, 63);
		usernameField.setColumns(10);
		usernameField.setFont(new Font("楷体", Font.BOLD, 30));
		
		passwordField = new JTextField();
		passwordField.setBounds(296, 302, 381, 63);
		passwordField.setColumns(10);
		passwordField.setFont(new Font("楷体", Font.BOLD, 30));
		
		JLabel L_2 = new JLabel("密码");
		L_2.setForeground(new Color(255, 255, 255));
		L_2.setFont(new Font("隶书", Font.PLAIN, 30));
		L_2.setBounds(120, 289, 81, 81);
		//L_2.setIcon(new ImageIcon(LoginFrame.class.getResource("images/密码.png")));
		L_2.setIcon(new ImageIcon(("images/密码.png")));

		JLabel L_1 = new JLabel("账号");
		L_1.setForeground(new Color(255, 255, 255));
		L_1.setFont(new Font("隶书", Font.PLAIN, 30));
		L_1.setBounds(120, 166, 81, 81);
		//L_1.setIcon(new ImageIcon(LoginFrame.class.getResource("images/账号密码 (4).png")));
		L_1.setIcon(new ImageIcon(("images/账号密码 (4).png")));
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(L_2);
		frame.getContentPane().add(L_1);
		frame.getContentPane().add(r_1);
		frame.getContentPane().add(r_2);
		frame.getContentPane().add(passwordField);
		frame.getContentPane().add(usernameField);
		frame.getContentPane().add(r_3);
		
		JLabel L_3 = new JLabel("身份");
		L_3.setForeground(new Color(255, 255, 255));
		L_3.setFont(new Font("隶书", Font.PLAIN, 30));
		//L_3.setIcon(new ImageIcon(LoginFrame.class.getResource("images/账号密码管理.png")));
		L_3.setIcon(new ImageIcon(("images/账号密码管理.png")));
		L_3.setBounds(120, 400, 81, 81);
		frame.getContentPane().add(L_3);
		
		JButton button = new JButton("登录");
		button.setIcon(null);
		button.setBackground(new Color(152, 251, 152));
		button.setFont(new Font("楷体", Font.PLAIN, 35));
		button.setForeground(new Color(75, 0, 130));
		button.setBounds(366, 507, 154, 56);
		frame.getContentPane().add(button);
		
		JLabel L_0 = new JLabel("欢迎来到校园宿舍管理系统！");
		L_0.setForeground(new Color(0, 0, 139));
		L_0.setFont(new Font("隶书", Font.PLAIN, 42));
		L_0.setBounds(198, 45, 557, 63);
		frame.getContentPane().add(L_0);
		
		JLabel L_bg = new JLabel("");
		//L_bg.setIcon(new ImageIcon(LoginFrame.class.getResource("images/MWD$5ASB4]%BN`K%4AY7XO7.jpg")));
		L_bg.setIcon(new ImageIcon(("images/背景图片.jpg")));
		L_bg.setBounds(0, 0, 856, 616);
		frame.getContentPane().add(L_bg);
	}
}