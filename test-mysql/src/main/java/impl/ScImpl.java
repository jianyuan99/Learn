package impl;

import bean.Sc;
import connt.Connt;
import dao.ScDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ScImpl
 * @Description 学生成绩信息访问实现
 * @Author Huangbiao
 * @Date 2020-12-10 0:03
 * @Version V1.0
 */
public class ScImpl implements ScDao {
    @Override
    public boolean insert(Sc sc) {
        Connection connection = Connt.getConnection();

        String sql = "INSERT INTO sc(sno,cno,grade) VALUES(?,?,?)";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,sc.getSno());
            pst.setString(2,sc.getCno());
            pst.setString(3,sc.getGrade());

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
    public boolean delSc(Sc sc) {
        Connection connection = Connt.getConnection();

        String sql = "DELETE FROM sc WHERE sno = ?";
        try {
            PreparedStatement pst =  connection.prepareStatement(sql);
            pst.setString(1,sc.getSno());
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
    public boolean delScSno(String sno) {
        Connection connection = Connt.getConnection();

        String sql = "DELETE FROM sc WHERE sno = ?";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,sno);
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
    public boolean delScCno(String cno) {
        Connection connection = Connt.getConnection();

        String sql = "DELETE FROM sc WHERE cno = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,cno);
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
    public boolean update(Sc sc) {
        Connection connection = Connt.getConnection();

        String sql = "UPDATE sc SET sno = ?,cno = ?,grade = ? WHERE sno = ?";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,sc.getSno());
            pst.setString(2,sc.getCno());
            pst.setString(3,sc.getGrade());
            pst.setString(4,sc.getSno());

            pst.executeUpdate();
            pst.close();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public Sc findScSno(String sno) {
        Connection connection = Connt.getConnection();

        String sql = "SELECT* FROM sc WHERE sno = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,sno);
            ResultSet rst = pst.executeQuery();


            Sc sc = new Sc();
            sc.setSno(rst.getString("sno"));
            sc.setCno(rst.getString("cno"));
            sc.setGrade(rst.getString("grade"));
            pst.close();
            return sc;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Connt.closeConnection(connection);
        }
        return null;
    }

    @Override
    public List<Sc> findScCno(String cno) {
        Connection connection = Connt.getConnection();
        List<Sc> scs = new ArrayList<>();
        String sql = "SELECT* FROM sc WHERE cno = ?";

        try {
            PreparedStatement pst =  connection.prepareStatement(sql);
            pst.setString(1,cno);

            ResultSet rst = pst.executeQuery();

            while (rst.next()) {
                Sc sc = new Sc();
                sc.setSno(rst.getString("sno"));
                sc.setCno(rst.getString("cno"));
                sc.setGrade(rst.getString("grade"));
                scs.add(sc);
            }
            pst.close();
            return scs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Sc> findScGrade(String grade) {
        Connection connection = Connt.getConnection();
        List<Sc> scs = new ArrayList<>();
        String sql = "SELECT* FROM sc WHERE grade = ?";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,grade);
            ResultSet rst = pst.executeQuery();


            while (rst.next()){
                Sc sc = new Sc();
                sc.setSno(rst.getString("sno"));
                sc.setCno(rst.getString("cno"));
                sc.setGrade(rst.getString("grade"));
                scs.add(sc);
            }
            pst.close();
            return scs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Connt.closeConnection(connection);
        }
        return null;
    }
}
