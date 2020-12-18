package connt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connt {
    /**
     * 数据库驱动程序
     */
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    /**
     * 数据库地址
     */
    private static String url = "jdbc:mysql://localhost/studentinfo?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=UTF-8";
    /**
     * 数据库用户名
     */
    private static String user = "root";
    /**
     * 数据库密码
     */
    private static String pw = "1275274783biao";

    /**
     * 私有化构造方法，拒绝实例化
     */
    private Connt(){}

    /**
     * @Author Huangbiao
     * @Description 获取mysql数据库连接
     * @Date 13:32 2020-12-09
     * @param
     * @return java.sql.Connection
     */
    public static Connection getConnection(){

        //定义数据库连接
        Connection cont = null;
        try {
            //安装数据库驱动
            Class.forName(DRIVER);
            //获取数据库连接
            cont = DriverManager.getConnection(url, user, pw);
            System.out.println("连接成功");
        } catch (ClassNotFoundException e) {
            //数据库驱动安装失败
            System.out.println("连接失败！"+ e.getMessage());
            e.printStackTrace();
        } catch (SQLException throwables) {
            //获取数据库连接失败
            System.out.println("连接失败！"+ throwables.getMessage());
            throwables.printStackTrace();
        }

        return cont;
    }

    /**
     * @Author Huangbiao
     * @Description 关闭mysql数据库连接
     * @Date 22:47 2020-12-09
     * @param cont
     * @return void
     */
    public static void closeConnection(Connection cont){

        if(cont!=null){
            try {
                //判读连接是否关闭
                if(!cont.isClosed()){
                    cont.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
