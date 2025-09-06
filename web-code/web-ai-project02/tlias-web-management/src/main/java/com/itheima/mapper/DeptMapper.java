package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Select("select id,name,create_time,update_time from dept order by update_time desc")
    List<Dept> findAll();

    @Select("delete from dept where id=#{id}")
    void deleteById(Integer id);

    @Insert("insert into dept(name,create_time,update_time) values(#{name},#{createTime},#{updateTime})")
    void add(Dept dept);

    @Select("select id,name,create_time,update_time from dept where id=#{id}")
    Dept getById(Integer id);

    @Update("update dept set name=#{name},update_time=#{updateTime} where id=#{id}")
    void update(Dept dept);

    @Select("select count(1) from emp where dept_id= #{id}")
    int getEmpCountByDeptId(Integer id);
}
