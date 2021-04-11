package com.wind.boot.service;

import com.wind.boot.config.message.JsonResult;
import com.wind.boot.entity.dto.LoginDTO;
import com.wind.boot.entity.dto.RegisterDTO;

/**
 * @Title: CommonService
 * @Package com.wind.boot.service
 * @Description: 公共服务
 * @author wind
 * @date 2019/11/26 10:48
 * @version V1.0
 */
public interface CommonService {

    /**
     * 登录
     * @param loginQ
     * @return
     */
    JsonResult login(LoginDTO loginQ);

    /**
     * 注册
     * @param registerQ
     * @return
     */
    JsonResult register(RegisterDTO registerQ);
}
