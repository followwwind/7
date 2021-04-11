package com.wind.boot.entity.enums;

import com.wind.boot.config.BaseEnum;

import java.util.Arrays;

/**
 * @Title: LoginType
 * @Package com.wind.business.entity.enums
 * @Description: TODO
 * @author wind
 * @date 2018/10/29 19:04
 * @version V1.0
 */
public enum SmsType implements BaseEnum {

    LOGIN(1, "登陆"),
    REGISTER(2, "注册"),
    PASSWORD_FOUND(3, "密码找回");

    SmsType(Integer code, String value){
        this.code = code;
        this.value = value;
    }

    private Integer code;

    private String value;


    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }


    @Override
    public boolean equalCode(Integer code) {
        return this.code.equals(code);
    }

}
