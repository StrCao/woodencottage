package com.xicheng.es.controller;

import com.google.gson.Gson;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeAction;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeRequestBuilder;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xichengxml
 * @date 2019/2/26 18:23
 * 测试通过标准分词器和ik分词器分词之后的分词结果
 */
@Controller
public class AnalyzerController {

    private static final Gson GSON = new Gson();

    /**
     * 索引名
     */
    private static final String IK_NAME = "ik";
    private static final String STANDARD_NAME = "standard";

    /**
     * 文本内容
     */
    private static final String CONTENT = "中华人民共和国";

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @RequestMapping("/standard")
    @ResponseBody
    public String standard() {
        createIndex(STANDARD_NAME);

        List<String> resultList = getAnalyzeResult(STANDARD_NAME, STANDARD_NAME);
        return GSON.toJson(resultList);
    }

    @RequestMapping("/ik")
    @ResponseBody
    public String ik() {
        createIndex(IK_NAME);

        List<String> resultList = getAnalyzeResult(IK_NAME, IK_NAME);
        return GSON.toJson(resultList);
    }

    /**
     * 创建索引
     * @param indexName
     */
    private void createIndex(String indexName) {
        if (!elasticsearchTemplate.indexExists(indexName)) {
            elasticsearchTemplate.createIndex(indexName);
        }
    }

    /**
     * 根据保存内容获取分词结果
     * @param analyzer 不同的分词器
     * @param indexName
     * @return
     */
    private List<String> getAnalyzeResult(String indexName, String analyzer) {
        AnalyzeRequestBuilder ikRequest = new AnalyzeRequestBuilder(elasticsearchTemplate.getClient(),
                AnalyzeAction.INSTANCE, indexName, CONTENT);
        ikRequest.setTokenizer(analyzer);
        List<AnalyzeResponse.AnalyzeToken> tokenList = ikRequest.execute().actionGet().getTokens();
        List<String> searchTermList = new ArrayList<>();
        tokenList.forEach(ikToken -> { searchTermList.add(ikToken.getTerm()); });
        return searchTermList;
    }

}
