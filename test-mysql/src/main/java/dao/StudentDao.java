package dao;

import bean.Student;

import java.util.List;

/**
 * @ClassName StudentDao
 * @Description 学生数据访问接口
 * @Author Huangbiao
 * @Date 2020-12-09 22:56
 * @Version V1.0
 */
public interface StudentDao {
    boolean insert(Student student);
    boolean delStudent(Student student);
    boolean delStudentId(String id);
//    boolean delStudentClass(String clas);
    boolean delStudentDept(String dept);
    boolean update(Student student);
    Student findStudentId(String id);
    List<Student> findStudentName(String name);
//    List<Student> findClassAndName(String name, String clas);
//    List<Student> findStudentClass(String clas);
    List<Student> findStudentDept(String dept);
    List<Student> findAllStudent();

}
