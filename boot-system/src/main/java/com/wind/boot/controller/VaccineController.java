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
import com.wind.boot.service.VaccineService;
import com.wind.boot.entity.po.Vaccine;
import com.wind.boot.entity.vo.VaccineVO;
import com.wind.boot.entity.dto.VaccineDTO;
import com.wind.boot.entity.dto.VaccineSearchDTO;

/**
 * 疫苗 controller
 * @author wind
 * @date 2021/04/06 21:40:31
 * @version V1.0
 */
@RestController
@RequestMapping(value = "api/vaccine")
public class VaccineController{
	
	private final Logger logger = LoggerFactory.getLogger(VaccineController.class);
	
    @Autowired
    private VaccineService vaccineService;

    /**
     * 添加记录接口
     * @param r
     * @return
     */
    @PostMapping("/save")
    public JsonResult save(@RequestBody VaccineDTO r) {
        logger.info("VaccineController.save param: r is {}", r);
        int i = vaccineService.save(r);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 删除记录接口
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public JsonResult delete(@PathVariable("id") Integer id) {
        logger.info("VaccineController.delete param: id is {}", id);
        int i = vaccineService.delete(id);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 单条记录查询接口
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public JsonResult get(@PathVariable("id") Integer id) {
        logger.info("VaccineController.get param: id is {}", id);
        return new JsonResult(HttpCode.OK, vaccineService.get(id));
    }
    /**
     * 修改记录接口
     * @param r
     * @return
     */
    @PostMapping("/update")
    public JsonResult update(@RequestBody VaccineDTO r) {
        logger.info("VaccineController.update param: r is {}", r);
        int i = vaccineService.update(r);
        return new JsonResult(i > 0 ? HttpCode.OK : HttpCode.FAIL);
    }

    /**
     * 批量查询记录接口
     * @param r
     * @return
     */
    @PostMapping("/list")
    public JsonResult list(@RequestBody VaccineSearchDTO r) {
        logger.info("VaccineController.list param: r is {}", r);
        List<VaccineVO> list = vaccineService.list(r);
        return new JsonResult(HttpCode.OK, list);
    }

    /**
     * 分页查询记录接口
     * @param r
     * @return
     */
    @PostMapping("/page/list")
    public JsonResult pageList(@RequestBody VaccineSearchDTO r){
        logger.info("VaccineController.pageList param: r is {}", r);
        PageHelper.startPage(r.getPageNumber(), r.getLineNumber());
        List<VaccineVO> list = vaccineService.list(r);
        Page<VaccineVO> page = new Page<>(list);
        return new JsonResult(HttpCode.OK, page);
    }
}