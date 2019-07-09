package stu;

import dao.StudentDao;
import model.Const;
import tools.Verification;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class Stu_uppass extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
    private JPasswordField passwordField_2;
    private StudentDao   studentDao =new StudentDao();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stu_uppass frame = new Stu_uppass();
					frame.setSize(600,400);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Stu_uppass() {
		setTitle("学生修改密码窗口");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel(Const.stuname+"同学，你好");
		lblNewLabel.setBounds(15, 15, 174, 21);
		contentPane.add(lblNewLabel);

		JLabel label = new JLabel("请输入原密码");
		label.setFont(new Font("宋体", Font.PLAIN, 24));
		label.setBounds(66, 69, 189, 34);
		contentPane.add(label);

		JLabel label_1 = new JLabel("请输入新密码");
		label_1.setFont(new Font("宋体", Font.PLAIN, 24));
		label_1.setBounds(66, 149, 189, 34);
		contentPane.add(label_1);

        JLabel label_2 = new JLabel("确认新密码");
        label_2.setFont(new Font("宋体", Font.PLAIN, 24));
        label_2.setBounds(86, 220, 189, 34);
        contentPane.add(label_2);

		passwordField = new JPasswordField();
		passwordField.setBounds(270, 75, 183, 27);
		contentPane.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(266, 155, 187, 27);
		contentPane.add(passwordField_1);

        passwordField_2 = new JPasswordField();
        passwordField_2.setBounds(266, 230, 187, 27);
        contentPane.add(passwordField_2);

		JButton button = new JButton("确定更改");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=Const.stuname;
				String old_pass=passwordField.getText();
				String new_pass=passwordField_1.getText();
                String re_pass=passwordField_2.getText();
				try{

                 //   studentDao.getStupwdByid(Const.id);
                    //测试
                  Map<String,Object> map= studentDao.getStupwdByid(Const.id);
                    Component jPanel = null;
                    if(new_pass.equals(re_pass)) {


                        if (map.get("password").equals(old_pass)) {
                            if (studentDao.ChackPassword(new_pass, Const.id)) {
                                JOptionPane.showMessageDialog(jPanel, "修改成功！请您重新登陆！", "ok！", JOptionPane.WARNING_MESSAGE);

                                Stu_uppass.this.setVisible(false);
                                Verification.main(null);
                            } else {
                                JOptionPane.showMessageDialog(jPanel, "修改失败！", "警告！", JOptionPane.WARNING_MESSAGE);
                            }


                        } else {
                            JOptionPane.showMessageDialog(jPanel, "原密码错误！", "警告！", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(jPanel, "两次密码不一致！", "警告！", JOptionPane.WARNING_MESSAGE);
                    }

				}
				catch(Exception www){
					System.out.println(www);
				}
			}
		});
		button.setBounds(280, 280, 123, 29);
		contentPane.add(button);
		JButton button_1 = new JButton("退出");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stu_uppass.this.setVisible(false);
				Stu_index.main(null);
			}
		});
		button_1.setBounds(432, 280, 123, 29);
		contentPane.add(button_1);


	}
}
