package com.wind.boot.entity.po;

import java.util.Date;
import com.wind.boot.config.persistence.BasePO;

/**
 * 反馈 model
 * @author wind
 * @date 2021/04/06 21:40:31
 * @version V1.0
 */
public class Feedback extends BasePO {

    private Integer id;

    /** 接种方id*/
    private Integer userId;

    /** 反馈内容*/
    private String content;

    /** 反馈时间*/
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

    public void setContent(String content){
        this.content = content;
    }

    public String getContent(){
        return this.content;
    }

    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    public Date getCreateTime(){
        return this.createTime;
    }
}