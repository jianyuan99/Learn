import bean.Course;
import impl.CourseImpl;
import org.junit.Test;

/**
 * @ClassName Testcourse
 * @Description 测试course
 * @Author Huangbiao
 * @Date 2020-12-12 19:34
 * @Version V1.0
 */
public class Testcourse {
    @Test
    public void test(){
        CourseImpl courseImpl = new CourseImpl();
        Course course = new Course();
        course.setId("003");
        course.setCname("计算机操作系统");
        course.setPid("001");
        course.setCredit("4");
        courseImpl.insert(course);
        Course course1 = courseImpl.findCourseId("002");
        System.out.println(course1.toString());
    }
}
