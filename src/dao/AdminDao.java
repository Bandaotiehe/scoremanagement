package dao;

import tools.JdbcUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AdminDao {

    private JdbcUtils jdbcUtils;

    public AdminDao() {
        jdbcUtils = new JdbcUtils();
        jdbcUtils.getConnection();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        if (jdbcUtils != null) {
            jdbcUtils.releaseConn();
            jdbcUtils = null;

        }
        System.out.println(this.getClass().toString() + "销毁了");
    }


    public boolean insterTea(String id, String name, String coolege,String pwd) {
        boolean flag = false;
        String sql = "INSERT INTO teacher (id,name,college) VALUES(?,?,?)";
        String sql2 = "INSERT INTO teacher_account (tid,tpassowrd) VALUES(?,?)";
        List<Object> params = new ArrayList<>();
        params.add(id);
        params.add(name);
        params.add(coolege);
        List<Object> params1 = new ArrayList<>();
        params1.add(id);
        params1.add(pwd);
        try {
            flag = jdbcUtils.updateByPreparedStatement(sql, params);
            flag = jdbcUtils.updateByPreparedStatement(sql2, params1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean insterStu(String id, String name, String college,String sex,String classes, String pwd) {
        boolean flag = false;
        String sql = "INSERT INTO stu_introduction (id,name,sex,college,classes) VALUES(?,?,?,?,?)";
        String sql2 = "INSERT INTO student_account (number,password) VALUES(?,?)";
        List<Object> params = new ArrayList<>();
        params.add(id);
        params.add(name);
        params.add(sex);
        params.add(college);
        params.add(classes);
        List<Object> params1 = new ArrayList<>();
        params1.add(id);
        params1.add(pwd);
        try {
            flag = jdbcUtils.updateByPreparedStatement(sql, params);
            flag = jdbcUtils.updateByPreparedStatement(sql2, params1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean deleteTeaByTid(String tid) {
        boolean flag = false;
        String sql = "DELETE FROM teacher_account WHERE tid =?";//删除账号
        String sql2 = "DELETE FROM teacher WHERE id =?";//删除信息
        String sql3="DELETE FROM course WHERE teaId =?";//课程信息
        List<Object> params = new ArrayList<>();
        params.add(tid);

        try {
            flag = jdbcUtils.updateByPreparedStatement(sql, params);
            flag = jdbcUtils.updateByPreparedStatement(sql2, params);
           jdbcUtils.updateByPreparedStatement(sql3, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
    public boolean deleteStuByTid(String sid) {
        boolean flag = false;
        String sql = "DELETE FROM student_account WHERE number=?";//删除账号
        String sql2 = "DELETE FROM stu_introduction WHERE id =?";//删除信息
        String sql3="DELETE FROM stu_select WHERE sid =?";//课程信息
        List<Object> params = new ArrayList<>();
        params.add(sid);

        try {
            flag = jdbcUtils.updateByPreparedStatement(sql, params);
            flag = jdbcUtils.updateByPreparedStatement(sql2, params);
            jdbcUtils.updateByPreparedStatement(sql3, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public Map<String, Object> getAdminpwdByid(String ad_no) {
        String sql = "select * from admin_information where ad_no=?";
        Map<String, Object> list = null;
        List<Object> params = new ArrayList<>();
        params.add(ad_no);
        try {
            list = jdbcUtils.findSimpleResult(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
