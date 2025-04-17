package com.study.controller;

import com.study.pojo.ClazzOption;
import com.study.pojo.JobOption;
import com.study.pojo.Result;
import com.study.service.ReportService;
import com.study.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/report")
@RestController
public class ReportController {
    @Autowired
    private ReportService reportService;


    @GetMapping("/empJobData")
    public Result getEmpJobData(){

        log.info("统计员工职位人数");
        JobOption empJob = reportService.getEmpJonData();
        return Result.success(empJob);
    }

    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        log.info("统计员工性别人数");
        List<Map<String, Object>> empGender = reportService.getEmpGenderData();
        return Result.success(empGender);
    }

    @GetMapping("/studentCountData")
    public Result getClazzStuCount(){
        log.info("统计班级学员人数");
        ClazzOption clazzOption = reportService.getClazzStuCount();
        return Result.success(clazzOption);
    }

    @GetMapping("/studentDegreeData")
    public Result getDegreeCount(){
        log.info("统计学员学历信息");
        List<Map<String, Object>> studentDegree = reportService.getStudentDegreeData();
        return Result.success(studentDegree);
    }

}
