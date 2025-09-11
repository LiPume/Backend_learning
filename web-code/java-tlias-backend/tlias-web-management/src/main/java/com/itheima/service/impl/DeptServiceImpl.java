package com.itheima.service.impl;

import com.itheima.exception.GlobalExceptionHandler;
import com.itheima.mapper.DeptMapper;
import com.itheima.pojo.Dept;
import com.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAll(){
        return deptMapper.findAll();
    }

    @Override
    public void deleteById(Integer id){
        //如果部门下有员工，则不允许删除该部门，并给前端提示错误信息：对不起，当前部门下有员工，不能直接删除！
        if (deptMapper.getEmpCountByDeptId(id) > 0){
            throw new GlobalExceptionHandler.ClazzHasStudentException("对不起，当前部门下有员工，不能直接删除！");
        }else{
            deptMapper.deleteById(id);
        }
    }

    @Override
    public void add(Dept dept){
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.add(dept);
    }

    @Override
    public Dept getById(Integer id){
        return deptMapper.getById(id);
    }

    @Override
    public void update(Dept dept){
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }

}
