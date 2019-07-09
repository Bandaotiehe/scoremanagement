package stu;

import dao.CommDao;
import dao.StudentDao;
import model.Const;
import model.Course;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class ChooseCourse extends JFrame{

    DefaultTableModel tableModel;		// Ĭ����ʾ�ı��
    JButton add,del,exit,save;		// ������ť
    JTable table;		// ���

    JPanel panelUP;	//������Ϣ�����
    StudentDao studentDao=new StudentDao();
    CommDao commDao=new CommDao();
    // ���캯��
    public ChooseCourse(){
        this.setBounds(300, 200, 600, 450);		// ���ô����С
        this.setTitle("ѡ��");		// ���ô�������
        this.setLayout(new BorderLayout());	// ���ô���Ĳ��ַ�ʽ
        save = new JButton("����");
        exit = new JButton("�˳�");

        panelUP = new JPanel();		// �½���ť������
        panelUP.setLayout(new FlowLayout(FlowLayout.LEFT));	// �������Ĳ��ַ�ʽ

        // ������ť���������ӵ������
        //panelUP.add(add);
        //panelUP.add(del);
        panelUP.add(save);
        panelUP.add(exit);

        // ȡ��haha���ݿ��aa��ĸ�������
        Vector rowData = Courselist.getRows();
        // ȡ��haha���ݿ��aa��ı�ͷ����
        Vector columnNames = Courselist.getHead();


        // �½����
        tableModel = new DefaultTableModel(rowData,columnNames);
        table = new JTable(tableModel);

        JScrollPane s = new JScrollPane(table);

        // �����ͱ��ֱ���ӵ�������
        this.add(panelUP,BorderLayout.NORTH);
        this.add(s);

        // �¼�����
        MyEvent();

        this.setVisible(true);		// ��ʾ����
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		 // ���ô���ɹر�
    }

    // �¼�����
    public void MyEvent(){
        save.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Course course= new Course();
                course.setSid(Const.id);
                course.setSname(Const.stuname);
                int index = table.getSelectedRow();
                int column = table.getColumnCount();
                course.setCid(table.getValueAt(index,0).toString());
                course.setCourse(table.getValueAt(index,1).toString());
                int  classnum=Integer.valueOf(table.getValueAt(index,2).toString()) ;
                course.setTeaid(table.getValueAt(index,3).toString());
                course.setCollege(table.getValueAt(index,4).toString());
                String sclass=commDao.getclassesBySname(course.getSname()).get("classes").toString();
                course.setResult("0");
                if(studentDao.getStudentInfomation(Const.id).get("college").equals(course.getCollege()))
                {
                    if(classnum<=0)
                    {
                        Component jPanel = null;
                        JOptionPane.showMessageDialog(jPanel, "�Ŀγ��Ѿ�ѡ���ˣ�", "���棡", JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                        if (studentDao.insertChooseCorse(course, classnum,sclass)) {
                            Component jPanel = null;
                            JOptionPane.showMessageDialog(jPanel, "ѡ��ɹ���", "���棡", JOptionPane.WARNING_MESSAGE);
                        } else {
                            Component jPanel = null;
                            JOptionPane.showMessageDialog(jPanel, "���Ѿ�ѡ�����ſγ��ˣ�", "���棡", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
                else
                {
                    Component jPanel = null;
                    JOptionPane.showMessageDialog(jPanel, "�㲻�����ѧԺ�ģ�", "���棡", JOptionPane.WARNING_MESSAGE);
                }


            }
        });

        // �˳�
        exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ChooseCourse.this.setVisible(false);
                Stu_index.main(null);
            }

        });
    }

    // ������
    public static void main(String[] args){
        new ChooseCourse();
    }
}
