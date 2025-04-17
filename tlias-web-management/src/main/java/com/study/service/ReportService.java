package com.study.service;

import com.study.pojo.ClazzOption;
import com.study.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    JobOption getEmpJonData();

    List<Map<String, Object>> getEmpGenderData();

    ClazzOption getClazzStuCount();

    List<Map<String, Object>> getStudentDegreeData();
}
