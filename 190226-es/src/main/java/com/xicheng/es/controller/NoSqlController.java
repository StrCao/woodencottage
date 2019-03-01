package com.xicheng.es.controller;

import com.google.gson.Gson;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xichengxml
 * @date 2019/3/1 9:41
 * 测试es的NoSQL特性，在同一个索引库、同一个表中插入不同结构化数据
 */
@Controller
public class NoSqlController {

    private static final String INDEX_NAME = "nosql";
    private static final String TYPE_NAME = "type";
    private static final Gson GSON = new Gson();

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @RequestMapping("/nosql")
    @ResponseBody
    public String noSql() {
        if (!elasticsearchTemplate.indexExists(INDEX_NAME)) {
            elasticsearchTemplate.createIndex(INDEX_NAME);
        }

        Map<String, String> paramMap1 = new HashMap<>();
        paramMap1.put("key1", "value1");

        Map<String, Integer> paramMap2 = new HashMap<>();
        paramMap2.put("key2", 2);
        paramMap2.put("key3", 3);

        // 插入数据
        IndexQuery indexQuery = new IndexQueryBuilder().withIndexName(INDEX_NAME)
                .withType("type").withId("1").withSource(GSON.toJson(paramMap1)).build();
        elasticsearchTemplate.index(indexQuery);
        indexQuery = new IndexQueryBuilder().withIndexName(INDEX_NAME)
                .withType("type").withId("2").withSource(GSON.toJson(paramMap2)).build();
        elasticsearchTemplate.index(indexQuery);

        // 查询数据
        Client client = elasticsearchTemplate.getClient();
        QueryBuilder queryBuilder1 = QueryBuilders.boolQuery()
                .must(QueryBuilders.matchQuery("_id", "1"));
        SearchResponse response = client.prepareSearch(INDEX_NAME)
                .setTypes(TYPE_NAME)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(queryBuilder1)
                .execute()
                .actionGet();
        SearchHit[] hits1 = response.getHits().getHits();
        SearchHit searchHitFields = hits1[0];
        Map<String, Object> sourceAsMap = searchHitFields.getSourceAsMap();
        QueryBuilder queryBuilder2 = QueryBuilders.boolQuery()
                .must(QueryBuilders.matchQuery("_id", "2"));
        response = client.prepareSearch(INDEX_NAME)
                .setTypes(TYPE_NAME)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(queryBuilder2)
                .execute()
                .actionGet();
        SearchHit[] hits2 = response.getHits().getHits();
        searchHitFields = hits2[0];
        Map<String, Object> sourceAsMap1 = searchHitFields.getSourceAsMap();
        return GSON.toJson(sourceAsMap) + "-----" + GSON.toJson(sourceAsMap1);
    }
}
