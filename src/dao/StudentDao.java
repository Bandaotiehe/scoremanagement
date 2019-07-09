package dao;

import model.Course;
import tools.JdbcUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentDao {


    private JdbcUtils jdbcUtils;

    public StudentDao() {
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

    public Map<String, Object> getStudentInfomation(String stuId) {
        String sql = "select * from stu_introduction where id=?";

      Map<String, Object> list = null;
        List<Object> params = new ArrayList<>();
        params.add(stuId);
        try {
            list = jdbcUtils.findSimpleResult(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }



    public Map<String, Object> getStupwdByid(String stuId) {
        String sql = "select * from student_account where number=?";

        Map<String, Object> list = null;
        List<Object> params = new ArrayList<>();
        params.add(stuId);
        try {
            list = jdbcUtils.findSimpleResult(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }



    public  boolean updateStuinfo(String phonenumber,String houseaddress, String birthday, String id)
    {
        boolean flag=false;
        String sql = "UPDATE stu_introduction SET phonenumber=? ,houseaddress=?,birthday=? WHERE id=?";
        List<Object> params = new ArrayList<>();
        params.add(phonenumber);
        params.add(houseaddress);
        params.add(birthday);
        params.add(id);
        try {
            flag = jdbcUtils.updateByPreparedStatement(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public  boolean insertChooseCorse(Course course,int classnum,String sclass)
    {
        classnum--;
        boolean flag=false;
        String sql = "INSERT INTO `test`.`stu_select` (\n" +
                "  `sid`,\n" +
                "  `sname`,\n" +
                "  `cid`,\n" +
                "  `course`,\n" +
                "  `result`,\n" +
                "  `college`,\n" +
                "  `teaid`,\n" +
                "  `sclass`\n" +
                ")\n" +
                "VALUES\n" +
                "  (\n" +
                "    ?,\n" +
                "    ?,\n" +
                "   ?,\n" +
                "   ?,\n" +
                "   ?,\n" +
                "   ?,\n" +
                "   ?,\n" +
                "    ?\n" +
                "  );";
        List<Object> params = new ArrayList<>();
        params.add(course.getSid());
        params.add(course.getSname());
        params.add(course.getCid());
        params.add(course.getCourse());
        params.add(course.getResult());
        params.add(course.getCollege());
        params.add(course.getTeaid());
        params.add(sclass);
        String sql1= "UPDATE  course SET classNum =? WHERE classId =?";
        List<Object> params1 = new ArrayList<>();
        params1.add(String.valueOf(classnum) );
        params1.add(course.getCid());
        try {
            if(jdbcUtils.updateByPreparedStatement(sql,params))
            {
                if( jdbcUtils.updateByPreparedStatement(sql1,params1))
                {
                    flag=true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public  boolean ChackPassword(String pwd,String id)
    {
        boolean flag=false;
        String sql = "update student_account set password=? where number=?";
        String sql1 = "update student_account set password=? where number=?";
        List<Object> params = new ArrayList<>();
        params.add(pwd);
        params.add(id);
        try {
            flag = jdbcUtils.updateByPreparedStatement(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public List<Map<String, Object>> getAllStudentScore(String stuId) {
        String sql = "select * from stu_select where sid=?";

      List<Map<String, Object>>   list = null;
        List<Object> params = new ArrayList<>();
        params.add(stuId);
        try {
            list = jdbcUtils.findModeResult(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
