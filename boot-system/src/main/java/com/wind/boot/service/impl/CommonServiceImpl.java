package com.wind.boot.service.impl;

import com.baidu.unbiz.fluentvalidator.annotation.FluentValid;
import com.wind.boot.config.message.HttpCode;
import com.wind.boot.config.message.JsonResult;
import com.wind.boot.dao.UserMapper;
import com.wind.boot.entity.enums.LoginType;
import com.wind.boot.entity.po.User;
import com.wind.boot.entity.dto.LoginDTO;
import com.wind.boot.entity.dto.RegisterDTO;
import com.wind.boot.entity.vo.UserVO;
import com.wind.boot.service.CommonService;
import com.wind.boot.util.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Title: CommonServiceImpl
 * @Package com.wind.boot.service.impl
 * @Description: TODO
 * @author wind
 * @date 2019/11/26 10:49
 * @version V1.0
 */
@Service
public class CommonServiceImpl implements CommonService {

    private Logger logger = LoggerFactory.getLogger(CommonServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public JsonResult login(@FluentValid LoginDTO loginQ) {
        logger.info("CommonServiceImpl.login params: loginQ is {}", loginQ);
        String username = loginQ.getUsername();
        String password = loginQ.getPassword();
        Integer loginType = loginQ.getLoginType();
        UserVO user = userMapper.findByName(username);
        if(user == null){
            return HttpCode.USER_NOT_FOUND.getJsonResult();
        }

        boolean flag;
        if(LoginType.CAPTCHA.equalCode(loginType)){
            flag = "123456".equals(password);
        }else{
            flag = password.equals(user.getPassword());
        }

        JsonResult result = new JsonResult(flag ? HttpCode.OK : HttpCode.USER_LOGIN_FAIL);
        if(flag){
            user.setPassword("");
            result.setData(user);
        }
        return result;
    }

    @Override
    public JsonResult register(@FluentValid RegisterDTO registerQ) {
        logger.info("CommonServiceImpl.register params: registerQ is {}", registerQ);
        String username = registerQ.getUsername();
        UserVO user = userMapper.findByName(username);
        if(user != null){
            return HttpCode.LOGIN_NAME_ALREADY_EXISTS.getJsonResult();
        }
        User r = new User();
        BeanUtil.copy(registerQ, username);
        r.setCreateTime(new Date());
        int i = userMapper.insert(r);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }
}
