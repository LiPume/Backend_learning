package com.itheima.controller.conrtroller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/depts")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptservice;

    @RequestMapping
    public Result list(){

        System.out.println("查询全部部门数据");

        List<Dept> depts = deptservice.findAll();

        return Result.success(depts);
    }

    @DeleteMapping
    public Result delete(Integer id){

        System.out.println("删除部门数据");

        deptservice.deleteById(id);

        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Dept dept){
        System.out.println("添加部门数据");
        deptservice.add(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        System.out.println("查询部门数据");
        Dept dept = deptservice.getById(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result update(@RequestBody Dept dept){
        System.out.println("修改部门数据");
        deptservice.update(dept);
        return Result.success();
    }

}
