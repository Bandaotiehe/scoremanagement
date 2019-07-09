package dao;
import tools.JdbcUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class TeacherDao {
    private JdbcUtils jdbcUtils;
    public TeacherDao() {
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
    public Map<String, Object> getCourseResultBytSname(String sname,String course) {
        String sql = "SELECT  result FROM stu_select WHERE sname=? and course=?";
        Map<String, Object>   list = null;
        List<Object> params = new ArrayList<>();
        params.add(sname);
        params.add(course);
        try {
            list = jdbcUtils.findSimpleResult(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Map<String, Object> getBytTid(String sname,String course) {
        String sql = "SELECT  result FROM stu_select WHERE sname=? and course=?";
        Map<String, Object>   list = null;
        List<Object> params = new ArrayList<>();
        params.add(sname);
        params.add(course);
        try {
            list = jdbcUtils.findSimpleResult(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Map<String, Object>> getStuCourseSnamebyTid(String tid) {
        String sql = "SELECT DISTINCT sname  FROM stu_select  WHERE teaid=? ";

        List<Map<String, Object>>   list = null;
        List<Object> params = new ArrayList<>();
        params.add(tid);
        try {
            list = jdbcUtils.findModeResult(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<Map<String, Object>> getStuCourseBytid(String tid) {
        String sql = "SELECT DISTINCT course FROM stu_select  WHERE teaid=? ";

        List<Map<String, Object>>   list = null;
        List<Object> params = new ArrayList<>();
        params.add(tid);
        try {
            list = jdbcUtils.findModeResult(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public List<Map<String, Object>> getStuCourseinfo(String tid) {
        String sql = "SELECT sname ,course FROM stu_select  WHERE teaid=? ";

        List<Map<String, Object>>   list = null;
        List<Object> params = new ArrayList<>();
        params.add(tid);
        try {
            list = jdbcUtils.findModeResult(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Map<String, Object>> getclassByTid(String tid)  {
        String sql = "SELECT DISTINCT sclass FROM stu_select WHERE teaid=?";

        List<Map<String, Object>>   list = null;
        List<Object> params = new ArrayList<>();
        params.add(tid);
        try {
            list = jdbcUtils.findModeResult(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Map<String, Object>> getCourseAndSclassByTid(String tid)  {
        String sql = "SELECT course,sclass FROM stu_select WHERE teaid=?";

        List<Map<String, Object>>   list = null;
        List<Object> params = new ArrayList<>();
        params.add(tid);
        try {
            list = jdbcUtils.findModeResult(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public List<Map<String, Object>> getAllScourseByCourse(String course,String tid )  {
        String sql = "SELECT sid,sname,course,result  FROM stu_select WHERE course=? and teaid=? ";

        List<Map<String, Object>>   list = null;
        List<Object> params = new ArrayList<>();
        params.add(course);
        params.add(tid);
        try {
            list = jdbcUtils.findModeResult(sql,params);
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
    public  boolean updateCourse(String result,String sname, String course)
    {
        boolean flag=false;
        String sql = "UPDATE stu_select  SET result=?  WHERE sname=? AND course=?";
        List<Object> params = new ArrayList<>();
        params.add(result);
        params.add(sname);
        params.add(course);
        try {
            flag = jdbcUtils.updateByPreparedStatement(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public List<Map<String, Object>> getAllScourseByCourseAndSclass(String course, String sclass,String tid) {


        String sql = "SELECT sid,sname,course,result  FROM stu_select WHERE course=? and sclass=? AND teaid=?";

        List<Map<String, Object>>   list = null;
        List<Object> params = new ArrayList<>();
        params.add(course);
        params.add(sclass);
        params.add(tid);
        try {
            list = jdbcUtils.findModeResult(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Map<String, Object>> getAllMaxScourseByCourse(String course, String teaid) {
        String sql = "SELECT * FROM stu_select WHERE result IN ( SELECT MAX(result) FROM stu_select WHERE  course=? AND teaid=?) and course=?";

        List<Map<String, Object>>   list = null;
        List<Object> params = new ArrayList<>();
        params.add(course);
        params.add(teaid);
        params.add(course);
        try {
            list = jdbcUtils.findModeResult(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Map<String, Object>> getAllMinScourseByCourse(String course, String teaid) {
        String sql = "SELECT * FROM stu_select WHERE result IN ( SELECT MIN(result) FROM stu_select WHERE  course=? AND teaid=?) and course=? ";

        List<Map<String, Object>>   list = null;
        List<Object> params = new ArrayList<>();
        params.add(course);
        params.add(teaid);
        params.add(course);
        try {
            list = jdbcUtils.findModeResult(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Map<String, Object> getTeacherInfomation(String tid) {
        String sql = "select * from teacher where id=?";

        Map<String, Object> list = null;
        List<Object> params = new ArrayList<>();
        params.add(tid);
        try {
            list = jdbcUtils.findSimpleResult(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Map<String, Object> getTeacherpwdByid(String tid) {
        String sql = "select * from teacher_account where tid=?";

        Map<String, Object> list = null;
        List<Object> params = new ArrayList<>();
        params.add(tid);
        try {
            list = jdbcUtils.findSimpleResult(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
