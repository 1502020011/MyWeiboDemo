package org.eu.konworkers.myweibodemo.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class UploadUtils{
    private String url;
    private String json;

    public UploadUtils(String url, String json) {
        this.url = url;
        this.json = json;
    }

    public String run() {
        String encode = "utf-8";

        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();

        HttpPut httpput = new HttpPut(url);
        httpput.setHeader("Accept", "application/vnd.github+json");
        httpput.setHeader("Accept-Encoding", "gzip, deflate");
        httpput.setHeader("Cache-Control", "no-cache");
        httpput.setHeader("Connection", "keep-alive");
        httpput.setHeader("Content-Type", "application/json;charset=UTF-8");
        httpput.setHeader("Authorization", "Bearer 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");

        StringEntity stringEntity = new StringEntity(json,encode);

        httpput.setEntity(stringEntity);

        String content = null;
        CloseableHttpResponse httpResponse = null;

        try {
            // 响应信息
            httpResponse = closeableHttpClient.execute(httpput);// 执行请求
            HttpEntity entity = httpResponse.getEntity();// 接收响应
            content = EntityUtils.toString(entity, encode);// 将响应转为String类型
        } catch (Exception e) {
            e.printStackTrace();
        } finally {// 关闭资源
            try {
                httpResponse.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            closeableHttpClient.close(); // 关闭连接、释放资源
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }
}
