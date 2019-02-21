package com.xicheng.token.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author xichengxml
 * @date 2019/2/21 13:55
 */
@Getter
@Setter
public class AccessEntity {

    private String name;
    private String pwd;
    private String token;
    private String sign;
}
