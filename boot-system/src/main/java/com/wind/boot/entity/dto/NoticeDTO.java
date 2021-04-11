package com.wind.boot.entity.dto;

import java.util.Date;
import com.wind.boot.config.persistence.BaseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 公告 model
 * @author wind
 * @date 2021/04/06 21:40:31
 * @version V1.0
 */
public class NoticeDTO extends BaseDTO {

    private Integer id;

    /** 通告内容*/
    private String info;

    /** 发布时间*/
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")
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