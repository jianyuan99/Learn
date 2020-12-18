package impl;

import bean.User;
import connt.Connt;
import dao.UserDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserImpl
 * @Description 用户信息访问实现
 * @Author Huangbiao
 * @Date 2020-12-10 0:04
 * @Version V1.0
 */
public class UserImpl implements UserDao {

    @Override
    public boolean insert(User user) {
        Connection connection = Connt.getConnection();
        String sql = "INSERT INTO user(ID, NAME, PW, REGISTERTIME) VALUES(?,?,?,?)";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,user.getId());
            pst.setString(2,user.getName());
            pst.setString(3,user.getPw());
            pst.setString(4,user.getRegisterTime());
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
    public boolean delUser(User user) {
        Connection connection = Connt.getConnection();
        String sql = "DELETE FROM user WHERE id = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, user.getId());
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
    public boolean delUserId(String id) {
        Connection connection = Connt.getConnection();
        String sql = "DELETE FROM user WHERE id = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, id);
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
    public boolean update(User user) {
        Connection connection = Connt.getConnection();
        String sql = "UPDATE user SET id = ?, name = ?, pw = ?,registertime = ? WHERE id = ?";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, user.getId());
            pst.setString(2, user.getName());
            pst.setString(3, user.getPw());
            pst.setString(4, user.getRegisterTime());
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
    public User findUserId(String id) {
        Connection connection = Connt.getConnection();
        String sql = "SELECT * FROM user WHERE id = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,id);
            ResultSet rst = pst.executeQuery();


            User user = new User();
            user.setId(rst.getString("id"));
            user.setName(rst.getString("name"));
            user.setPw(rst.getString("pw"));
            user.setRegisterTime(rst.getString("registertime"));
            pst.close();
            return user;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Connt.closeConnection(connection);
        }
        return null;
    }

    @Override
    public List<User> findAllUser() {
        Connection connection = Connt.getConnection();
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM user";
        try {
            Statement statement = connection.createStatement();
            ResultSet rst = statement.executeQuery(sql);
            while (rst.next()) {
                User user = new User();
                user.setId(rst.getString("id"));
                user.setName(rst.getString("name"));
                user.setPw(rst.getString("pw"));
                user.setRegisterTime(rst.getString("registertime"));
                users.add(user);
            }
            return users;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Connt.closeConnection(connection);
        }
        return null;
    }
}
