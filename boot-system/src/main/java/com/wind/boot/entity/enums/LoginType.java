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
public enum LoginType implements BaseEnum {

    PASSWORD(1, "密码登陆"),
    CAPTCHA(2, "验证码登陆");

    LoginType(Integer code, String value){
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

    public static LoginType getLoginType(Integer code) {
        return Arrays.stream(values()).filter(ele -> ele.getCode().equals(code))
                .findFirst().map(v -> valueOf(v.name())).orElse(null);
    }

    @Override
    public boolean equalCode(Integer code) {
        return this.code.equals(code);
    }

}
