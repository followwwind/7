package com.wind.boot.entity.enums;

import com.wind.boot.config.BaseEnum;

import java.util.Arrays;

/**
 * @Title: LoginType
 * @Package com.wind.business.entity.enums
 * @Description: 订单状态，0：未支付，1：已支付，2：取消支付
 * @author wind
 * @date 2018/10/29 19:04
 * @version V1.0
 */
public enum PayType implements BaseEnum {

    NOT_PAY(0, "未支付"),
    PAYED(1, "已支付"),
    PAY_CANCEL(2, "取消支付");

    PayType(Integer code, String value){
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
