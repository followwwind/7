package com.wind.boot.config;

import com.wind.boot.config.message.BaseCode;

/**
 * @Title: BusinessCode
 * @Package com.wind.business.config
 * @Description: 业务代码code
 * @author huanghy
 * @date 2018/11/22 9:07
 * @version V1.0
 */
public enum BusinessCode implements BaseCode {

    GOOD_NOT_FOUND(200000,"商品未找到")
    ;

    private final Integer code;

    private final String msg;

    BusinessCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }

    public static BusinessCode valueOf(int code) {
        for (BusinessCode status : values()) {
            if (status.code == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("No matching constant for [" + code + "]");
    }

    public boolean equalCode(Integer code) {
        return this.code.equals(code);
    }
}