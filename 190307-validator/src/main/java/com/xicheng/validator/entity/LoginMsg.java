package com.xicheng.validator.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @author xichengxml
 * @date 2019/3/7 10:02
 */
@Data
public class LoginMsg {

    @NotBlank(message = "用户名不能为空")
    @Email
    private String uname;

    @NotBlank(message = "密码不能为空")
    @Length(min = 6, message = "密码长度至少6位")
    private String pwd;
}
