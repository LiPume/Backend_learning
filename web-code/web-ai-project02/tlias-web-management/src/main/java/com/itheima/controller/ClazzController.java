package com.itheima.controller;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clazzs")
@Slf4j
public class ClazzController {

    @Autowired
    private ClazzService clazzService;
    @GetMapping
    public Result page(ClazzQueryParam clazzQueryParam) {
        log.info("分页查询班级信息，参数：{}", clazzQueryParam);
        PageResult<Clazz> pageResult = clazzService.page(clazzQueryParam);
        return Result.success(pageResult);
    }
    @PostMapping
    public Result save(@RequestBody Clazz clazz) {
        log.info("添加班级信息，参数：{}", clazz);
        clazzService.save(clazz);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据ID查询班级信息：{}",id);
        Clazz clazz = clazzService.getInfo(id);
        return Result.success(clazz);
    }

    @PutMapping
    public Result update(@RequestBody Clazz clazz){
        log.info("更新班级信息，参数：{}", clazz);
        clazzService.update(clazz);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("删除班级信息：{}",id);
        clazzService.delete(id);
        return Result.success();
    }

    @GetMapping("/list")
    public Result List(){
        log.info("查询所有班级信息");
        List<Clazz> clazzList = clazzService.clazzList();
        return Result.success(clazzList);
    }

}
