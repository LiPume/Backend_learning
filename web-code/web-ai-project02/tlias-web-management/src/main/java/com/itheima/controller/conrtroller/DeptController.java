package com.itheima.controller.conrtroller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptservice;

    @RequestMapping("/depts")
    public Result list(){

        System.out.println("查询全部部门数据");

        List<Dept> depts = deptservice.findAll();

        return Result.success(depts);
    }

    @DeleteMapping("/depts")
    public Result delete(Integer id){

        System.out.println("删除部门数据");

        deptservice.deleteById(id);

        return Result.success();
    }

    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept){
        System.out.println("添加部门数据");
        deptservice.add(dept);
        return Result.success();
    }

}
