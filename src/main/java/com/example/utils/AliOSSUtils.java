package com.example.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Component
public class AliOSSUtils {
    // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
    private String endpoint = "https://oss-cn-shanghai.aliyuncs.com";
    // 从环境变量中获取访问凭证。运行本代码示例之前，请确保已设置环境变量OSS_ACCESS_KEY_ID和OSS_ACCESS_KEY_SECRET。
    private EnvironmentVariableCredentialsProvider credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();
    // 填写Bucket名称，例如examplebucket。
    private String bucketName = "tlias-lfc";

    public AliOSSUtils() throws ClientException {
    }

    public String upload(MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();

        String originalFileName = file.getOriginalFilename();
        System.out.println(originalFileName);
        String fileName = UUID.randomUUID().toString() + originalFileName.substring(originalFileName.lastIndexOf('.'));
        System.out.println(fileName);
        OSS ossClient = new OSSClientBuilder().build(endpoint, credentialsProvider);
        // 创建PutObjectRequest对象。
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, fileName, inputStream);
        // 创建PutObject请求。
        ossClient.putObject(putObjectRequest);

        String url = "https://" + bucketName + "." + endpoint.split("//")[1] + "/" + fileName;
        System.out.println(url);
        ossClient.shutdown();
        return url;

    }
}
