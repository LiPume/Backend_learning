package com.itheima.mapper;


import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper // 程序运行时，框架会自动生成接口的实现类对象(代理对象)，并给交Spring的IOC容器管理
public interface UserMapper {
    //查询所有用户

    public List<User> findAll();
}
