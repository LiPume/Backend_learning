package com.itheima.mapper;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClazzMapper {
    List<Clazz> list(ClazzQueryParam clazzQueryParam);

    void insert(Clazz clazz);

    Clazz getInfoById(Integer id);

    void update(Clazz clazz);

    void delete(Integer id);

    int getStudentCountByClazzId(Integer id);

    @Select("select * from clazz")
    List<Clazz> classList();
}
