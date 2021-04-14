package com.xxml.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

public class ESTest_Doc_Insert_Batch {
    public static void main(String[] args) throws IOException {
        // 创建客户端对象
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );

        BulkRequest bulkRequest = new BulkRequest();

//        bulkRequest.add(new IndexRequest().index("user").id("1001").source(XContentType.JSON, "name", "tebu", "age", 18, "sex", "F"));
//        bulkRequest.add(new IndexRequest().index("user").id("1002").source(XContentType.JSON, "name", "nike", "age", 30, "sex", "M"));
//        bulkRequest.add(new IndexRequest().index("user").id("1003").source(XContentType.JSON, "name", "zara", "age", 40, "sex", "M"));
//        bulkRequest.add(new IndexRequest().index("user").id("1004").source(XContentType.JSON, "name", "lining", "age", 50, "sex", "F"));
//        bulkRequest.add(new IndexRequest().index("user").id("1005").source(XContentType.JSON, "name", "h2o", "age", 20, "sex", "F"));
//        bulkRequest.add(new IndexRequest().index("user").id("1006").source(XContentType.JSON, "name", "anta", "age", 60, "sex", "F"));
        bulkRequest.add(new IndexRequest().index("user").id("1007").source(XContentType.JSON, "name", "anta1", "age", 60, "sex", "F"));
        bulkRequest.add(new IndexRequest().index("user").id("1008").source(XContentType.JSON, "name", "nta2", "age", 60, "sex", "F"));
        bulkRequest.add(new IndexRequest().index("user").id("1009").source(XContentType.JSON, "name", "ant", "age", 60, "sex", "F"));

        BulkResponse bulkResponse = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(bulkResponse.getTook());
        System.out.println(bulkResponse.getItems());
        // 关闭客户端连接
        client.close();
    }
}
