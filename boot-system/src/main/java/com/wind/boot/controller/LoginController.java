package com.wind.boot.controller;

import com.wind.boot.config.message.JsonResult;
import com.wind.boot.entity.dto.LoginDTO;
import com.wind.boot.entity.dto.RegisterDTO;
import com.wind.boot.service.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Title: UserController
 * @Package com.wind.boot.controller
 * @Description: 用户登录
 * @author wind
 * @date 2020/03/19 17:17:43
 * @version V1.0
 */
@RestController
@RequestMapping(value = "api/")
public class LoginController {
	
	private Logger logger = LoggerFactory.getLogger(LoginController.class);
	
    @Autowired
    private CommonService commonService;

    /**
     * 登录
     * api/login
     * @param r
     * @return
     */
    @PostMapping("/login")
    public JsonResult login(@RequestBody LoginDTO r) {
    	logger.info("LoginController.login param: r is {}", r);
        return commonService.login(r);
    }

    /**
     * 注册
     * api/reg
     * @param r
     * @return
     */
    @PostMapping("/reg")
    public JsonResult reg(@RequestBody RegisterDTO r) {
        logger.info("LoginController.reg param: r is {}", r);
        return commonService.register(r);
    }

}
