package dao;

import bean.User;

import java.util.List;

/**
 * @ClassName UserDao
 * @Description 用户数据访问接口
 * @Author Huangbiao
 * @Date 2020-12-09 22:57
 * @Version V1.0
 */
public interface UserDao {
    boolean insert(User user);
    boolean delUser(User user);
    boolean delUserId(String id);
    boolean update(User user);
    User findUserId(String id);
    List<User> findAllUser();
}
