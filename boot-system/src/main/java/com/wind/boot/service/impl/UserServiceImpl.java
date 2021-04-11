package com.wind.boot.service.impl;

import com.wind.boot.config.validation.group.Add;
import com.wind.boot.config.validation.group.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Date;
import com.wind.boot.util.BeanUtil;
import com.wind.boot.dao.UserMapper;
import com.wind.boot.service.UserService;
import com.wind.boot.entity.po.User;
import com.wind.boot.entity.vo.UserVO;
import com.wind.boot.entity.dto.UserDTO;
import com.wind.boot.entity.dto.UserSearchDTO;
import com.baidu.unbiz.fluentvalidator.annotation.FluentValid;

/**
 * 用户表 service
 * @author wind
 * @date 2021/04/06 21:40:31
 * @version V1.0
 */
@Service
public class UserServiceImpl implements UserService{

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper mapper;

    @Override
    public int save(@FluentValid(groups = Add.class) UserDTO r) {
    	logger.info("UserServiceImpl.save param: r is {}", r);
        User entity = new User();
        BeanUtil.copy(r, entity);
        entity.setCreateTime(new Date());
        return mapper.insert(entity);
    }

    @Override
    public int delete(Integer id) {
    	logger.info("UserServiceImpl.delete param: id is {}", id);
        return mapper.deleteById(id);
    }

    @Override
    public UserVO get(Integer id) {
    	logger.info("UserServiceImpl.get param: id is {}", id);
        return mapper.findById(id);
    }

    @Override
    public int update(@FluentValid(groups = Update.class) UserDTO r) {
    	logger.info("UserServiceImpl.update param: r is {}", r);
        User entity = new User();
        BeanUtil.copy(r, entity);
        return mapper.update(entity);
    }

    @Override
    public List<UserVO> list(UserSearchDTO r) {
    	logger.info("UserServiceImpl.list param: r is {}", r);
        return mapper.list(r);
    }
}
