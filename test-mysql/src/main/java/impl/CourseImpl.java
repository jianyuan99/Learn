package impl;

import bean.Course;
import connt.Connt;
import dao.CourseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName CourseImpl
 * @Description 课程信息访问实现
 * @Author Huangbiao
 * @Date 2020-12-10 0:02
 * @Version V1.0
 */
public class CourseImpl implements CourseDao {
    @Override
    public boolean insert(Course course) {
        Connection connection = Connt.getConnection();

        String sql = "INSERT INTO course(id,name,pid,credit) VALUES(?,?,?,?)";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,course.getId());
            pst.setString(2,course.getCname());
            pst.setString(3,course.getPid());
            pst.setString(4,course.getCredit());

            pst.executeUpdate();
            pst.close();
            System.out.println("插入成功！");
            return true;
        } catch (SQLException throwables) {
            System.out.println("插入失败！");
            throwables.printStackTrace();
        }finally {
            Connt.closeConnection(connection);
        }
        return false;
    }

    @Override
    public boolean delCourseId(String id) {
        Connection connection = Connt.getConnection();

        String sql = "DELETE FROM course WHERE id = ?";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,id);

            pst.executeUpdate();
            pst.close();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Connt.closeConnection(connection);
        }
        return false;
    }

    @Override
    public boolean delCourseName(String name) {
        Connection connection = Connt.getConnection();

        String sql = "DELETE FROM course WHERE name = ?";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1,name);
            pst.executeUpdate();
            pst.close();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Connt.closeConnection(connection);
        }
        return false;
    }

    @Override
    public boolean delCourse(Course course) {
        Connection connection = Connt.getConnection();

        String sql = "DELETE FROM course WHERE id = ?";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1,course.getId());
            pst.executeUpdate();
            pst.close();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Connt.closeConnection(connection);
        }
        return false;
    }

    @Override
    public boolean update(Course course) {
        Connection connection = Connt.getConnection();

        String sql = "UPDATE course SET id = ?, name = ?, pid = ?, credit = ? WHERE id = ?";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,course.getId());
            pst.setString(2,course.getCname());
            pst.setString(3,course.getPid());
            pst.setString(4,course.getCredit());
            pst.setString(5,course.getId());

            pst.executeUpdate();
            pst.close();
            return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Connt.closeConnection(connection);
        }
        return false;
    }

    @Override
    public Course findCourseId(String id) {
        Connection connection = Connt.getConnection();

        Course course = new Course();

        String sql = "SELECT* FROM course WHERE id = ?";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,id);
            ResultSet rs = pst.executeQuery();

//            System.out.println(rs);
            while (rs.next()) {
                course.setId(rs.getString("id"));
                course.setCname(rs.getString("name"));
                course.setPid(rs.getString("pid"));
                course.setCredit(rs.getString("credit"));
            }
            System.out.println("查询成功！");
            pst.close();
            return course;
        } catch (SQLException throwables) {
            System.out.println("查询失败！");
            throwables.printStackTrace();

        }finally {
            Connt.closeConnection(connection);
        }
        return null;
    }

    @Override
    public Course findCourseName(String name) {
        Connection connection = Connt.getConnection();
        Course course = new Course();
        String sql = "SELECT * FROM course WHERE name = ?";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,name);
            ResultSet rs = pst.executeQuery();


            course.setId(rs.getString("id"));
            course.setCname(rs.getString("name"));
            course.setPid(rs.getString("pid"));
            course.setCredit(rs.getString("credit"));
            pst.close();
            return course;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Connt.closeConnection(connection);
        }
        return null;
    }

    @Override
    public List<Course> findCourseDept(String deptId) {
        Connection connection = Connt.getConnection();
        List<Course> courses = new ArrayList<>();

        String sql = "SELECT* FROM course WHERE pid = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,deptId);

            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                Course course = new Course();
                course.setId(rs.getString("id"));
                course.setCname(rs.getString("name"));
                course.setPid(rs.getString("pid"));
                course.setCredit(rs.getString("credit"));

                courses.add(course);
            }
            pst.close();
            return courses;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Connt.closeConnection(connection);
        }
        return null;
    }

    @Override
    public List<Course> findCourseCredit(String credit) {
        Connection connection = Connt.getConnection();
        List<Course> courses = new ArrayList<>();

        String sql = "SELECT* FROM course WHERE credit = ?";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,credit);
            ResultSet rs = pst.executeQuery();


            while (rs.next()){
                Course course = new Course();
                course.setId(rs.getString("id"));
                course.setCname(rs.getString("name"));
                course.setPid(rs.getString("pid"));
                course.setCredit(rs.getString("credit"));

                courses.add(course);
            }
            pst.close();
            return courses;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Connt.closeConnection(connection);
        }
        return null;
    }
}
