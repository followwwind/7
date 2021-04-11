package com.wind.boot.entity.dto;

import com.wind.boot.config.persistence.BaseDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Title: RegisterQ
 * @Package com.wind.boot.entity.query
 * @Description: 注册
 * @author wind
 * @date 2019/2/26 13:40
 * @version V1.0
 */
public class RegisterDTO extends BaseDTO {

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    private String img;

    @NotNull(message = "用户类型不能为空")
    private Integer type;

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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
