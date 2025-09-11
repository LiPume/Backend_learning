package com.itheima.service.impl;

import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.ClazzOption;
import com.itheima.pojo.JobOption;
import com.itheima.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;
    @Override
    public JobOption getEmpJobData() {
        // 1. 调用mapper方法，获取数据
        List<Map<String,Object>> list = empMapper.countEmpJobData();
        // 2. 封装数据
        List<Object> jobList = list.stream().map(m -> m.get("pos")).toList();
        List<Object> dataList = list.stream().map(m -> m.get("num")).toList();
        return new JobOption(jobList,dataList);
    }

    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }

    @Override
    public List<Map<String, Object>> getStudentDegreeData() {
        List<Map<String, Object>> list = empMapper.countStudentDegreeData();
        return list;
    }

    @Override
    public ClazzOption getStudentCountData() {
        List<Map<String, Object>> list = empMapper.countStudentCountData();
        List<Object> clazzList = list.stream().map(m -> m.get("name")).toList();
        List<Object> dataList = list.stream().map(m -> m.get("num")).toList();
        return new ClazzOption(clazzList,dataList);
    }
}
