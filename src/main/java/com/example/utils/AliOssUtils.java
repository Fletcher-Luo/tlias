package com.example.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Component
public class AliOssUtils {
    @Autowired
    private AliOssProperties aliOssProperties;
    // 从环境变量中获取访问凭证。运行本代码示例之前，请确保已设置环境变量OSS_ACCESS_KEY_ID和OSS_ACCESS_KEY_SECRET。
    private EnvironmentVariableCredentialsProvider credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();

    public AliOssUtils() throws ClientException {
    }

    public String upload(MultipartFile file) throws IOException {
        String endpoint = aliOssProperties.getEndpoint();
        String bucketName = aliOssProperties.getBucketName();;
        InputStream inputStream = file.getInputStream();

        String originalFileName = file.getOriginalFilename();
        String fileName = UUID.randomUUID().toString() + originalFileName.substring(originalFileName.lastIndexOf('.'));
        OSS ossClient = new OSSClientBuilder().build(endpoint, credentialsProvider);
        // 创建PutObjectRequest对象。
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, fileName, inputStream);
        // 创建PutObject请求。
        ossClient.putObject(putObjectRequest);

        String url = "https://" + bucketName + "." + endpoint.split("//")[1] + "/" + fileName;
        ossClient.shutdown();
        return url;

    }
}
