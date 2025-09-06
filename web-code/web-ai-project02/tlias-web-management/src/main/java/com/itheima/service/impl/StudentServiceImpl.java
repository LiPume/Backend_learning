package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.StudentMapper;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;
import com.itheima.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public PageResult<Student> page(StudentQueryParam studentQueryParam) {
        PageHelper.startPage(studentQueryParam.getPage(), studentQueryParam.getPageSize());
        List<Student> list = studentMapper.list(studentQueryParam);
        Page<Student> page = (Page<Student>) list;
        return new PageResult<>(page.getTotal(), page.getResult());
    }

    @Override
    public void save(Student student) {
        // 1.补全数据
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.insert(student);

    }

    @Override
    public Student getInfoById(Integer id) {
        return studentMapper.getInfoById(id);
    }

    @Override
    public void update(Student student) {
        // 1.修改时间
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.update(student);
    }

    @Override
    public void delete(Integer id) {
        studentMapper.delete(id);
    }

    @Override
    public void addViolation(Integer id, Short score) {
        studentMapper.addViolation(id,score);
    }
}
