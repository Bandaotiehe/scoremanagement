package teacher;

import dao.TeacherDao;
import model.Const;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;
import java.util.Map;

public class Tea_update extends JFrame {

    private JPanel contentPane;
    private JTextField textField_2;
    private JComboBox jComboBox_courseName;
    TeacherDao teatchDao = new TeacherDao();


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Tea_update frame = new Tea_update();
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
    public Tea_update() {
        setTitle("修改学生成绩界面");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label = new JLabel("请输入学生姓名");
        label.setBounds(21, 22, 179, 15);
        contentPane.add(label);

        JComboBox comboBox = new JComboBox();
        jComboBox_courseName = new JComboBox();
        jComboBox_courseName.setEditable(true);
        jComboBox_courseName.setBounds(121, 63, 159, 21);
        contentPane.add(jComboBox_courseName);
        List<Map<String, Object>> list = teatchDao.getStuCourseSnamebyTid(Const.teaid);
        List<Map<String, Object>> list1 = teatchDao.getStuCourseBytid(Const.teaid);
        for (Map<String, Object> item : list) {
            comboBox.addItem(item.get("sname"));
           // jComboBox_courseName.addItem(item.get("course"));
        }
        for (Map<String, Object> item : list1) {
            //comboBox.addItem(item.get("sname"));
            jComboBox_courseName.addItem(item.get("course"));
        }
        comboBox.setBounds(121, 22, 179, 21);
        contentPane.add(comboBox);
        jComboBox_courseName.setBounds(161, 63, 159, 21);
        contentPane.add(jComboBox_courseName);
        JLabel label_1 = new JLabel("请输入学生课程名称");
        label_1.setBounds(21, 66, 179, 15);
        contentPane.add(label_1);

        JLabel label_2 = new JLabel("请输入学生成绩");
        label_2.setBounds(21, 105, 166, 15);
        contentPane.add(label_2);

        textField_2 = new JTextField();
        textField_2.setBounds(210, 102, 110, 21);
        contentPane.add(textField_2);
        textField_2.setColumns(10);
        try {
            String sname = comboBox.getSelectedItem().toString();
            String courseName = jComboBox_courseName.getSelectedItem().toString();
            String teaId = Const.teaid;
            textField_2.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    //得到焦点
                    textField_2.setText(teatchDao.getCourseResultBytSname(sname, courseName).get("result").toString());
                }

                @Override
                public void focusLost(FocusEvent e) {
                    //失去焦点
                }
            });
            JButton button = new JButton("提交");
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (teatchDao.updateCourse(textField_2.getText(), sname, courseName)) {
                        Component jPanel = null;
                        JOptionPane.showMessageDialog(jPanel, "修改成功！", "修改成绩", JOptionPane.WARNING_MESSAGE);
                    } else {
                        Component jPanel = null;
                        JOptionPane.showMessageDialog(jPanel, "修改失败！", "修改成绩", JOptionPane.WARNING_MESSAGE);
                    }
                }
            });
            button.setBounds(172, 187, 93, 23);
            contentPane.add(button);
        } catch (Exception ex) {
            Component jPanel = null;
            JOptionPane.showMessageDialog(jPanel, "当前没有可修改的成绩！", "修改成绩", JOptionPane.WARNING_MESSAGE);
            Tea_update.this.setVisible(false);
            Tea_index.main(null);
        }


        JButton btnNewButton = new JButton("返回");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Tea_update.this.setVisible(false);
                Tea_index.main(null);
            }
        });
        btnNewButton.setBounds(275, 187, 93, 23);
        contentPane.add(btnNewButton);
    }

}
