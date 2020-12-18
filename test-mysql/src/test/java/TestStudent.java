import bean.Student;
import impl.StudentImpl;
import org.junit.Test;

import java.util.List;

/**
 * @ClassName TestStudent
 * @Description 测试student
 * @Author Huangbiao
 * @Date 2020-12-12 19:35
 * @Version V1.0
 */
public class TestStudent {
    @Test
    public void test(){
        StudentImpl studentImpl = new StudentImpl();
        Student student = new Student();
        student.setId("1807004345");
        student.setName("黄彪");
        student.setSex("男");
        student.setAge("21");
        student.setDept("计算机科学与技术");
//        studentImpl.insert(student);
        Student student1 = studentImpl.findStudentId("1807004345");
        System.out.println(student1.toString());
//        List<Student> students = studentImpl.findAllStudent();
//        for (int i = 0; i < students.size(); i++) {
//            System.out.println(students.get(i).toString());
//        }
    }
}
