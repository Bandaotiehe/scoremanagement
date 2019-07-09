package admin;

import dao.AdminDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class Admin_log extends JFrame {

    JPanel contentPane = new JPanel() {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon ii = new ImageIcon("800.jpg");
            g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
        }
    };
    private JTextField textField;
    private JPasswordField passwordField;
    AdminDao adminDao = new AdminDao();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Admin_log frame = new Admin_log();
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
    public Admin_log() {
        setTitle("����Ա��¼");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        getContentPane().add(contentPane);
        contentPane.setLayout(null);

        JLabel label = new JLabel("����Ա�˺�");
        label.setBounds(71, 63, 85, 15);
        contentPane.add(label);

        textField = new JTextField();
        textField.setBounds(185, 60, 141, 21);
        contentPane.add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(185, 116, 141, 21);

        JLabel label_1 = new JLabel("����Ա����");
        label_1.setBounds(71, 119, 85, 15);
        contentPane.add(label_1);
        textField.setText("001");
        passwordField.setText("111111");
        JButton button = new JButton("��¼");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String Ad_no = textField.getText();
                String Ad_pa = passwordField.getText();
                if (Ad_no.equals("")) {
                    Component jPanel = null;
                    JOptionPane.showMessageDialog(jPanel, "���벻��Ϊ�գ�", "һ���ٷ��Ĵ���", JOptionPane.WARNING_MESSAGE);
                } else {
                    Map<String, Object> pwd = adminDao.getAdminpwdByid(Ad_no);
                    if (pwd.size() >0) {


                        if (pwd.get("Ad_pa").equals(Ad_pa)) {

                            Component jPanel = null;
                            JOptionPane.showMessageDialog(jPanel, "��¼�ɹ���", "��¼����", JOptionPane.WARNING_MESSAGE);

                            Admin_log.this.setVisible(false);
                            Admin_index.main(null);
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
        button.setBounds(233, 181, 93, 23);
        contentPane.add(button);
        contentPane.add(passwordField);
    }
}
