package main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

public class MyFrame extends JFrame{

    DefaultTableModel tableModel;		// Ĭ����ʾ�ı��
    JButton add,del,exit,save;		// ������ť
    JTable table;		// ���

    JPanel panelUP;	//������Ϣ�����

    // ���캯��
    public MyFrame(){
        this.setBounds(300, 200, 600, 450);		// ���ô����С
        this.setTitle("����");		// ���ô�������
        this.setLayout(new BorderLayout());	// ���ô���Ĳ��ַ�ʽ

        // �½�����ť���
        add = new JButton("����");
        del = new JButton("ɾ��");
        save = new JButton("����");
        exit = new JButton("�˳�");

        panelUP = new JPanel();		// �½���ť������
        panelUP.setLayout(new FlowLayout(FlowLayout.LEFT));	// �������Ĳ��ַ�ʽ

        // ������ť���������ӵ������
        panelUP.add(add);
        panelUP.add(del);
        panelUP.add(save);
        panelUP.add(exit);

        // ȡ��haha���ݿ��aa��ĸ�������
        Vector rowData = PutinStorage.getRows();
        // ȡ��haha���ݿ��aa��ı�ͷ����
        Vector columnNames = PutinStorage.getHead();


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

        // ����
        add.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // ����һ�пհ�����
                tableModel.addRow(new Vector());
            }

        });

        // ɾ��
        del.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                // ɾ��ָ����
                int rowcount = table.getSelectedRow();
                if(rowcount >= 0){
                    tableModel.removeRow(rowcount);
                }
            }

        });

        /**
         * ����
         * �ҵĽ���취��ֱ�ӽ�aa���е�ȫ������ɾ����
         * ������е��������ݻ�ȡ��,
         * Ȼ�󽫱����������д��aa��
         */
        save.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                int column = table.getColumnCount();		// �������
                int row = table.getRowCount();		// �������

                // value�����ű���е���������
                String[][] value = new String[row][column];

                for(int i = 0; i < row; i++){
                    for(int j = 0; j < column; j++){
                        value[i][j] = table.getValueAt(i, j).toString();
                    }
                }

                // ���¾�Ϊ�����ݿ�Ĳ���
                String sql_url = "jdbc:mysql://localhost:3306/haha";	//���ݿ�·����һ�㶼������д����haha�����ݿ�����
                String name = "root";		//�û���
                String password = "123456";	//����
                Connection conn;
                PreparedStatement preparedStatement = null;

                try {
                    Class.forName("com.mysql.jdbc.Driver");		//��������
                    conn = DriverManager.getConnection(sql_url, name, password);	//�������ݿ�
                    if(!conn.isClosed())
                        System.out.println("�ɹ��������ݿ�");

                    // ɾ��aa������������
                    preparedStatement = conn.prepareStatement("delete from aa where true");
                    preparedStatement.executeUpdate();

                    // ��value�����е��������δ�ŵ�aa����
                    for(int i = 0; i < row; i++){
                        preparedStatement = conn.prepareStatement("insert into aa values(" + Integer.parseInt(value[i][0]) + ",'" + value[i][1] + "')");
                        preparedStatement.executeUpdate();
                    }

                } catch (ClassNotFoundException e1) {
                    // TODO Auto-generated catch block
                    System.out.println("δ�ɹ�����������");
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    System.out.println("δ�ɹ������ݿ⡣");
                    e1.printStackTrace();
                }

                // ������˳�
                System.exit(0);
            }
        });

        // �˳�
        exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                System.exit(0);
            }

        });
    }

    // ������
    public static void main(String[] args){
        new MyFrame();
    }
}
