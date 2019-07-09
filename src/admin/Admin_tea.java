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

public class Admin_tea extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
     CommDao commDao=new CommDao();
     AdminDao adminDao=new AdminDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_tea frame = new Admin_tea();
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
	public Admin_tea() {
		setTitle("����Ա��ʦ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblid = new JLabel("����ɾ����ʦ��id");
		lblid.setBounds(51, 286, 179, 21);
		contentPane.add(lblid);

		JLabel lblid_1 = new JLabel("������ӽ�ʦ��id");
		lblid_1.setBounds(51, 40, 179, 21);
		contentPane.add(lblid_1);

		textField = new JTextField();
		textField.setBounds(245, 37, 164, 27);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel label = new JLabel("������ӽ�ʦ������");
		label.setBounds(51, 95, 197, 21);
		contentPane.add(label);

		textField_1 = new JTextField();
		textField_1.setBounds(245, 92, 164, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

        JLabel label_1 = new JLabel("�����ʦ��ѧԺ");
        label_1.setBounds(51, 141, 149, 21);
        contentPane.add(label_1);

        JComboBox comboBox = new JComboBox();
        List<Map<String, Object>> list=		commDao.getcollege();
        for (Map<String, Object> item:list)
        {
            comboBox.addItem(item.get("insName"));
        }
        comboBox.setEditable(false);
        comboBox.setBounds(245, 141, 157, 21);
        contentPane.add(comboBox);

		JButton button = new JButton("ȷ��");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
              String id=    textField.getText();
                String tname=textField_1.getText();
                String tcollege=comboBox.getSelectedItem().toString();
                String tpwd="000000";
			    if(adminDao.insterTea(id,tname,tcollege,tpwd))
                {
                    Component jPanel = null;
                    JOptionPane.showMessageDialog(jPanel, "��ӳɹ���", "һ���������ڣ�",JOptionPane.WARNING_MESSAGE);
                }
			    else
                {
                    Component jPanel = null;
                    JOptionPane.showMessageDialog(jPanel, "���ʧ�ܣ���ʦ�Ѵ���", "һ���������ڣ�",JOptionPane.WARNING_MESSAGE);
                }
			}
		});
		button.setBounds(205, 181, 123, 29);
		contentPane.add(button);

		textField_2 = new JTextField();
		textField_2.setBounds(245, 283, 164, 27);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JButton button_1 = new JButton("ȷ��");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tid=textField_2.getText();
				if(adminDao.deleteTeaByTid(tid))
                {
                    Component jPanel = null;
                    JOptionPane.showMessageDialog(jPanel, "ɾ���ɹ���", "",JOptionPane.WARNING_MESSAGE);
                }
				else
                {
                    Component jPanel = null;
                    JOptionPane.showMessageDialog(jPanel, "ɾ��ʧ�ܣ���ʦ������", "",JOptionPane.WARNING_MESSAGE);
                }
			}
		});
		button_1.setBounds(456, 282, 123, 29);
		contentPane.add(button_1);

		JButton btnNewButton = new JButton("����");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_tea.this.setVisible(false);
				Admin_index.main(null);
			}
		});
		btnNewButton.setBounds(456, 354, 123, 29);
		contentPane.add(btnNewButton);

	}
}
