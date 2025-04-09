package com.study.service;

import com.study.mapper.DeptMapper;
import com.study.pojo.Dept;

import java.util.List;

public interface DeptService {

    /**
     * 查询所有部门信息
     */
    List<Dept> findAll();

    /**
     * 按照id删除部门信息
     */
    void deleteById(Integer id);

    /**
     * 根据部门名称添加部门信息
     * @param dept
     */
    void addByName(Dept dept);

    /**
     * 根据id获取部门信息
     * @param id
     * @return
     */
    Dept getById(Integer id);


    /**
     * 根据id更新部门信息
     * @param dept
     */
    void update(Dept dept);
}
