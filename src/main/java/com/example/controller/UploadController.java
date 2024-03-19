package com.example.controller;

import com.example.pojo.Result;
import com.example.utils.AliOssUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
public class UploadController {
    @Autowired
    private AliOssUtils aliOssUtils;
    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        log.info("文件上传" + image.getOriginalFilename());
        String url = aliOssUtils.upload(image);
        return Result.success(url);
    }
}
