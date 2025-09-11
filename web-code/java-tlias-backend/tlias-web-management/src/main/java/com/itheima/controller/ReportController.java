package com.itheima.controller;

import com.itheima.pojo.ClazzOption;
import com.itheima.pojo.JobOption;
import com.itheima.pojo.Result;
import com.itheima.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/report")
@Slf4j
public class ReportController {

    @Autowired
    private ReportService reportService;
    @RequestMapping("/empJobData")
    public Result getEmpJobData(){
        log.info("统计各个职位员工人数");
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }

    @RequestMapping("/empGenderData")
    public Result getEmpGenderData(){
        log.info("统计员工性别数据");
        List<Map<String,Object>> list = reportService.getEmpGenderData();
        return Result.success(list);
    }
    @RequestMapping("/studentDegreeData")
    public Result getStudentDegreeData(){
        log.info("统计学生学历数据");
        List<Map<String,Object>> list = reportService.getStudentDegreeData();
        return Result.success(list);
    }

    @RequestMapping("/studentCountData")
    public Result getStudentCountData(){
        log.info("统计学生数量数据");
        ClazzOption list = reportService.getStudentCountData();
        return Result.success(list);
    }
}
