/**
 * @ClassName Test
 * @Description 学生信息管理系统
 * @Author Huangbiao
 * @Date 2020-12-13 21:39
 * @Version V1.0
 */
import java.sql.*;
import java.util.Scanner;
import java.lang.String;
public class Test {
    public static void main(String[] args){
        Connection con = null;
        int flag;
        String url = "jdbc:mysql://localhost/studentinfo?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=UTF-8";
        String user = "root";
        String pw = "1275274783biao";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,user,pw);
            if(con == null)
                System.out.println("连接数据库失败");
            else if(con.isClosed())
                System.out.println("连接数据库失败");
            else
                System.out.println("连接数据库成功");
            Scanner input=new Scanner(System.in);
            while(true) {
                System.out.print("请输入你的操作(1:查询、2:增加记录、3:删除信息、其余表示退出)：");
                flag=input.nextInt();
                if(flag==1) {
                    Query(con,input);
                }else if(flag==2) {
                    Insert(con,input);
                }else if(flag==3) {
                    Delete(con,input);
                }else
                    break;
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
    public static void Delete(Connection con,Scanner input) {
        PreparedStatement sta=null;
        String sno=null;
        try {
            System.out.println("请输入要删除信息的学号：");
            sno=input.next();
            sta=con.prepareStatement("delete from student where sno=?");
            sta.setString(1, sno);
            if(sta.executeUpdate()==0) {
                System.out.println("删除失败！！！");
            }else {
                System.out.println("删除成功！！！");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("删除失败！！！");
        }

    }
    public static void Insert(Connection con,Scanner input) {
        String sno=null,sname=null,ssex=null,sclass=null,sdept=null;
        int sage=0;
        System.out.println("请输入学生信息：");
        System.out.print("学号:");
        sno=input.next();
        System.out.print("姓名:");
        sname=input.next();
        System.out.print("性别:");
        ssex=input.next();
        System.out.print("院系:");
        sdept=input.next();
        System.out.print("年龄:");21
        sage=input.nextInt();
        try {
            PreparedStatement sta=con.prepareStatement("insert into student values(?,?,?,?,?)");
            sta.setString(1, sno);
            sta.setString(2, sname);
            sta.setString(3, ssex);
            sta.setInt(4, sage);
            sta.setString(5, sdept);
            if(sta.executeUpdate()==0) {
                System.out.println("数据增加失败！！");
            }else {
                System.out.println("数据添加成功！！");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("数据增加失败！！");
        }

    }
    public static void Query(Connection con,Scanner input) {
        String sno=null;
        PreparedStatement sta=null;
        ResultSet re=null;
        try {
            sta=con.prepareStatement("select * from student where sno=?");
            System.out.print("请输入要查询的学号(输入\"all\"查询所有信息)：");
            sno=input.next();
            if(sno.equals("all")) {
                sta=con.prepareStatement("select * from student",ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
            }else {
                sta=con.prepareStatement("select * from student where sno=?");
                sta.setString(1,sno);
            }
            re=sta.executeQuery();
            if(!re.next())
                System.out.println("没有此人信息！！");
            else {
                re.previous();
                while(re.next()) {
                    System.out.println("学号:"+re.getString("id")+" 姓名:"+re.getString("name")+" 性别:"+re.getString("sex")+" 年龄："+re.getString("age")+""
                            + " 院系:"+re.getString("dept"));
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("数据查找失败！！！");
            System.out.println( e.getMessage());

        }
    }
}
