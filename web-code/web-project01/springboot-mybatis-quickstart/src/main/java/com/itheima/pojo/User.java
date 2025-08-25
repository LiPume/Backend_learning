package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 准备实体类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String Username;
    private String Password;
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + Username + '\'' +
                ", password='" + Password + '\'' +
                '}';
    }
}
