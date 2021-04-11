package com.wind.boot.entity.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.wind.boot.config.persistence.BaseVO;

import java.util.Date;

/**
 * @Title: ExcelVO
 * @Package com.wind.boot.entity.vo
 * @Description: excel注解导出
 * @author wind
 * @date 2019/3/4 20:36
 * @version V1.0
 */
public class ExcelVO extends BaseVO {

    @Excel(name = "id", orderNum = "1")
    private Integer id;

    @Excel(name = "name", orderNum = "2")
    private String name;

    @Excel(name = "age", orderNum = "3")
    private Integer age;

    @Excel(name = "createTime", orderNum = "4", format = "yyyy-MM-dd")
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
