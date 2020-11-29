package Main;
//定义课程类Course
class Course{
    private String nameCourse;
    private int numCourse;
    private int  preCourse;
    //创建无参构造函数
    public Course(){}
    //创建构造函数
    public Course(String name,int num,int pre){
        nameCourse = name;
        numCourse = num;
        preCourse = pre;
    }

    //创建get和set方法
    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public int getNumCourse() {
        return numCourse;
    }

    public void setNumCourse(int numCourse) {
        this.numCourse = numCourse;
    }

    public int getPreCourse() {
        return preCourse;
    }

    public void setPreCourse(int preCourse) {
        this.preCourse = preCourse;
    }

    //创建print方法
    public void printInfo(){
        System.out.println("课程名："+this.getNameCourse());
        System.out.println("课程编号:"+this.getNumCourse());
        System.out.println("先修课程号:"+this.getPreCourse());
    }
}

public class Demo2 {
    public static void main(String[] args){
        //测试创建Course类对象course
        Course course = new Course();

        //测试Course的set方法
        course.setNameCourse("Java 面向对象");
        course.setNumCourse(2);
        course.setPreCourse(1);
        //测试Course的get和print方法
        course.printInfo();

    }
}
