package com.wind.boot.controller;

import com.wind.boot.config.message.JsonResult;
import com.wind.boot.config.message.HttpCode;
import com.wind.boot.config.persistence.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageHelper;
import java.util.List;
import com.wind.boot.service.ChildService;
import com.wind.boot.entity.po.Child;
import com.wind.boot.entity.vo.ChildVO;
import com.wind.boot.entity.dto.ChildDTO;
import com.wind.boot.entity.dto.ChildSearchDTO;

/**
 * child controller
 * @author wind
 * @date 2021/04/11 16:20:22
 * @version V1.0
 */
@RestController
@RequestMapping(value = "api/child")
public class ChildController{
	
	private final Logger logger = LoggerFactory.getLogger(ChildController.class);
	
    @Autowired
    private ChildService childService;

    /**
     * 添加记录接口
     * @param r
     * @return
     */
    @PostMapping("/save")
    public JsonResult save(@RequestBody ChildDTO r) {
        logger.info("ChildController.save param: r is {}", r);
        int i = childService.save(r);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 删除记录接口
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public JsonResult delete(@PathVariable("id") Integer id) {
        logger.info("ChildController.delete param: id is {}", id);
        int i = childService.delete(id);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 单条记录查询接口
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public JsonResult get(@PathVariable("id") Integer id) {
        logger.info("ChildController.get param: id is {}", id);
        return new JsonResult(HttpCode.OK, childService.get(id));
    }
    /**
     * 修改记录接口
     * @param r
     * @return
     */
    @PostMapping("/update")
    public JsonResult update(@RequestBody ChildDTO r) {
        logger.info("ChildController.update param: r is {}", r);
        int i = childService.update(r);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 批量查询记录接口
     * @param r
     * @return
     */
    @PostMapping("/list")
    public JsonResult list(@RequestBody ChildSearchDTO r) {
        logger.info("ChildController.list param: r is {}", r);
        List<ChildVO> list = childService.list(r);
        return new JsonResult(HttpCode.OK, list);
    }

    /**
     * 分页查询记录接口
     * @param r
     * @return
     */
    @PostMapping("/page/list")
    public JsonResult pageList(@RequestBody ChildSearchDTO r){
        logger.info("ChildController.pageList param: r is {}", r);
        PageHelper.startPage(r.getPageNumber(), r.getLineNumber());
        List<ChildVO> list = childService.list(r);
        Page<ChildVO> page = new Page<>(list);
        return new JsonResult(HttpCode.OK, page);
    }
}