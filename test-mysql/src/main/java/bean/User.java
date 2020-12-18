package bean;

import java.util.Date;

/**
 * @ClassName User
 * @Description 用户
 * @Author Huangbiao
 * @Date 2020-12-09 22:39
 * @Version V1.0
 */
public class User {
    /**
     * 用户id
     */
    private String id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 用户密码
     */
    private String pw;
    /**
     * 用户注册时间
     */
    private String registerTime;

    public String  getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    @Override
    public String toString(){
        return null;
    }
}
