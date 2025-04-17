package com.study.service.impl;

import com.study.mapper.ClazzMapper;
import com.study.mapper.EmpMapper;
import com.study.mapper.StudentMapper;
import com.study.pojo.ClazzOption;
import com.study.pojo.JobOption;
import com.study.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private ClazzMapper clazzMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public JobOption getEmpJonData() {
        // map集合: position=,number=
        List<Map<String, Object>> list = empMapper.countJobData();
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("position")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("number")).toList();

        return new JobOption(jobList, dataList);
    }

    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }


    @Override
    public ClazzOption getClazzStuCount() {
        List<Map<String, Object>> list = clazzMapper.countClazzStuData();
        List<Object> clazzList = list.stream().map(dataMap -> dataMap.get("clazzName")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("num")).toList();
        return new ClazzOption(clazzList, dataList);
    }

    @Override
    public List<Map<String, Object>> getStudentDegreeData() {
        return studentMapper.countStudentDegreeData();
    }
}
