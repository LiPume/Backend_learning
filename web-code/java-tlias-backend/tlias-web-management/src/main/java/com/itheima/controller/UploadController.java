package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@RestController
@Slf4j
public class UploadController {

    /**
     * 本地磁盘存储方案
     * @param file
     * @return
     */
    /*    @PostMapping("/upload")
    public Result handleFileUpload(String name, Integer age, MultipartFile file ) throws IOException {
        log.info("上传成功！用户名：{}，密码：{}，文件：{}", name, age ,file);
        String uniqueFileName = generateUniqueFileName(Objects.requireNonNull(file.getOriginalFilename()));
        file.transferTo(new File("E:/data/upload/" + uniqueFileName));
        return Result.success();
    }

    private String generateUniqueFileName(String originalFileName) {
        String randomStr = UUID.randomUUID().toString().replaceAll("-","");
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
        return randomStr + extension;
    }*/
    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;
    /**
     * 阿里云OSS存储方案
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public Result FileUpload(MultipartFile file) throws Exception {
        log.info("上传成功！文件：{}", file.getOriginalFilename());
        // 将文件交给OSS存储管理
        String url = aliyunOSSOperator.upload(file.getBytes(), Objects.requireNonNull(file.getOriginalFilename()));
        return Result.success(url);
    }

}
