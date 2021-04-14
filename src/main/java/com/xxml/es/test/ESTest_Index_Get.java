package com.xxml.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

import java.io.IOException;

public class ESTest_Index_Get {
    public static void main(String[] args) throws IOException {
        // 创建客户端对象
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );

        //查看索引
        GetIndexRequest user = new GetIndexRequest("user");
        // 发送请求获取响应
        GetIndexResponse getIndexResponse = client.indices().get(user, RequestOptions.DEFAULT);
        System.out.println("Aliases: " + getIndexResponse.getAliases());
        System.out.println("Mappings: " + getIndexResponse.getMappings());
        System.out.println("Settings: " + getIndexResponse.getSettings());

        // 关闭客户端连接
        client.close();
    }
}
