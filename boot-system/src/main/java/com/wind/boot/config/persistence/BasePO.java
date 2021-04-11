package com.wind.boot.config.persistence;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @Title: BaseDO
 * @Package com.wind.webapi.persistence
 * @Description: 基础DO实体类
 * @author wind
 * @date 2018/9/17 17:43
 * @version V1.0
 */
public abstract class BasePO implements Serializable {

	private static final long serialVersionUID = 1L;

	
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
    
}
