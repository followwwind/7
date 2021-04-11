package com.wind.boot.dao;

import com.wind.boot.entity.dto.UserSearchDTO;
import com.wind.boot.entity.po.User;
import com.wind.boot.config.persistence.annotation.SqlMapper;

import java.util.List;

import com.wind.boot.entity.vo.UserVO;
import org.apache.ibatis.annotations.Param;

/**
 * @Title: UserMapper
 * @Package com.wind.boot.dao
 * @Description: 用户表mapper
 * @author wind
 * @date 2020/03/19 17:17:43
 * @version V1.0
 */
@SqlMapper
public interface UserMapper{

    /**
     * 添加
     * @param r
     * @return
     */
    int insert(User r);

    /**
     * 删除
     * @param id
     * @return
     */
    int deleteById(@Param("id") Integer id);

    /**
     * 单条记录查询
     * @param id
     * @return
     */
    UserVO findById(@Param("id") Integer id);

    /**
     * 查询用户信息
     * @param username
     * @return
     */
    UserVO findByName(@Param("username") String username);

    /**
     * 修改
     * @param r
     * @return
     */
    int update(User r);


    /**
     * 删除
     * @param r
     * @return
     */
    int delete(User r);

    /**
     * 列表查询
     * @param r
     * @return
     */
    List<UserVO> list(UserSearchDTO r);

}

