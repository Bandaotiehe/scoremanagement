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

    DefaultTableModel tableModel;		// 默认显示的表格
    JButton add,del,exit,save;		// 各处理按钮
    JTable table;		// 表格

    JPanel panelUP;	//增加信息的面板
    StudentDao studentDao=new StudentDao();
    CommDao commDao=new CommDao();
    // 构造函数
    public ChooseCourse(){
        this.setBounds(300, 200, 600, 450);		// 设置窗体大小
        this.setTitle("选课");		// 设置窗体名称
        this.setLayout(new BorderLayout());	// 设置窗体的布局方式
        save = new JButton("保存");
        exit = new JButton("退出");

        panelUP = new JPanel();		// 新建按钮组件面板
        panelUP.setLayout(new FlowLayout(FlowLayout.LEFT));	// 设置面板的布局方式

        // 将各按钮组件依次添加到面板中
        //panelUP.add(add);
        //panelUP.add(del);
        panelUP.add(save);
        panelUP.add(exit);

        // 取得haha数据库的aa表的各行数据
        Vector rowData = Courselist.getRows();
        // 取得haha数据库的aa表的表头数据
        Vector columnNames = Courselist.getHead();


        // 新建表格
        tableModel = new DefaultTableModel(rowData,columnNames);
        table = new JTable(tableModel);

        JScrollPane s = new JScrollPane(table);

        // 将面板和表格分别添加到窗体中
        this.add(panelUP,BorderLayout.NORTH);
        this.add(s);

        // 事件处理
        MyEvent();

        this.setVisible(true);		// 显示窗体
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		 // 设置窗体可关闭
    }

    // 事件处理
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
                        JOptionPane.showMessageDialog(jPanel, "改课程已经选满了！", "警告！", JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                        if (studentDao.insertChooseCorse(course, classnum,sclass)) {
                            Component jPanel = null;
                            JOptionPane.showMessageDialog(jPanel, "选择成功！", "警告！", JOptionPane.WARNING_MESSAGE);
                        } else {
                            Component jPanel = null;
                            JOptionPane.showMessageDialog(jPanel, "你已经选过改门课程了！", "警告！", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
                else
                {
                    Component jPanel = null;
                    JOptionPane.showMessageDialog(jPanel, "你不是这个学院的！", "警告！", JOptionPane.WARNING_MESSAGE);
                }


            }
        });

        // 退出
        exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ChooseCourse.this.setVisible(false);
                Stu_index.main(null);
            }

        });
    }

    // 主函数
    public static void main(String[] args){
        new ChooseCourse();
    }
}
