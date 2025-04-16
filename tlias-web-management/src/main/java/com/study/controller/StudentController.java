package com.study.controller;

import com.study.pojo.PageResult;
import com.study.pojo.Result;
import com.study.pojo.Student;
import com.study.pojo.StudentQueryParam;
import com.study.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/students")
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public Result page(StudentQueryParam studentQueryParam){
        log.info("进行条件分页查询学员：{}", studentQueryParam);
        PageResult<Student> pageResult = studentService.page(studentQueryParam);
        return Result.success(pageResult);
    }

    @PostMapping
    public Result add(@RequestBody Student student){
        log.info("添加学员：{}", student);
        studentService.add(student);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据ID：{} 查询学员信息", id);
        Student student = studentService.getById(id);
        return Result.success(student);
    }

    @PutMapping
    public Result updateById(@RequestBody Student student){
        log.info("更新id更新成以下信息：{}", student);
        studentService.updateById(student);
        return Result.success();
    }
    @DeleteMapping("/{ids}")
    public Result deleteByIds(@PathVariable List<Integer> ids){
        log.info("批量删除学员：{}", ids);
        studentService.deleteByIds(ids);
        return Result.success();
    }

    @PutMapping("/violation/{id}/{score}")
    public Result addViolation(@PathVariable Integer id, @PathVariable Integer score){
        log.info("给ID为：{} 的学员扣违纪分：{}", id, score);
        studentService.addViolation(id, score);
        return Result.success();
    }

}
