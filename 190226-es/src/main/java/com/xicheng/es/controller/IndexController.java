package com.xicheng.es.controller;

import com.google.gson.Gson;
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
 * @date 2019/2/27 14:42
 * 测试es6.2以上不支持单个索引下多个type
 */
@Controller
public class IndexController {

    private static final String INDEX_NAME = "multi-type4";
    private static final Gson GSON = new Gson();

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    /**
     * 1. 创建索引
     * 2. 向type1添加数据
     * 3. 向type2添加数据，会报错，不支持多type
     */
    @RequestMapping("/multi-type")
    @ResponseBody
    public void mutliType() {
        if (!elasticsearchTemplate.indexExists(INDEX_NAME)) {
            elasticsearchTemplate.createIndex(INDEX_NAME);
        }
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("field1", "field2");
        IndexQuery indexQuery = new IndexQueryBuilder().withIndexName(INDEX_NAME)
                .withType("type9").withId("1").withSource(GSON.toJson(paramMap)).build();
        elasticsearchTemplate.index(indexQuery);
        IndexQuery indexQuery2 = new IndexQueryBuilder().withIndexName(INDEX_NAME)
                .withType("type10").withId("1").withSource(GSON.toJson(paramMap)).build();
        elasticsearchTemplate.index(indexQuery2);

    }
}
