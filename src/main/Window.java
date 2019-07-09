package main;

import admin.Admin_log;
import teacher.Tea_log;
import tools.Verification;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {

	private JPanel contentPane;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Window() {
		setTitle("学生成绩管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 436);


		JPanel contentPane = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon ii = new ImageIcon("1.jpg");
				g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
			}
		};
		getContentPane().add(contentPane);
		contentPane.setLayout(null);
		JLabel label = new JLabel("学生成绩管理系统");
		label.setBounds(261, 29, 260, 48);
		label.setFont(new Font("隶书", Font.PLAIN, 23));
		contentPane.add(label);

		JLabel label_1 = new JLabel("请选择您的身份");
		label_1.setBounds(288, 97, 126, 27);
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		contentPane.add(label_1);

		JButton btnNewButton_1 = new JButton("教师");
		btnNewButton_1.setIcon(new ImageIcon("teacher.png"));
		btnNewButton_1.setBounds(288, 197, 135, 35);

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Window.this.setVisible(false);
				Tea_log.main(null);
			}
		});
		contentPane.add(btnNewButton_1);

		JButton button_2 = new JButton("学生");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window.this.setVisible(false);
				Verification.main(null);
			}
		});
		button_2.setIcon(new ImageIcon("Student.png"));
		button_2.setBounds(83, 197, 135, 35);
		contentPane.add(button_2);

		JButton button_3 = new JButton("管理员");
		button_3.setIcon(new ImageIcon("admim.png"));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window.this.setVisible(false);
				Admin_log.main(null);
			}
		});
		button_3.setBounds(488, 197, 135, 35);
		contentPane.add(button_3);

		JLabel label_2 = new JLabel("");
		label_2.setBounds(330, 373, 54, 15);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("维护人：张庆波");
		label_3.setBounds(309, 359, 93, 15);
		contentPane.add(label_3);

	}
}
