package com.xicheng.springboot.config;

/**
 * @author xichengxml
 * @date 2018/12/19
 * @description
 */
public class XMLConfiguration {
    private String globalVal;
    private String localVal;

    public String getLocalVal() {
        return localVal;
    }

    public void setLocalVal(String localVal) {
        this.localVal = localVal;
    }

    public String getGlobalVal() {

        return globalVal;
    }

    public void setGlobalVal(String globalVal) {
        this.globalVal = globalVal;
    }
}
