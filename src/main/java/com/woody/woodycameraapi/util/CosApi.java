package com.woody.woodycameraapi.util;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.stream.Collectors;

@Slf4j
@Component
public class CosApi {
    private COSClient cosClient;
    @Value("${tencent.cloud.secretId}")
    private String secretId;
    @Value("${tencent.cloud.secretKey}")
    private String secretKey;
    @Value("${tencent.cloud.cos.region}")
    private String cosRegion;
    @Value("${tencent.cloud.cos.bucketName}")
    private String bucketName;

    public void setupClient() {
        if (cosClient == null) {
            COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
            // 2 设置 bucket 的地域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
            // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
            Region region = new Region(cosRegion);
            ClientConfig clientConfig = new ClientConfig(region);
            // 这里建议设置使用 https 协议
            // 从 5.6.54 版本开始，默认使用了 https
            // 3 生成 cos 客户端。
            cosClient = new COSClient(cred, clientConfig);
        }
    }

    public String upload(String content, String key) {
        setupClient();
        // 指定文件上传到 COS 上的路径，即对象键。例如对象键为folder/picture.jpg，则表示将文件 picture.jpg 上传到 folder 路径下
        InputStream inputStream = new ByteArrayInputStream(content.getBytes());
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(content.length());
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, inputStream, metadata);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
        return putObjectResult.getETag();
    }

    public String download(String key) {
        setupClient();
        // Bucket的命名格式为 BucketName-APPID ，此处填写的存储桶名称必须为此格式
        // 指定文件在 COS 上的路径，即对象键。例如对象键为folder/picture.jpg，则表示下载的文件 picture.jpg 在 folder 路径下
        // 方法1 获取下载输入流
        System.out.println(bucketName);
        System.out.println(key);
        GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName, key);
        COSObject cosObject = cosClient.getObject(getObjectRequest);
        COSObjectInputStream cosObjectInput = cosObject.getObjectContent();

        // 下载对象的 CRC64
//        String crc64Ecma = cosObject.getObjectMetadata().getCrc64Ecma();

        String result = new BufferedReader(new InputStreamReader(cosObjectInput))
                .lines().collect(Collectors.joining("\n"));

        // 关闭输入流
        try {
            cosObjectInput.close();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return result;

        // 方法2 下载文件到本地的路径，例如 D 盘的某个目录
//        String outputFilePath = "exampleobject";
//        File downFile = new File(outputFilePath);
//        getObjectRequest = new GetObjectRequest(bucketName, key);
//        ObjectMetadata downObjectMeta = cosClient.getObject(getObjectRequest, downFile);

    }
}
