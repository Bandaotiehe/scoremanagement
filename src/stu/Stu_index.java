package stu;
import dao.StudentDao;
import main.Window;
import model.Const;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class Stu_index extends JFrame {
	private JPanel contentPane;
	private JScrollPane jsp = null ;
    private StudentDao   studentDao =new StudentDao();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stu_index frame = new Stu_index();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Stu_index() {
		setTitle("学生个人信息窗口");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JTextArea txtDfdsfsd = new JTextArea();
		jsp = new JScrollPane(txtDfdsfsd, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp.setBounds(27, 79, 648, 116);
		jsp.setBorder(null);
		contentPane.add(jsp);
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(27, 247, 648, 51);
		String temp1=Const.id;
		//测试
		//String temp1="2016012744";
		if(Const.stuname.equals("")){
			JLabel lblNewLabel = new JLabel(Const.id+"同学，你好：");
			lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
			lblNewLabel.setBounds(27, 29, 188, 18);
			contentPane.add(lblNewLabel);
		}
		else{
			JLabel lblNewLabel = new JLabel(Const.stuname+"同学，你好：");
			lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
			lblNewLabel.setBounds(27, 29, 188, 18);
			contentPane.add(lblNewLabel);
		}
		JButton btnNewButton = new JButton("查看成绩");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argc) {
				String str="";
                  List<Map<String,Object>> list= studentDao.getAllStudentScore(temp1);
                  for (Map<String,Object> map:list)
				  {
					  str+="学生学号："+map.get("sid")+"    学生姓名："+map.get("sname")+"     课程号："+map.get("cid")+"    课程名称："+map.get("course")+"    分数："+ map.get("result") +"\n";
				  }
					if(!str.equals("")){
						txtDfdsfsd.setText(str);
					}
					else{
						Component jPanel = null;
						JOptionPane.showMessageDialog(jPanel, "同学不要着急，你的老师还没有录入成绩。", "一个弹出窗口",JOptionPane.WARNING_MESSAGE);
					}
				}
		});
		btnNewButton.setBounds(558, 27, 117, 23);
		contentPane.add(btnNewButton);
		JTextArea textArea = new JTextArea();
		textArea.setBounds(76, 103, 4, 24);
		contentPane.add(textArea);
		JButton btnNewButton_1 = new JButton("完善个人资料");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Stu_index.this.setVisible(false);
				Stu_information.main(null);
			}
		});
		btnNewButton_1.setBounds(403, 27, 140, 23);
		contentPane.add(btnNewButton_1);
		JButton button = new JButton("查看个人信息");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Map<String,Object> map= studentDao.getStudentInfomation(temp1);
				String str="";
					str+="学生学号："+map.get("id")+" 学生姓名："+map.get("name")+" 性别："+map.get("sex")+" 学院："+map.get("college")+" 班级："+map.get("classes")+"\n"+"电话:"+map.get("phonenumber")+"  家庭地址:"+map.get("houseaddress")+"   出生日期:"+map.get("birthday");
					textArea_1.setText(str);
					if(str.equals("")){
						Component jPanel = null;
						JOptionPane.showMessageDialog(jPanel, "同学还没有填写个人信息哦。", "一个弹出窗口",JOptionPane.WARNING_MESSAGE);
					}
				}
		});
		button.setBounds(27, 214, 117, 23);
		contentPane.add(button);


		contentPane.add(textArea_1);

		JButton btnNewButton_3 = new JButton("选课");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Stu_index.this.setVisible(false);
				ChooseCourse.main(null);
			}
		});
		btnNewButton_3.setBounds(157, 214, 117, 23);
		contentPane.add(btnNewButton_3);

		JButton button_1 = new JButton("退出");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//清除数据
				Const.id="";
				Stu_index.this.setVisible(false);
				Window.main(null);
			}
		});
		button_1.setBounds(582, 326, 93, 23);
		contentPane.add(button_1);

		JButton btnNewButton_2 = new JButton("修改密码");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stu_index.this.setVisible(false);
				Stu_uppass.main(null);
			}
		});
		btnNewButton_2.setBounds(265, 24, 123, 29);
		contentPane.add(btnNewButton_2);
	}
}
