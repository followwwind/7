package com.wind.boot.entity.vo;

import java.util.Date;
import com.wind.boot.config.persistence.BaseVO;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 疫苗 model
 * @author wind
 * @date 2021/04/06 21:40:31
 * @version V1.0
 */
public class VaccineVO extends BaseVO {

    private Integer id;

    /** 名称*/
    private String name;

    /** 疫苗信息*/
    private String info;

    /** 库存*/
    private Integer count;

    /** 创建时间*/
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")
    private Date createTime;

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setInfo(String info){
        this.info = info;
    }

    public String getInfo(){
        return this.info;
    }

    public void setCount(Integer count){
        this.count = count;
    }

    public Integer getCount(){
        return this.count;
    }

    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    public Date getCreateTime(){
        return this.createTime;
    }
}