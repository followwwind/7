package com.wind.boot.entity.po;

import java.util.Date;
import com.wind.boot.config.persistence.BasePO;

/**
 * 公告 model
 * @author wind
 * @date 2021/04/06 21:40:31
 * @version V1.0
 */
public class Notice extends BasePO {

    private Integer id;

    /** 通告内容*/
    private String info;

    /** 发布时间*/
    private Date createTime;

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return this.id;
    }

    public void setInfo(String info){
        this.info = info;
    }

    public String getInfo(){
        return this.info;
    }

    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    public Date getCreateTime(){
        return this.createTime;
    }
}