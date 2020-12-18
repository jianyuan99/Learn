package bean;

/**
 * @ClassName Sc
 * @Description 学生成绩
 * @Author Huangbiao
 * @Date 2020-12-09 20:17
 * @Version V1.0
 */
public class Sc {
    /**
     * 学生学号
     */
    private String Sno;
    /**
     * 课程号
     */
    private String Cno;
    /**
     * 成绩
     */
    private String Grade;

    public String getSno() {
        return Sno;
    }

    public void setSno(String sno) {
        Sno = sno;
    }

    public String getCno() {
        return Cno;
    }

    public void setCno(String cno) {
        Cno = cno;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }
    @Override
    public String toString(){
        return null;
    }
}
