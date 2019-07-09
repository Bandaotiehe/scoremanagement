package teacher;

import main.Window;
import model.Const;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tea_index extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tea_index frame = new Tea_index();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tea_index() {
		setTitle("教师主页面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("亲爱的"+Const.tename+"，欢迎登陆本系统：");
		lblNewLabel.setBounds(10, 10, 247, 15);
		contentPane.add(lblNewLabel);

		JLabel label = new JLabel("请选择您将进行的操作：");
		label.setBounds(10, 44, 200, 15);
		contentPane.add(label);

		JButton button = new JButton("输入成绩");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tea_index.this.setVisible(false);
				Tea_True_insert.main(null);
			}
		});
		button.setBounds(25, 107, 93, 23);
		contentPane.add(button);
		JButton button3 = new JButton("添加课程");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tea_index.this.setVisible(false);
				Tea_insertcourse.main(null);
			}
		});
		button3.setBounds(25, 177, 93, 23);
		contentPane.add(button3);

		JButton button_1 = new JButton("修改成绩");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tea_index.this.setVisible(false);
				Tea_update.main(null);
			}
		});
		button_1.setBounds(164, 107, 93, 23);
		contentPane.add(button_1);

		JButton button_2 = new JButton("查询成绩");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tea_index.this.setVisible(false);
				Tea_select.main(null);
			}
		});
		button_2.setBounds(293, 107, 93, 23);
		contentPane.add(button_2);

		JButton button_3 = new JButton("退出登录");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Const.teaid="";
				Const.tename="";
				Tea_index.this.setVisible(false);
				Window.main(null);
			}
		});
		button_3.setBounds(293, 204, 93, 23);
		contentPane.add(button_3);
	}
}
