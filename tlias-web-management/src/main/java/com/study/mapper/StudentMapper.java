package com.study.mapper;

import com.study.pojo.Student;
import com.study.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("select count(*) from student where clazz_id = #{id}")
    int countByClazzId(Integer id);

    List<Student> list(StudentQueryParam studentQueryParam);

    void insert(Student student);

    Student getById(Integer id);

    void update(Student student);

    void deleteByIds(List<Integer> ids);

    @Update("update student set violation_count=violation_count+1, violation_score=violation_score+#{score} where id=#{id}")
    void addViolation(Integer id, Integer score);
}
