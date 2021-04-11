package com.wind.boot.entity.po;

import java.util.Date;
import com.wind.boot.config.persistence.BasePO;

/**
 * child model
 * @author wind
 * @date 2021/04/06 21:40:31
 * @version V1.0
 */
public class Order extends BasePO {

    private Integer id;

    /** 接种方id*/
    private Integer userId;

    /** 幼儿名称*/
    private String name;

    /** 疫苗id*/
    private Integer vaccineId;

    /** 状态，1:预约，2：已接种*/
    private Integer status;

    /** 预约时间*/
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

    public void setVaccineId(Integer vaccineId){
        this.vaccineId = vaccineId;
    }

    public Integer getVaccineId(){
        return this.vaccineId;
    }

    public void setStatus(Integer status){
        this.status = status;
    }

    public Integer getStatus(){
        return this.status;
    }

    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    public Date getCreateTime(){
        return this.createTime;
    }
}