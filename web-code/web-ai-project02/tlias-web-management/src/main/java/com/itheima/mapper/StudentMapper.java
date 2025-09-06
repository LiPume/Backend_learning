package com.itheima.mapper;

import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    List<Student> list(StudentQueryParam studentQueryParam);

    void insert(Student student);

    Student getInfoById(Integer id);

    void update(Student student);

    void delete(Integer id);

    void addViolation(Integer id, Short score);
}
