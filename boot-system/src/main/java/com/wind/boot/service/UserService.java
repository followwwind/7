package com.wind.boot.service;

import java.util.List;
import com.wind.boot.entity.po.User;
import com.wind.boot.entity.vo.UserVO;
import com.wind.boot.entity.dto.UserDTO;
import com.wind.boot.entity.dto.UserSearchDTO;

/**
 * 用户表 service
 * @author wind
 * @date 2021/04/06 21:40:31
 * @version V1.0
 */
public interface UserService{

    /**
     * 添加
     * @param r
     * @return
     */
    int save(UserDTO r);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 单条记录查询
     * @param id
     * @return
     */
    UserVO get(Integer id);

    /**
     * 修改
     * @param r
     * @return
     */
    int update(UserDTO r);

    /**
     * 批量查询记录
     * @param r
     * @return
     */
    List<UserVO> list(UserSearchDTO r);
}