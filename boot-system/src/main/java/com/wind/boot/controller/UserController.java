package com.wind.boot.controller;

import com.wind.boot.config.message.JsonResult;
import com.wind.boot.config.message.HttpCode;
import com.wind.boot.config.persistence.Page;
import com.wind.boot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageHelper;
import java.util.List;

import com.wind.boot.entity.vo.UserVO;
import com.wind.boot.entity.dto.UserDTO;
import com.wind.boot.entity.dto.UserSearchDTO;

/**
 * 用户表 controller
 * @author wind
 * @date 2021/04/06 21:40:31
 * @version V1.0
 */
@RestController
@RequestMapping(value = "api/user")
public class UserController{
	
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	
    @Autowired
    private UserService userService;

    /**
     * 添加记录接口
     * @param r
     * @return
     */
    @PostMapping("/save")
    public JsonResult save(@RequestBody UserDTO r) {
        logger.info("UserController.save param: r is {}", r);
        int i = userService.save(r);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 删除记录接口
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public JsonResult delete(@PathVariable("id") Integer id) {
        logger.info("UserController.delete param: id is {}", id);
        int i = userService.delete(id);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 单条记录查询接口
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public JsonResult get(@PathVariable("id") Integer id) {
        logger.info("UserController.get param: id is {}", id);
        return new JsonResult(HttpCode.OK, userService.get(id));
    }
    /**
     * 修改记录接口
     * @param r
     * @return
     */
    @PostMapping("/update")
    public JsonResult update(@RequestBody UserDTO r) {
        logger.info("UserController.update param: r is {}", r);
        int i = userService.update(r);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 批量查询记录接口
     * @param r
     * @return
     */
    @PostMapping("/list")
    public JsonResult list(@RequestBody UserSearchDTO r) {
        logger.info("UserController.list param: r is {}", r);
        List<UserVO> list = userService.list(r);
        return new JsonResult(HttpCode.OK, list);
    }

    /**
     * 分页查询记录接口
     * @param r
     * @return
     */
    @PostMapping("/page/list")
    public JsonResult pageList(@RequestBody UserSearchDTO r){
        logger.info("UserController.pageList param: r is {}", r);
        PageHelper.startPage(r.getPageNumber(), r.getLineNumber());
        List<UserVO> list = userService.list(r);
        Page<UserVO> page = new Page<>(list);
        return new JsonResult(HttpCode.OK, page);
    }
}