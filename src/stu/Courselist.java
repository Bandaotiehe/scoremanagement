package stu;

import javax.swing.*;
import java.sql.*;
import java.util.Vector;

public class Courselist {
    public static Vector getRows(){
        String sql_url = "jdbc:mysql://localhost:3306/scoremanagement";
        String name = "root";
        String password = "123";
        Connection conn;
        PreparedStatement preparedStatement = null;

        Vector rows = null;
        Vector columnHeads = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");		//��������
            conn = DriverManager.getConnection(sql_url, name, password);	//�������ݿ�

            preparedStatement = conn.prepareStatement("select * from course");
            ResultSet result1 = preparedStatement.executeQuery();

            if(result1.wasNull())
                JOptionPane.showMessageDialog(null, "��������޼�¼");

            rows = new Vector();

            ResultSetMetaData rsmd = result1.getMetaData();

            while(result1.next()){
                rows.addElement(getNextRow(result1,rsmd));
            }

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("δ�ɹ�����������");
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("δ�ɹ������ݿ⡣");
            e.printStackTrace();
        }
        return rows;
    }

    // �õ����ݿ��ͷ
    public static Vector getHead(){
        String sql_url = "jdbc:mysql://localhost:3306/scoremanagement";
        String name = "root";
        String password = "123";
        Connection conn;
        PreparedStatement preparedStatement = null;

        Vector columnHeads = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(sql_url, name, password);
            preparedStatement = conn.prepareStatement("select * from course");
            ResultSet result1 = preparedStatement.executeQuery();

            boolean moreRecords = result1.next();
            if(!moreRecords)
                JOptionPane.showMessageDialog(null, "��������޼�¼");

            columnHeads = new Vector();
            ResultSetMetaData rsmd = result1.getMetaData();
            for(int i = 1; i <= rsmd.getColumnCount(); i++)
                columnHeads.addElement(rsmd.getColumnName(i));

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("δ�ɹ�����������");
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("δ�ɹ������ݿ⡣");
            e.printStackTrace();
        }
        return columnHeads;
    }

    // �õ����ݿ�����һ������
    private static Vector getNextRow(ResultSet rs,ResultSetMetaData rsmd) throws SQLException{
        Vector currentRow = new Vector();
        for(int i = 1; i <= rsmd.getColumnCount(); i++){
            currentRow.addElement(rs.getString(i));
        }
        return currentRow;
    }

	/*//������
	 public static void main(String[] args){
		 getRows();
	}*/
}
