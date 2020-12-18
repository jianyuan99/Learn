package bean;

/**
 * @ClassName Student
 * @Description 学生信息
 * @Author Huangbiao
 * @Date 2020-12-09 20:11
 * @Version V1.0
 */
public class Student {
    /**
     * 学生姓名
     */
    private String name;
    /**
     * 学生学号
     */
    private String id;
    /**
     * 学生性别
     */
    private String sex;
    /**
     * 学生年龄
     */
    private String age;
    /**
     * 学生所在系名
     */
    private String dept;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
    @Override
    public String toString(){
        return "Student [ id="+id+" name="+name+" sex="+sex+" age="+age+" dept="+dept+" ]";
    }
}
