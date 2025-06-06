package com.study.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.study.exception.pojo.ExistStudentException;
import com.study.mapper.ClazzMapper;
import com.study.mapper.StudentMapper;
import com.study.pojo.Clazz;
import com.study.pojo.ClazzQueryParam;
import com.study.pojo.PageResult;
import com.study.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult<Clazz> page(ClazzQueryParam clazzQueryParam) {
        PageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPageSize());
        List<Clazz> clazzList = clazzMapper.list(clazzQueryParam);
        clazzList.forEach(clazz -> {
            if(clazz.getBeginDate().isAfter(LocalDate.now())){
                clazz.setStatus("未开班");
            } else if (clazz.getEndDate().isBefore(LocalDate.now())) {
                clazz.setStatus("已结课");
            } else {
                clazz.setStatus("在读中");
            }
        });
        Page<Clazz> clazzPage = (Page<Clazz>) clazzList;
        return new PageResult<Clazz>(clazzPage.getTotal(), clazzPage.getResult());
    }

    @Override
    public void add(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.insert(clazz);
    }

    @Override
    public Clazz getInfoById(Integer id) {
        return clazzMapper.getById(id);
    }

    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.updateById(clazz);
    }

    @Override
    public void deteleById(Integer id) {
        if(studentMapper.countByClazzId(id) > 0){
            throw new ExistStudentException("班级下有学生，不能直接删除");
        }
        clazzMapper.deleteById(id);
    }

    @Override
    public List<Clazz> getAllInfo() {
        return clazzMapper.getAll();
    }
}
