package admin;

import dao.AdminDao;
import dao.CommDao;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class Admin_stu extends JFrame {

	private JPanel contentPane;
	private JTextField textField_id;
	private JTextField textField_sname;
	private JTextField textField_class;
	private JTextField textField_sex;
	private JTextField textField_deleteid;
	CommDao commDao=new CommDao();
	AdminDao adminDao=new AdminDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_stu frame = new Admin_stu();
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
	public Admin_stu() {
		setTitle("管理员学生操作");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblid = new JLabel("添加学生学号");
		lblid.setBounds(39, 47, 129, 21);
		contentPane.add(lblid);

		textField_id = new JTextField();
		textField_id.setBounds(183, 44, 151, 27);
		contentPane.add(textField_id);
		textField_id.setColumns(10);


		JLabel label = new JLabel("姓名：");
		label.setBounds(39, 82, 129, 21);
		contentPane.add(label);
		textField_sname = new JTextField();
		textField_sname.setBounds(183, 82, 151, 27);
		contentPane.add(textField_sname);
		textField_sname.setColumns(10);

		JLabel label_1 = new JLabel("性别：");
		label_1.setBounds(39, 122, 129, 21);
		contentPane.add(label_1);
		textField_sex = new JTextField();
		textField_sex.setBounds(183, 122, 151, 27);
		contentPane.add(textField_sex);
		textField_sex.setColumns(10);

		JLabel label_2 = new JLabel("学院:");
		label_2.setBounds(39, 164, 98, 15);
		contentPane.add(label_2);
		JComboBox comboBox = new JComboBox();
		List<Map<String, Object>> list=		commDao.getcollege();
		for (Map<String, Object> item:list)
		{
			comboBox.addItem(item.get("insName"));
		}
		comboBox.setEditable(false);
		comboBox.setBounds(183, 164, 151, 27);
		contentPane.add(comboBox);

		JLabel label_3 = new JLabel("班级：");
		label_3.setBounds(39, 214, 98, 15);
		contentPane.add(label_3);
		textField_class = new JTextField();
		textField_class.setBounds(183, 214, 151, 21);
		contentPane.add(textField_class);
		textField_class.setColumns(10);

		JButton button = new JButton("确定添加");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sid=textField_id.getText();
				String sname=textField_sname.getText();
				String sclass=textField_class.getText();
				String college=comboBox.getSelectedItem().toString() ;
				String sex=textField_sex.getText();
				String pwd="000000";//默认密码
				if(adminDao.insterStu(sid,sname,college,sex,sclass,pwd))
				{

					Component jPanel = null;
					JOptionPane.showMessageDialog(jPanel, "添加成功！", "",JOptionPane.WARNING_MESSAGE);
				}
				else{
					Component jPanel = null;
					JOptionPane.showMessageDialog(jPanel, "添加失败！学生已存在", "",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		button.setBounds(183, 304, 140, 29);
		contentPane.add(button);

		JLabel lblid_1 = new JLabel("删除学生id");
		lblid_1.setBounds(39, 254, 98, 15);
		contentPane.add(lblid_1);

		textField_deleteid = new JTextField();
		textField_deleteid.setBounds(183, 254, 151, 21);
		contentPane.add(textField_deleteid);
		textField_deleteid.setColumns(10);

		JButton button_1 = new JButton("确定删除");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(adminDao.deleteStuByTid(textField_deleteid.getText()))
				{

					Component jPanel = null;
					JOptionPane.showMessageDialog(jPanel, "删除成功！", "",JOptionPane.WARNING_MESSAGE);
				}
				else{
					Component jPanel = null;
					JOptionPane.showMessageDialog(jPanel, "删除失败！学生不存在", "",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		button_1.setBounds(400, 254, 140, 29);
		contentPane.add(button_1);

		JButton button_2 = new JButton("返回");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_stu.this.setVisible(false);
				Admin_index.main(null);
			}
		});
		button_2.setBounds(400, 304, 140, 29);
		contentPane.add(button_2);
	}

}
