package com.itheima.controller;

import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;
import com.itheima.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;
    @GetMapping
    public Result page(StudentQueryParam studentQueryParam){
        log.info("学生信息分页查询:{}", studentQueryParam);
        PageResult<Student> pageResult = studentService.page(studentQueryParam);
        return Result.success(pageResult);
    }

    @PostMapping
    public Result save(@RequestBody Student student){
        log.info("新增学生：{}",student);
        studentService.save(student);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("查询id为{}的学生信息",id);
        Student student = studentService.getInfoById(id);
        return Result.success(student);
    }

    @PutMapping
    public Result update(@RequestBody Student student){
        log.info("更新学生信息：{}",student);
        studentService.update(student);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("删除id为{}的学生信息",id);
        studentService.delete(id);
        return Result.success();
    }

    @PutMapping("/violation/{id}/{score}")
    public Result addViolation(@PathVariable Integer id, @PathVariable Short score){
        log.info("id为{}的学生违纪记分：{}",id,score);
        studentService.addViolation(id,score);
        return Result.success();
    }
}
