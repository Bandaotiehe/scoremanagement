package teacher;

import dao.CommDao;
import dao.TeacherDao;
import model.Const;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class Tea_True_insert extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
   CommDao commDao=new CommDao();
    TeacherDao teacherDao=new TeacherDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tea_True_insert frame = new Tea_True_insert();
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
	public Tea_True_insert() {
		setTitle("学生成绩输入界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("学生姓名");
		label.setBounds(32, 25, 112, 15);
		contentPane.add(label);
		JComboBox comboBox = new JComboBox();
		List<Map<String, Object>> list=		teacherDao.getStuCourseSnamebyTid(Const.teaid);
		for (Map<String, Object> item:list)
		{
			comboBox.addItem(item.get("sname"));
		}
		comboBox.setEditable(false);
		comboBox.setBounds(122, 25, 157, 21);
		contentPane.add(comboBox);
		JLabel label_3 = new JLabel("课程名称");
		label_3.setBounds(32, 73, 98, 15);
		contentPane.add(label_3);
		JComboBox comboBox1 = new JComboBox();
		List<Map<String, Object>> list1=		teacherDao.getStuCourseBytid(Const.teaid);
		for (Map<String, Object> item:list1)
		{
			comboBox1.addItem(item.get("course"));
		}
		comboBox1.setEditable(false);
		comboBox1.setBounds(122, 73, 157, 21);
		contentPane.add(comboBox1);

		JLabel lblNewLabel = new JLabel("分数");
		lblNewLabel.setBounds(32, 123, 112, 15);
		contentPane.add(lblNewLabel);

		textField_4 = new JTextField();
		textField_4.setBounds(122, 123, 157, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		JButton button = new JButton("提交");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String stu_name = comboBox.getSelectedItem().toString();
				String course = comboBox1.getSelectedItem().toString();
				//String cou_id=textField_2.getText();
				//String con_name=textField_3.getText();

				String result = textField_4.getText();
				if (teacherDao.updateCourse(result, stu_name, course)) {
					Component jPanel = null;
					JOptionPane.showMessageDialog(jPanel, "添加成功！", "", JOptionPane.WARNING_MESSAGE);
				} else {
					Component jPanel = null;
					JOptionPane.showMessageDialog(jPanel, "添加失败！请稍后重试!", "", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		button.setBounds(315, 284, 93, 23);
		contentPane.add(button);

		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tea_True_insert.this.setVisible(false);
				Tea_index.main(null);
			}
		});
		button_1.setBounds(418, 284, 93, 23);
		contentPane.add(button_1);
	}
}
