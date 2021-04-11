package com.wind.boot.entity.dto;

import java.util.Date;
import com.wind.boot.config.persistence.PageQuery;

/**
 * child model
 * @author wind
 * @date 2021/04/11 16:40:22
 * @version V1.0
 */
public class ChildSearchDTO extends PageQuery {

    private Integer id;

    /** 接种方id*/
    private Integer userId;

    /** 名称*/
    private String name;

    /** 年龄*/
    private Integer age;

    /** 联系手机号*/
    private String tel;

    /** 创建时间*/
    private Date createTime;

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return this.id;
    }

    public void setUserId(Integer userId){
        this.userId = userId;
    }

    public Integer getUserId(){
        return this.userId;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setAge(Integer age){
        this.age = age;
    }

    public Integer getAge(){
        return this.age;
    }

    public void setTel(String tel){
        this.tel = tel;
    }

    public String getTel(){
        return this.tel;
    }

    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    public Date getCreateTime(){
        return this.createTime;
    }
}