package com.xicheng.validator.response;

/**
 * @author xichengxml
 * @date 2019/3/7 17:33
 */
public class ResponseResult {

    private String message;
    private String body;

    public ResponseResult() {
    }

    public ResponseResult(String message, String body) {
        this.message = message;
        this.body = body;
    }
}
