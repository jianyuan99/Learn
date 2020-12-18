import bean.User;
import impl.UserImpl;
import org.junit.Test;

/**
 * @ClassName TestUser
 * @Description 测试User
 * @Author Huangbiao
 * @Date 2020-12-12 19:35
 * @Version V1.0
 */
public class TestUser {
    @Test
    public void test(){
        User user = new User();
        user.setId("nuc");
        user.setName("java作业");
        user.setPw("123456");
        user.setRegisterTime("2020/12/12");
        UserImpl userImpl = new UserImpl();
        userImpl.insert(user);

    }
}
