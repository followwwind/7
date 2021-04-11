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
public abstract class BaseDO<T> extends BasePO {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	protected T id;
	

	public BaseDO() {
	}
	
	public BaseDO(T id) {
		this();
		this.id = id;
	}

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}
}
