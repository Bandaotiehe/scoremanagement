package teacher;

import dao.TeacherDao;
import main.Window;
import model.Const;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class Tea_select extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JScrollPane jsp = null;
	private JScrollPane jsp2 = null;
   //  CommDao commDao=new CommDao();
	TeacherDao teacherDao=new TeacherDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tea_select frame = new Tea_select();
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
	public Tea_select() {
		setTitle("教师查询学生分数界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 473);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("输入所查科目名称");
		label.setBounds(29, 23, 112, 15);
		contentPane.add(label);

		JComboBox comboBox_course = new JComboBox();
		List<Map<String, Object>> list=		teacherDao.getStuCourseBytid(Const.teaid);
		for (Map<String, Object> item:list)
		{
			comboBox_course.addItem(item.get("course"));
		}
		comboBox_course.setEditable(true);
		comboBox_course.setBounds(151, 23, 135, 21);
		contentPane.add(comboBox_course);


		JTextArea textArea = new JTextArea();
//		textArea.setounds(29, 48, 542, 107);
		jsp = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp.setBounds(29, 48, 542, 107);
		jsp.setBorder(null);
		contentPane.add(jsp);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(29, 199, 542, 100);
		jsp2 = new JScrollPane(textArea_1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp2.setBounds(29, 199, 542, 100);
		jsp2.setBorder(null);
		contentPane.add(jsp2);



		JButton button = new JButton("查询所有学生");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				//String cname=textField.getText();
                 String course=comboBox_course.getSelectedItem().toString();
                 String str="";
			 List<Map<String, Object>> list = teacherDao.getAllScourseByCourse(course,Const.teaid);
			 for (Map<String, Object>map:list)
			 {
				 str+="学生号："+map.get("sid")+"     学生姓名："+map.get("sname")+"     课程名称："+map.get("course")+"    分数："+map.get("result")+"\n";
			 }
				textArea.setText(str);
			}
		});
		button.setBounds(430, 19, 141, 23);
		contentPane.add(button);

		JLabel label_1 = new JLabel("输入所查班级");
		label_1.setBounds(29, 165, 100, 15);
		contentPane.add(label_1);

		JComboBox comboBox_class = new JComboBox();
		List<Map<String, Object>> list1=		teacherDao.getclassByTid(Const.teaid);
		for (Map<String, Object> item:list1)
		{
			comboBox_class.addItem(item.get("sclass"));
		}
		comboBox_class.setEditable(true);
		comboBox_class.setBounds(118, 162, 150, 21);
		contentPane.add(comboBox_class);



		JLabel label_2 = new JLabel("输入课程名称");
		label_2.setBounds(239, 165, 94, 15);
		contentPane.add(label_2);


		JComboBox comboBox_course1 = new JComboBox();
	//	List<Map<String, Object>> list1=		teacherDao.getCourseAndSclassByTid(Const.teaid);
		for (Map<String, Object> item:list)
		{
			comboBox_course1.addItem(item.get("course"));
		}
	//	comboBox_classname1.addItem("fdjksaljf");
		comboBox_course1.setEditable(true);
		comboBox_course1.setBounds(337, 162, 141, 21);
		contentPane.add(comboBox_course1);



		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(29, 343, 542, 37);
		contentPane.add(textArea_2);

		JButton button_1 = new JButton("查询");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String course = comboBox_course1.getSelectedItem().toString();
				String sclass=comboBox_class.getSelectedItem().toString();
				String str = "";
				List<Map<String, Object>> list = teacherDao.getAllScourseByCourseAndSclass(course,sclass,Const.teaid);
				for (Map<String, Object> map : list) {
					str += "学号：" + map.get("sid") + "    学生姓名：" + map.get("sname") + "    课程名称：" + map.get("course") + "    分数：" + map.get("result") + "\n";
				}
				if(str=="")
				{
					textArea_1.setText("当前没有数据");
				}
				else
				{
					textArea_1.setText(str);
				}
			}
		});
		button_1.setBounds(488, 161, 83, 23);
		contentPane.add(button_1);

		JLabel label_3 = new JLabel("输入所查科目名称");
		label_3.setBounds(39, 309, 131, 15);
		contentPane.add(label_3);

		JComboBox comboBox_classname2 = new JComboBox();
		for (Map<String, Object> item:list)
		{
			comboBox_classname2.addItem(item.get("course"));
		}
		comboBox_classname2.setEditable(true);
		comboBox_classname2.setBounds(151, 306, 135, 21);
		contentPane.add(comboBox_classname2);



		JButton button_2 = new JButton("最高分");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

//String cname=textField.getText();
				String course=comboBox_course.getSelectedItem().toString();
				String str="";
				List<Map<String, Object>> list = teacherDao.getAllMaxScourseByCourse(course,Const.teaid);
				for (Map<String, Object>map:list)
				{
					str+="最高分  学号："+map.get("sid")+"     学生姓名："+map.get("sname")+"     课程名称："+map.get("course")+"    分数："+map.get("result")+"\n";
				}
				textArea_2.append(str);
			}
		});
		button_2.setBounds(352, 305, 93, 23);
		contentPane.add(button_2);
		JButton button_3 = new JButton("最低分");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String course=comboBox_course.getSelectedItem().toString();
				String str="";
				List<Map<String, Object>> list = teacherDao.getAllMinScourseByCourse(course,Const.teaid);
				for (Map<String, Object>map:list)
				{
					str+="最低分  学号："+map.get("sid")+"     学生姓名："+map.get("sname")+"     课程名称："+map.get("course")+"    分数："+map.get("result")+"\n";
				}
				textArea_2.append(str);
			}
		});
		button_3.setBounds(478, 305, 93, 23);
		contentPane.add(button_3);

		JButton btnNewButton = new JButton("退出系统");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Const.teaid="";
				Const.tename="";
				Tea_select.this.setVisible(false);
				Window.main(null);
			}
		});
		btnNewButton.setBounds(470, 390, 101, 23);
		contentPane.add(btnNewButton);
	}
}
