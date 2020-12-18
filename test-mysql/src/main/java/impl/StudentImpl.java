package impl;

import bean.Student;
import connt.Connt;
import dao.StudentDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName StudentImpl
 * @Description 学生信息访问实现
 * @Author Huangbiao
 * @Date 2020-12-10 0:03
 * @Version V1.0
 */
public class StudentImpl implements StudentDao {
    @Override
    public boolean insert(Student student) {
        Connection connection = Connt.getConnection();
        String sql = "INSERT INTO student(id,name,sex,age,dept) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,student.getId());
            pst.setString(2,student.getName());
            pst.setString(3,student.getSex());
            pst.setString(4,student.getAge());
            pst.setString(5,student.getDept());

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
    public boolean delStudent(Student student) {
        Connection connection = Connt.getConnection();

        String sql = "DELETE FROM student WHERE name = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,student.getName());
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
    public boolean delStudentId(String id) {
        Connection connection = Connt.getConnection();
        String sql = "DELETE FROM student WHERE id = ?";
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
    public boolean delStudentDept(String dept) {
        Connection connection = Connt.getConnection();
        String sql = "DELETE FROM student WHERE dept = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,dept);
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
    public boolean update(Student student) {
        Connection connection = Connt.getConnection();
        String sql = "UPDATE student SET id = ?,name = ?,sex = ?, age = ?, dept = ? WHERE id = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,student.getId());
            pst.setString(2,student.getName());
            pst.setString(3,student.getSex());
            pst.setString(4,student.getAge());
            pst.setString(5,student.getDept());
            pst.setString(6,student.getId());
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
    public Student findStudentId(String id) {
        Connection connection = Connt.getConnection();
        String sql = "SELECT * FROM student WHERE id = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,id);
            ResultSet rst = pst.executeQuery();

            Student student = new Student();
            while (rst.next()) {
                student.setId(rst.getString("id"));
                student.setName(rst.getString("name"));
                student.setSex(rst.getString("sex"));
                student.setAge(rst.getString("age"));
                student.setDept(rst.getString("dept"));

            }
            pst.close();
            return student;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Connt.closeConnection(connection);
        }
        return null;
    }

    @Override
    public List<Student> findStudentName(String name) {
        Connection connection = Connt.getConnection();
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM student WHERE name = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,name);
            ResultSet rst = pst.executeQuery();

            while (rst.next()) {
                Student student = new Student();
                student.setId(rst.getString("id"));
                student.setName(rst.getString("name"));
                student.setSex(rst.getString("sex"));
                student.setAge(rst.getString("age"));
                student.setDept(rst.getString("dept"));
                students.add(student);
            }
            pst.close();
            return students;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Connt.closeConnection(connection);
        }
        return null;
    }

    @Override
    public List<Student> findStudentDept(String dept) {
        Connection connection = Connt.getConnection();
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM student WHERE dept = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,dept);
            ResultSet rst = pst.executeQuery();

            while (rst.next()) {
                Student student = new Student();
                student.setId(rst.getString("id"));
                student.setName(rst.getString("name"));
                student.setSex(rst.getString("sex"));
                student.setAge(rst.getString("age"));
                student.setDept(rst.getString("dept"));
                students.add(student);
            }
            pst.close();
            return students;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Connt.closeConnection(connection);
        }
        return null;
    }

    @Override
    public List<Student> findAllStudent() {
        Connection connection = Connt.getConnection();
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM student";
        try {
            Statement statement = connection.createStatement();
            ResultSet rst = statement.executeQuery(sql);
            while (rst.next()) {
                Student student = new Student();
                student.setId(rst.getString("id"));
                student.setName(rst.getString("name"));
                student.setSex(rst.getString("sex"));
                student.setAge(rst.getString("age"));
                student.setDept(rst.getString("dept"));
                students.add(student);
            }
            return students;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Connt.closeConnection(connection);
        }
        return null;
    }
}
