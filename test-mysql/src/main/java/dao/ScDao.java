package dao;

import bean.Sc;

import java.util.List;

/**
 * @ClassName ScDao
 * @Description 学生成绩信息访问接口
 * @Author Huangbiao
 * @Date 2020-12-09 22:58
 * @Version V1.0
 */
public interface ScDao {
    boolean insert(Sc sc);
    boolean delSc(Sc sc);
    boolean delScSno(String sno);
    boolean delScCno(String cno);
    boolean update(Sc sc);
    Sc findScSno(String sno);
    List<Sc> findScCno(String cno);
    List<Sc> findScGrade(String grade);

}
