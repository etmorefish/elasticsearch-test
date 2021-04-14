package com.xxml.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.MaxAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;

import javax.naming.directory.SearchResult;
import java.io.IOException;

public class ESTest_Doc_Query {
    public static void main(String[] args) throws IOException {
        // 创建客户端对象
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );

        //Query
        //1. search all data
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("user");

//        searchRequest.source(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()));
//
//        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHits hits = searchResponse.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(searchResponse.getTook());
//
//        hits.forEach(hit -> {
//            System.out.println(hit.getSourceAsString());
//        });

//        // 2. query: termQuery
//        searchRequest.source(new SearchSourceBuilder().query(QueryBuilders.termQuery("age", "18")));
//
//        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHits hits = searchResponse.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(searchResponse.getTook());
//
//        hits.forEach(hit -> {
//            System.out.println(hit.getSourceAsString());
//        });


//        // 3. page query: termQuery
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        // 分页查询
//        // 当前页其实索引(第一条数据的顺序号),from
//        builder.from(0);
//        builder.size(2);
//
//        searchRequest.source(builder);
//
//        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHits hits = searchResponse.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(searchResponse.getTook());
//
//        hits.forEach(hit -> {
//            System.out.println(hit.getSourceAsString());
//        });


//        // 4. sort query
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//
//        // sort by age
//        builder.sort("age", SortOrder.DESC);
//        searchRequest.source(builder);
//
//        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHits hits = searchResponse.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(searchResponse.getTook());
//
//        hits.forEach(hit -> {
//            System.out.println(hit.getSourceAsString());
//        });


//        // 5. filter fields  query
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//
//        //
//        String [] excludes = {"age"};
//        String [] includes = {};
//        builder.fetchSource(includes, excludes);
//
//        searchRequest.source(builder);
//        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
//
//        SearchHits hits = searchResponse.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(searchResponse.getTook());
//
//        hits.forEach(hit -> {
//            System.out.println(hit.getSourceAsString());
//        });


//        // 6. bool  query
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//
////        boolQueryBuilder.must(QueryBuilders.matchQuery("age", 20));
////        boolQueryBuilder.must(QueryBuilders.matchQuery("sex", "F"));
////        boolQueryBuilder.mustNot(QueryBuilders.matchQuery("age", 20));
//        boolQueryBuilder.should(QueryBuilders.matchQuery("age", 20));
//        boolQueryBuilder.should(QueryBuilders.matchQuery("age", 30));
//
//        builder.query(boolQueryBuilder);
//
//        searchRequest.source(builder);
//        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
//
//        SearchHits hits = searchResponse.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(searchResponse.getTook());
//
//        hits.forEach(hit -> {
//            System.out.println(hit.getSourceAsString());
//        });


//        // 7. range between  query
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("age");
//
//        rangeQuery.gte(30);
//        rangeQuery.lte(50);
//
//        builder.query(rangeQuery);
//
//        searchRequest.source(builder);
//        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
//
//        SearchHits hits = searchResponse.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(searchResponse.getTook());
//
//        hits.forEach(hit -> {
//            System.out.println(hit.getSourceAsString());
//        });


//        // 9. fuzzy  query
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        FuzzyQueryBuilder fuzzyQuery = QueryBuilders.fuzzyQuery("name", "anta").fuzziness(Fuzziness.TWO);
//
//        builder.query(fuzzyQuery);
//
//        searchRequest.source(builder);
//        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
//
//        SearchHits hits = searchResponse.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(searchResponse.getTook());
//
//        hits.forEach(hit -> {
//            System.out.println(hit.getSourceAsString());
//        });


//        // 10. highlight  query
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        TermsQueryBuilder termsQueryBuilder = QueryBuilders.termsQuery("name", "anta");
//
//        HighlightBuilder highlightBuilder = new HighlightBuilder();
//        highlightBuilder.preTags("<font color='red'>");
//        highlightBuilder.postTags("</font>");
//        highlightBuilder.field("name");
//
//        builder.highlighter(highlightBuilder);
//        builder.query(termsQueryBuilder);
//
//        searchRequest.source(builder);
//        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
//
//        SearchHits hits = searchResponse.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(searchResponse.getTook());
//
//        hits.forEach(hit -> {
//            System.out.println(hit.getSourceAsString());
//            System.out.println(hit);
//        });


//        // 11. agg  query
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//
//        MaxAggregationBuilder aggregationBuilder = AggregationBuilders.max("maxAge").field("age");
//
//        builder.aggregation(aggregationBuilder);
//
//        searchRequest.source(builder);
//        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
//
//        SearchHits hits = searchResponse.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(searchResponse.getTook());
//
//        hits.forEach(hit -> {
//            System.out.println(hit.getSourceAsString());
////            System.out.println(hit);
//        });


        // 12.  group query
        SearchSourceBuilder builder = new SearchSourceBuilder();

        TermsAggregationBuilder aggregationBuilder = AggregationBuilders.terms("ageGroup").field("age");

        builder.aggregation(aggregationBuilder);

        searchRequest.source(builder);
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

        SearchHits hits = searchResponse.getHits();

        System.out.println(hits.getTotalHits());
        System.out.println(searchResponse.getTook());

        hits.forEach(hit -> {
            System.out.println(hit.getSourceAsString());
//            System.out.println(hit);
        });







        System.out.println(searchResponse.toString());
        // 关闭客户端连接
        client.close();
    }
}
