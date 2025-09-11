package com.itheima.controller;

import com.itheima.pojo.OperateLog;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.service.OperateLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
@Slf4j
public class LogController {

    @Autowired
    private OperateLogService operateLogService;
    @GetMapping("/page")
    public Result page(Integer page, Integer pageSize) {
        log.info("page = {}, pageSize = {}", page, pageSize);
        PageResult<OperateLog> log = operateLogService.page(page, pageSize);
        return Result.success(log);
    }
}
