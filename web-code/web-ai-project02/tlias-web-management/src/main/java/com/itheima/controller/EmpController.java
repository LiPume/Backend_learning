package com.itheima.controller;


import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping
    public Result page(EmpQueryParam empQueryParam) {
    log.info("分页请求参数：{}",empQueryParam);
    PageResult<Emp> pageResult = empService.page(empQueryParam);
    return Result.success(pageResult);
    }
    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("新增员工：{}",emp);
        empService.save(emp);
        return Result.success();
    }

    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
        log.info("删除员工：{}",ids);
        empService.deleteByIds(ids);
        return Result.success();
    }

    @GetMapping({"/{id}"})
    public Result getInfo(@PathVariable Integer id){
        log.info("查询员工：{}",id);
        Emp emp = empService.getInfo(id);
        return Result.success(emp);
    }

    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("更新员工：{}",emp);
        empService.update(emp);
        return Result.success();
    }

    @GetMapping("/list")
    public Result list(){
        log.info("查询所有班主任");
        List<Emp> list = empService.masterList();
        return Result.success(list);
    }


}
