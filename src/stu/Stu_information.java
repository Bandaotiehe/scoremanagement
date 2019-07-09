package stu;

import dao.StudentDao;
import model.Const;
import model.Student;
import tools.Verification;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class Stu_information extends JFrame {
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_4;
    private JTextField textField_phonenumber;
    private JTextField textField_houseaddress;
    private JTextField textField_birthday;
    Student stu_in = new Student();
    StudentDao studentDao = new StudentDao();/*测试*/

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Stu_information frame = new Stu_information();
                    frame.setSize(600, 500);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Stu_information() {
        setTitle("学生个人信息");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JLabel label = new JLabel("姓名：");
        label.setBounds(47, 52, 54, 15);
        contentPane.add(label);
        textField = new JTextField();
        textField.setBounds(111, 49, 93, 21);
        contentPane.add(textField);
        textField.setColumns(10);
        JLabel label_1 = new JLabel("性别：");
        label_1.setBounds(229, 52, 54, 15);
        contentPane.add(label_1);
        textField_1 = new JTextField();
        textField_1.setBounds(305, 49, 66, 21);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        JLabel lblNewLabel = new JLabel("学号：");
        lblNewLabel.setBounds(47, 92, 54, 15);
        contentPane.add(lblNewLabel);
        textField_2 = new JTextField();
        textField_2.setBounds(111, 89, 105, 21);
        contentPane.add(textField_2);
        textField_2.setColumns(10);
        JLabel lblNewLabel_1 = new JLabel("学院：");
        lblNewLabel_1.setBounds(47, 135, 54, 15);
        contentPane.add(lblNewLabel_1);
        JLabel label_2 = new JLabel("班级：");
        label_2.setBounds(47, 177, 54, 15);
        contentPane.add(label_2);
        textField_4 = new JTextField();
        textField_4.setBounds(111, 177, 234, 21);
        contentPane.add(textField_4);
        textField_4.setColumns(10);
        JLabel label_3 = new JLabel("电话：");
        label_3.setBounds(47, 217, 54, 15);
        contentPane.add(label_3);
        textField_phonenumber = new JTextField();
        textField_phonenumber.setBounds(111, 217, 106, 21);
        contentPane.add(textField_phonenumber);
        textField_phonenumber.setColumns(10);
        JLabel label_4 = new JLabel("家庭地址：");
        label_4.setBounds(47, 257, 80, 15);
        contentPane.add(label_4);
        textField_houseaddress = new JTextField();
        textField_houseaddress.setBounds(111, 257, 234, 21);
        contentPane.add(textField_houseaddress);
        textField_houseaddress.setColumns(10);
        JLabel label_5 = new JLabel("出生日期：");
        label_5.setBounds(47, 297, 80, 15);
        contentPane.add(label_5);
        textField_birthday = new JTextField();
        textField_birthday.setBounds(111, 297, 234, 21);
        contentPane.add(textField_birthday);
        textField_birthday.setColumns(10);

     //   Const.id = "2016012744";

        Map<String, Object> map = studentDao.getStudentInfomation(Const.id);
        textField.setText(map.get("name").toString());
        textField.setEditable(false);
        textField_1.setText(map.get("sex").toString());
        textField_1.setEditable(false);
        textField_2.setText(map.get("id").toString());
        textField_2.setEditable(false);
        textField_4.setText(map.get("classes").toString());
        textField_4.setEditable(false);
        textField_phonenumber.setText(map.get("phonenumber").toString());
        textField_houseaddress.setText(map.get("houseaddress").toString());
        textField_birthday.setText(map.get("birthday").toString());
        /*String [] a = {"农学院","植保学院","园艺学院","动科学院","动医学院","林学院","风景园林学院","资环学院","水建学院","机电学院","信息工程学院","食品学院"};*/
        String[] a = {map.get("college").toString()};
        JComboBox comboBox = new JComboBox(a);
        comboBox.setEditable(false);/*textField_4*/
        JButton btnNewButton = new JButton("确认");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent args) {
                if (studentDao.updateStuinfo(textField_phonenumber.getText(), textField_houseaddress.getText(), textField_birthday.getText(), textField_2.getText())) {
                    Component jPanel = null;
                    JOptionPane.showMessageDialog(jPanel, "填写成功！重新登录生效！", "一个弹出窗口", JOptionPane.WARNING_MESSAGE);
                    Stu_information.this.setVisible(false);
                    Verification.main(null);
                } else {
                    Component jPanel = null;
                    JOptionPane.showMessageDialog(jPanel, "修改失败！", "警告！", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        btnNewButton.setBounds(282, 409, 93, 23);
        contentPane.add(btnNewButton);
        JButton button_1 = new JButton("退出");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Stu_information.this.setVisible(false);
                Stu_index.main(null);
            }
        });
        button_1.setBounds(402, 409, 93, 23);
        contentPane.add(button_1);
        JList list = new JList();
        list.setBounds(348, 163, -54, -30);
        contentPane.add(list);
        comboBox.setBounds(111, 132, 119, 21);
        contentPane.add(comboBox);
    }
}
