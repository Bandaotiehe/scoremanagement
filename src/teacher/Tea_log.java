package teacher;

import dao.TeacherDao;
import model.Const;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class Tea_log extends JFrame {

	JPanel contentPane = new JPanel() {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			ImageIcon ii = new ImageIcon("tea_log.jpg");
			g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
		}
	};
	private JTextField textField;
	private JPasswordField passwordField;
    TeacherDao teacherDao=new TeacherDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tea_log frame = new Tea_log();
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
	public Tea_log() {
		setTitle("教师登录界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 331);

		getContentPane().add(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("教工号：");
		label.setForeground(Color.ORANGE);
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(55, 58, 109, 27);
		contentPane.add(label);

		JLabel label_1 = new JLabel("教工密码：");
		label_1.setForeground(Color.ORANGE);
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		label_1.setBounds(55, 113, 109, 27);
		contentPane.add(label_1);

		textField = new JTextField();
		textField.setBounds(190, 63, 148, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(190, 118, 148, 21);
		contentPane.add(passwordField);
		textField.setText("116101028801");
		passwordField.setText("000000");
		JButton button = new JButton("登录");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number_1=textField.getText();
				String password_1=passwordField.getText();
				Const.teaid=number_1;
				if (number_1.equals("")) {
					Component jPanel = null;
					JOptionPane.showMessageDialog(jPanel, "输入不能为空！", "一个官方的窗口", JOptionPane.WARNING_MESSAGE);
				} else {

					Map<String, Object> map = teacherDao.getTeacherInfomation(number_1);
					if (map.size()>0) {
						Const.tename = map.get("name").toString();
						if (teacherDao.getTeacherpwdByid(number_1).get("tpassowrd").equals(password_1)) {
							Const.teaid = number_1;
							Component jPanel = null;
							JOptionPane.showMessageDialog(jPanel, "登录成功！", "登录窗口", JOptionPane.WARNING_MESSAGE);

							Tea_log.this.setVisible(false);
							Tea_index.main(null);
						} else {
							Component jPanel = null;
							JOptionPane.showMessageDialog(jPanel, "您的账号或密码错误！", "登录窗口", JOptionPane.WARNING_MESSAGE);
						}
					} else {
						Component jPanel = null;
						JOptionPane.showMessageDialog(jPanel, "您的账号或密码错误！", "登录窗口", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		button.setBounds(245, 175, 93, 23);
		contentPane.add(button);
	}
}
