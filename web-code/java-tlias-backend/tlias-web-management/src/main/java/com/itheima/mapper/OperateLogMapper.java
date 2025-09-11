package com.itheima.mapper;

import com.itheima.pojo.OperateLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OperateLogMapper {

    //插入日志数据
    @Insert("insert into operate_log (operate_emp_id, operate_time, class_name, method_name, method_params, return_value, cost_time) " +
            "values (#{operateEmpId}, #{operateTime}, #{className}, #{methodName}, #{methodParams}, #{returnValue}, #{costTime});")
    public void insert(OperateLog log);

    @Select("select operate_log.id,operate_emp_id operateEmpId,operate_time operateTime,class_name className,method_name methodName,method_params methodParams,return_value returnValue,cost_time costTime,emp.name operateEmpName\n" +
            "        from operate_log,emp where operate_log.operate_emp_id = emp.id")
    List<OperateLog> getLogs();
}
