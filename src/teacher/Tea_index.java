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
		setTitle("��ʦ��ҳ��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("�װ���"+Const.tename+"����ӭ��½��ϵͳ��");
		lblNewLabel.setBounds(10, 10, 247, 15);
		contentPane.add(lblNewLabel);

		JLabel label = new JLabel("��ѡ���������еĲ�����");
		label.setBounds(10, 44, 200, 15);
		contentPane.add(label);

		JButton button = new JButton("����ɼ�");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tea_index.this.setVisible(false);
				Tea_True_insert.main(null);
			}
		});
		button.setBounds(25, 107, 93, 23);
		contentPane.add(button);
		JButton button3 = new JButton("��ӿγ�");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tea_index.this.setVisible(false);
				Tea_insertcourse.main(null);
			}
		});
		button3.setBounds(25, 177, 93, 23);
		contentPane.add(button3);

		JButton button_1 = new JButton("�޸ĳɼ�");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tea_index.this.setVisible(false);
				Tea_update.main(null);
			}
		});
		button_1.setBounds(164, 107, 93, 23);
		contentPane.add(button_1);

		JButton button_2 = new JButton("��ѯ�ɼ�");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tea_index.this.setVisible(false);
				Tea_select.main(null);
			}
		});
		button_2.setBounds(293, 107, 93, 23);
		contentPane.add(button_2);

		JButton button_3 = new JButton("�˳���¼");
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
