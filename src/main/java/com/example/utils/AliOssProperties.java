package com.example.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// 将配置文件中的属性注入到bean对象的属性中
@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliOssProperties {
    // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
    private String endpoint;
    private String bucketName;
}
