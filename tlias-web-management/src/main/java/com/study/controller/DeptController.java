package com.study.controller;

import com.study.pojo.Dept;
import com.study.pojo.Result;
import com.study.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;
    @GetMapping
    public Result list(){
        log.info("查询所有部门信息");
        List<Dept> deptList = deptService.findAll();

        return Result.success(deptList);
    }

    @DeleteMapping
    public Result delete(Integer id){
        log.info("删除部门信息：{}", id);
        deptService.deleteById(id);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("添加部门: {}", dept);
        deptService.addByName(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("获取部门id: {}", id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("要更新的部门：{}",dept.getId());
        deptService.update(dept);
        return Result.success();
    }
}
