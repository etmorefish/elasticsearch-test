package com.xxml.es.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

public class ESTest_Doc_Update {
    public static void main(String[] args) throws IOException {
        // 创建客户端对象
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );

        // 修改数据
        UpdateRequest updateRequest = new UpdateRequest();
        // 配置修改参数
        updateRequest.index("user").id("1001");
        // 设置请求体,对数据进行修改
        updateRequest.doc(XContentType.JSON, "sex", "womensESTest_Doc_Insert");


        UpdateResponse update = client.update(updateRequest, RequestOptions.DEFAULT);

        System.out.println(update.getResult());
        System.out.println("_index: " + update.getIndex());
        System.out.println("_id: " + update.getId());
        System.out.println("_result: " + update.getResult());

        // 关闭客户端连接
        client.close();
    }
}
