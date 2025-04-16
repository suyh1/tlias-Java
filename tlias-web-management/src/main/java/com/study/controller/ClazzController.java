package com.study.controller;

import com.study.pojo.Clazz;
import com.study.pojo.ClazzQueryParam;
import com.study.pojo.PageResult;
import com.study.pojo.Result;
import com.study.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/clazzs")
@RestController
public class ClazzController {
    @Autowired
    private ClazzService clazzService;
    @GetMapping
    public Result page(ClazzQueryParam clazzQueryParam){
        log.info("分页查询：{}",clazzQueryParam);
        PageResult<Clazz> pageResult = clazzService.page(clazzQueryParam);
        return Result.success(pageResult);
    }

    @PostMapping
    public Result add(@RequestBody Clazz clazz){
        log.info("添加班级：{}", clazz);
        clazzService.add(clazz);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据id: {}获取班级信息", id);
        Clazz clazz = clazzService.getInfoById(id);
        return Result.success(clazz);
    }

    @PutMapping
    public Result update(@RequestBody Clazz clazz){
        log.info("修改班级信息：{}", clazz);
        clazzService.update(clazz);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id：{}删除班级", id);
        clazzService.deteleById(id);
        return Result.success();
    }

    @GetMapping("/list")
    public Result getAllInfo(){
        log.info("查询所有班级信息");
        List<Clazz> infoList = clazzService.getAllInfo();
        return Result.success(infoList);
    }

}
