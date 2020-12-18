package bean;

/**
 * @ClassName Crouse
 * @Description 课程
 * @Author Huangbiao
 * @Date 2020-12-09 20:15
 * @Version V1.0
 */
public class Course {
    /**
     * 课程编号
     */
    private String id;
    /**
     * 课程名称
     */
    private String name;
    /**
     * 课程所属系别
     */
    private String Pid;
    /**
     * 课程学分
     */
    private String credit;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCname() {
        return name;
    }

    public void setCname(String cname) {
        name = cname;
    }

    public String getPid() {
        return Pid;
    }

    public void setPid(String pid) {
        Pid = pid;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }
    @Override
    public String toString(){
        return "Course [ id ="+id+" name ="+name+" pid ="+Pid+" credit ="+credit+" ]";
    }
}
