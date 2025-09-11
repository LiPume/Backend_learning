package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.exception.GlobalExceptionHandler;
import com.itheima.mapper.ClazzMapper;
import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;
    @Override
    public PageResult<Clazz> page(ClazzQueryParam clazzQueryParam) {
        //原始方法：1.获取总记录数 2.获取每一页数据表 3.封装分页结果
        //PageHelper方法：1.设置分页参数 2.调用分页查询方法 3.封装分页结果
        PageHelper.startPage(clazzQueryParam.getPage(),clazzQueryParam.getPageSize());
        List<Clazz> clazzList = clazzMapper.list(clazzQueryParam);
        //根据开课与结课时间进行一个状态判断
        for (Clazz clazz : clazzList) {
            if (clazz.getBeginDate() != null && clazz.getEndDate() != null) {
                if (LocalDate.now().isAfter(clazz.getEndDate())) {
                    clazz.setStatus("已结课");
                } else if (LocalDate.now().isBefore(clazz.getBeginDate())) {
                    clazz.setStatus("未开始");
                } else {
                    clazz.setStatus("进行中");
                }
            }
        }
        Page<Clazz> p = (Page<Clazz>)clazzList;
        return new PageResult<>(p.getTotal(),p.getResult());
    }

    @Override
    public void save(Clazz clazz) {
        // 1.补全数据，增加时间
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());

        clazzMapper.insert(clazz);
    }

    @Override
    public Clazz getInfo(Integer id) {
        return clazzMapper.getInfoById(id);
    }

    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.update(clazz);
    }

    @Override
    public void delete(Integer id) {
        // 如果班级下关联的有学生, 则不允许删除该版本, 并提示错误信息 : "对不起, 该班级下有学生, 不能直接删除"
        // 通过自定义异常 + 全局异常处理器实现
        if (clazzMapper.getStudentCountByClazzId(id) > 0) {
            throw new GlobalExceptionHandler.ClazzHasStudentException("对不起, 该班级下有学生, 不能直接删除");
        }else{
            // 如果班级下没有学生, 则允许删除
            clazzMapper.delete(id);
        }
    }


    @Override
    public List<Clazz> clazzList() {
        return clazzMapper.classList();
    }
}
