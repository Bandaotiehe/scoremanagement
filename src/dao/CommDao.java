package dao;
import tools.JdbcUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class CommDao {

    private JdbcUtils jdbcUtils;
    public CommDao() {
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
        System.out.println(this.getClass().toString() + "œ˙ªŸ¡À");
    }
    public List<Map<String, Object>> getcollege() {
        String sql = "SELECT insName FROM institution";

        List<Map<String, Object>>   list = null;
        List<Object> params = new ArrayList<>();
        //params.add(tid);
        try {
            list = jdbcUtils.findModeResult(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<Map<String, Object>> getCourseAndSclassByTid(String tid) {
        String sql = "SELECT course,sclass FROM stu_select WHERE teaid=?";

        List<Map<String, Object>>   list = null;
        List<Object> params = new ArrayList<>();
        //params.add(tid);
        try {
            list = jdbcUtils.findModeResult(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public Map<String, Object> getclassesBySname(String snama) {
        String sql = "SELECT classes FROM stu_introduction WHERE name=?";

      Map<String, Object>   list = null;
        List<Object> params = new ArrayList<>();
        params.add(snama);
        try {
            list = jdbcUtils.findSimpleResult(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public  boolean insterCourse(String className,String classNum, String coolege, String teaId)
    {
        boolean flag=false;
        String sql = "INSERT INTO course (className,classNum,teaId,college) VALUES(?,?,?,?)";
        List<Object> params = new ArrayList<>();
        params.add(className);
        params.add(classNum);
        params.add(teaId);
        params.add(coolege);
        try {
            flag = jdbcUtils.updateByPreparedStatement(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
