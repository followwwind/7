package com.wind.boot.entity.dto;

import com.wind.boot.config.persistence.BaseDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * @Title: LoginQ
 * @Package com.wind.boot.entity.query
 * @Description: 登录
 * @author wind
 * @date 2019/2/26 12:36
 * @version V1.0
 */
public class LoginDTO extends BaseDTO {

    /**
     * 登录账号
     */
    @NotBlank(message = "登录账号不能为空")
    private String username;

    /**
     * 密码
     */
    @NotBlank(message = "登录密码不能为空")
    private String password;

    /**
     * 登录类型
     */
    @NotNull(message = "登录类型不能为空")
    private Integer loginType;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getLoginType() {
        return loginType;
    }

    public void setLoginType(Integer loginType) {
        this.loginType = loginType;
    }
}
