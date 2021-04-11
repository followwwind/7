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
import com.wind.boot.service.FeedbackService;
import com.wind.boot.entity.po.Feedback;
import com.wind.boot.entity.vo.FeedbackVO;
import com.wind.boot.entity.dto.FeedbackDTO;
import com.wind.boot.entity.dto.FeedbackSearchDTO;

/**
 * 反馈 controller
 * @author wind
 * @date 2021/04/06 21:40:31
 * @version V1.0
 */
@RestController
@RequestMapping(value = "api/feedback")
public class FeedbackController{
	
	private final Logger logger = LoggerFactory.getLogger(FeedbackController.class);
	
    @Autowired
    private FeedbackService feedbackService;

    /**
     * 添加记录接口
     * @param r
     * @return
     */
    @PostMapping("/save")
    public JsonResult save(@RequestBody FeedbackDTO r) {
        logger.info("FeedbackController.save param: r is {}", r);
        int i = feedbackService.save(r);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 删除记录接口
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public JsonResult delete(@PathVariable("id") Integer id) {
        logger.info("FeedbackController.delete param: id is {}", id);
        int i = feedbackService.delete(id);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 单条记录查询接口
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public JsonResult get(@PathVariable("id") Integer id) {
        logger.info("FeedbackController.get param: id is {}", id);
        return new JsonResult(HttpCode.OK, feedbackService.get(id));
    }
    /**
     * 修改记录接口
     * @param r
     * @return
     */
    @PostMapping("/update")
    public JsonResult update(@RequestBody FeedbackDTO r) {
        logger.info("FeedbackController.update param: r is {}", r);
        int i = feedbackService.update(r);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 批量查询记录接口
     * @param r
     * @return
     */
    @PostMapping("/list")
    public JsonResult list(@RequestBody FeedbackSearchDTO r) {
        logger.info("FeedbackController.list param: r is {}", r);
        List<FeedbackVO> list = feedbackService.list(r);
        return new JsonResult(HttpCode.OK, list);
    }

    /**
     * 分页查询记录接口
     * @param r
     * @return
     */
    @PostMapping("/page/list")
    public JsonResult pageList(@RequestBody FeedbackSearchDTO r){
        logger.info("FeedbackController.pageList param: r is {}", r);
        PageHelper.startPage(r.getPageNumber(), r.getLineNumber());
        List<FeedbackVO> list = feedbackService.list(r);
        Page<FeedbackVO> page = new Page<>(list);
        return new JsonResult(HttpCode.OK, page);
    }
}