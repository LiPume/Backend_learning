package com.itheima.controller.conrtroller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/depts")
@RestController
public class DeptController {

    public static final Logger log = LoggerFactory.getLogger(DeptController.class);
    @Autowired
    private DeptService deptservice;

    @RequestMapping
    public Result list(){

        log.info("查询全部部门数据");

        List<Dept> depts = deptservice.findAll();

        return Result.success(depts);
    }

    @DeleteMapping
    public Result delete(Integer id){

        log.info("根据ID删除部门：{}", id);

        deptservice.deleteById(id);

        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("添加部门：{}",dept);
        deptservice.add(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据ID查询部门：{}",id);
        Dept dept = deptservice.getById(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("修改部门：{}",dept);
        deptservice.update(dept);
        return Result.success();
    }

}
