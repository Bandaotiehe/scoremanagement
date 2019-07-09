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

public class Tea_insertcourse extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	TeacherDao teatchDao=new TeacherDao();
	CommDao commDao=new CommDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tea_insertcourse frame = new Tea_insertcourse();
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
	public Tea_insertcourse() {
		setTitle("学生成绩输入界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("课程名称:");
		label.setBounds(32, 25, 112, 15);
		contentPane.add(label);

		JLabel label_1 = new JLabel("课程人数:");
		label_1.setBounds(32, 73, 98, 15);
		contentPane.add(label_1);

		textField = new JTextField();
		textField.setBounds(238, 22, 157, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(238, 70, 157, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel label_2 = new JLabel("学院:");
		label_2.setBounds(32, 124, 98, 15);
		contentPane.add(label_2);
		JComboBox comboBox = new JComboBox();
		List<Map<String, Object>> list=		commDao.getcollege();
		for (Map<String, Object> item:list)
		{
			comboBox.addItem(item.get("insName"));
		}
		comboBox.setEditable(false);
		comboBox.setBounds(238, 121, 157, 21);
		contentPane.add(comboBox);
		JButton button = new JButton("提交");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String className=textField.getText();
				String classNum=textField_1.getText();
				String coolege=(String)comboBox.getSelectedItem();
		//	String teaId="00001";
                String teaId= Const.teaid;
               if(  teatchDao.insterCourse( className, classNum,coolege,teaId))
			   {
				   Component jPanel = null;
				   JOptionPane.showMessageDialog(jPanel, "添加成功！", "添加课程",JOptionPane.WARNING_MESSAGE);
			   }
               else
			   {
				   Component jPanel = null;
				   JOptionPane.showMessageDialog(jPanel, "添加失败！", "添加课程",JOptionPane.WARNING_MESSAGE);
			   }
			}
		});
		button.setBounds(315, 284, 93, 23);
		contentPane.add(button);

		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tea_insertcourse.this.setVisible(false);
				Tea_index.main(null);
			}
		});
		button_1.setBounds(418, 284, 93, 23);
		contentPane.add(button_1);
	}
}
