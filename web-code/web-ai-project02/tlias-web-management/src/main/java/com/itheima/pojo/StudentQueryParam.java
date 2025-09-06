package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentQueryParam {
    private Integer page;
    private Integer pageSize;
    private String name;
    private Integer degree;
    private Integer clazzId;
}
