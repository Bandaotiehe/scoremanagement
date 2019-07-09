package admin;

import main.Window;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin_index extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_index frame = new Admin_index();
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
	public Admin_index() {
		setTitle("管理员管理界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("管理员你好：");
		label.setBounds(20, 10, 93, 15);
		contentPane.add(label);

		JButton button = new JButton("教师操作");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_index.this.setVisible(false);
				Admin_tea.main(null);
			}
		});
		button.setBounds(20, 56, 93, 23);
		contentPane.add(button);

		JButton button_1 = new JButton("学生操作");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_index.this.setVisible(false);
				Admin_stu.main(null);
			}
		});
		button_1.setBounds(20, 133, 93, 23);
		contentPane.add(button_1);

		JButton button_2 = new JButton("返回");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_index.this.setVisible(false);
				Window.main(null);
			}
		});

		button_2.setBounds(274, 192, 93, 23);
		contentPane.add(button_2);
	}

}
