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
            Class.forName("com.mysql.jdbc.Driver");		//连接驱动
            conn = DriverManager.getConnection(sql_url, name, password);	//连接数据库

            preparedStatement = conn.prepareStatement("select * from course");
            ResultSet result1 = preparedStatement.executeQuery();

            if(result1.wasNull())
                JOptionPane.showMessageDialog(null, "结果集中无记录");

            rows = new Vector();

            ResultSetMetaData rsmd = result1.getMetaData();

            while(result1.next()){
                rows.addElement(getNextRow(result1,rsmd));
            }

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("未成功加载驱动。");
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("未成功打开数据库。");
            e.printStackTrace();
        }
        return rows;
    }

    // 得到数据库表头
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
                JOptionPane.showMessageDialog(null, "结果集中无记录");

            columnHeads = new Vector();
            ResultSetMetaData rsmd = result1.getMetaData();
            for(int i = 1; i <= rsmd.getColumnCount(); i++)
                columnHeads.addElement(rsmd.getColumnName(i));

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("未成功加载驱动。");
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("未成功打开数据库。");
            e.printStackTrace();
        }
        return columnHeads;
    }

    // 得到数据库中下一行数据
    private static Vector getNextRow(ResultSet rs,ResultSetMetaData rsmd) throws SQLException{
        Vector currentRow = new Vector();
        for(int i = 1; i <= rsmd.getColumnCount(); i++){
            currentRow.addElement(rs.getString(i));
        }
        return currentRow;
    }

	/*//主函数
	 public static void main(String[] args){
		 getRows();
	}*/
}
