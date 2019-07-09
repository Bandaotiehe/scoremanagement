package tools;

import dao.StudentDao;
import model.Const;
import stu.Stu_index;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class Verification extends JFrame {

	JPanel contentPane = new JPanel() {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			ImageIcon ii = new ImageIcon("stu_log.jpg");
			g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
		}
	};
	public JTextField textField;
	private JPasswordField passwordField;
	String Real_number;
	StudentDao studentDao=new StudentDao();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Verification frame = new Verification();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Verification() {
		setTitle("ѧ����¼");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("ѧ��");
		label.setFont(new Font("����", Font.PLAIN, 18));
		label.setBounds(82, 54, 54, 15);
		contentPane.add(label);

		JLabel label_1 = new JLabel("����");
		label_1.setFont(new Font("����", Font.PLAIN, 18));
		label_1.setBounds(82, 107, 54, 15);
		contentPane.add(label_1);

		textField = new JTextField();
		textField.setBounds(146, 53, 175, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		JButton button = new JButton("��¼");
		button.addActionListener(new ActionListener() {



			public void actionPerformed(ActionEvent args) {
				String number_1 = textField.getText();
				String password_1 = passwordField.getText();
				if (number_1.equals("")) {
					Component jPanel = null;
					JOptionPane.showMessageDialog(jPanel, "���벻��Ϊ�գ�", "һ���ٷ��Ĵ���", JOptionPane.WARNING_MESSAGE);
				} else {

					Map<String, Object> map = studentDao.getStudentInfomation(number_1);
					if (map.size()>0) {
						Const.stuname = map.get("name").toString();
						if (studentDao.getStupwdByid(number_1).get("password").equals(password_1)) {
							Const.id = number_1;
							Component jPanel = null;
							JOptionPane.showMessageDialog(jPanel, "��¼�ɹ���", "��¼����", JOptionPane.WARNING_MESSAGE);

							Verification.this.setVisible(false);
							Stu_index.main(null);
						} else {
							Component jPanel = null;
							JOptionPane.showMessageDialog(jPanel, "�����˺Ż��������", "��¼����", JOptionPane.WARNING_MESSAGE);
						}
					} else {
						Component jPanel = null;
						JOptionPane.showMessageDialog(jPanel, "�����˺Ż��������", "��¼����", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		button.setBounds(228, 179, 93, 23);
		contentPane.add(button);
		passwordField = new JPasswordField();
		passwordField.setBounds(146, 106, 175, 21);
		contentPane.add(passwordField);
		textField.setText("16101028720");
		passwordField.setText("000000");
	}
}
