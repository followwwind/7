package com.wind.boot.entity.dto;

import java.util.Date;
import com.wind.boot.config.persistence.BaseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 用户表 model
 * @author wind
 * @date 2021/04/06 21:40:31
 * @version V1.0
 */
public class UserDTO extends BaseDTO {

    private Integer id;

    /** 账号*/
    private String username;

    /** 密码*/
    private String password;

    /** 昵称*/
    private String name;

    /** 用户类型,1接种方，2社区医院方*/
    private Integer type;

    /** 创建日期*/
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")
    private Date createTime;

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return this.id;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return this.username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setType(Integer type){
        this.type = type;
    }

    public Integer getType(){
        return this.type;
    }

    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    public Date getCreateTime(){
        return this.createTime;
    }
}