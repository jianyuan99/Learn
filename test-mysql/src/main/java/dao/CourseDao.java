package dao;

import bean.Course;

import java.util.Collection;
import java.util.List;

/**
 * @ClassName CrouseDao
 * @Description 课程数据访问接口
 * @Author Huangbiao
 * @Date 2020-12-09 22:57
 * @Version V1.0
 */
public interface CourseDao {

    boolean insert(Course course);
    boolean delCourseId(String id);
    boolean delCourseName(String name);
    boolean delCourse(Course course);
    boolean update(Course course);
    Course findCourseId(String id);
    Course findCourseName(String name);
    List<Course> findCourseDept(String deptId);
    List<Course> findCourseCredit(String credit);

}
