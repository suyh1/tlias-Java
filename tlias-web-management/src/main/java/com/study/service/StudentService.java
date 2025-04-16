package com.study.service;

import com.study.pojo.PageResult;
import com.study.pojo.Student;
import com.study.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {
    PageResult<Student> page(StudentQueryParam studentQueryParam);

    void add(Student student);

    Student getById(Integer id);

    void updateById(Student student);

    void deleteByIds(List<Integer> ids);

    void addViolation(Integer id, Integer score);
}
