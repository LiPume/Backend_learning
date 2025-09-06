package com.itheima.service;

import com.itheima.pojo.PageResult;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;

public interface StudentService {
    PageResult<Student> page(StudentQueryParam studentQueryParam);

    void save(Student student);

    Student getInfoById(Integer id);

    void update(Student student);

    void delete(Integer id);

    void addViolation(Integer id, Short score);
}
