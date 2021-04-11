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
import com.wind.boot.service.NoticeService;
import com.wind.boot.entity.po.Notice;
import com.wind.boot.entity.vo.NoticeVO;
import com.wind.boot.entity.dto.NoticeDTO;
import com.wind.boot.entity.dto.NoticeSearchDTO;

/**
 * 公告 controller
 * @author wind
 * @date 2021/04/06 21:40:31
 * @version V1.0
 */
@RestController
@RequestMapping(value = "api/notice")
public class NoticeController{
	
	private final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
    @Autowired
    private NoticeService noticeService;

    /**
     * 添加记录接口
     * @param r
     * @return
     */
    @PostMapping("/save")
    public JsonResult save(@RequestBody NoticeDTO r) {
        logger.info("NoticeController.save param: r is {}", r);
        int i = noticeService.save(r);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 删除记录接口
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public JsonResult delete(@PathVariable("id") Integer id) {
        logger.info("NoticeController.delete param: id is {}", id);
        int i = noticeService.delete(id);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 单条记录查询接口
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public JsonResult get(@PathVariable("id") Integer id) {
        logger.info("NoticeController.get param: id is {}", id);
        return new JsonResult(HttpCode.OK, noticeService.get(id));
    }
    /**
     * 修改记录接口
     * @param r
     * @return
     */
    @PostMapping("/update")
    public JsonResult update(@RequestBody NoticeDTO r) {
        logger.info("NoticeController.update param: r is {}", r);
        int i = noticeService.update(r);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 批量查询记录接口
     * @param r
     * @return
     */
    @PostMapping("/list")
    public JsonResult list(@RequestBody NoticeSearchDTO r) {
        logger.info("NoticeController.list param: r is {}", r);
        List<NoticeVO> list = noticeService.list(r);
        return new JsonResult(HttpCode.OK, list);
    }

    /**
     * 分页查询记录接口
     * @param r
     * @return
     */
    @PostMapping("/page/list")
    public JsonResult pageList(@RequestBody NoticeSearchDTO r){
        logger.info("NoticeController.pageList param: r is {}", r);
        PageHelper.startPage(r.getPageNumber(), r.getLineNumber());
        List<NoticeVO> list = noticeService.list(r);
        Page<NoticeVO> page = new Page<>(list);
        return new JsonResult(HttpCode.OK, page);
    }
}