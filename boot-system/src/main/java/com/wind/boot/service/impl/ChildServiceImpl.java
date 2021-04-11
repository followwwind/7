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
import com.wind.boot.dao.ChildMapper;
import com.wind.boot.service.ChildService;
import com.wind.boot.entity.po.Child;
import com.wind.boot.entity.vo.ChildVO;
import com.wind.boot.entity.dto.ChildDTO;
import com.wind.boot.entity.dto.ChildSearchDTO;
import com.baidu.unbiz.fluentvalidator.annotation.FluentValid;

/**
 * child service
 * @author wind
 * @date 2021/04/11 16:20:22
 * @version V1.0
 */
@Service
public class ChildServiceImpl implements ChildService{

	private Logger logger = LoggerFactory.getLogger(ChildServiceImpl.class);

    @Autowired
    private ChildMapper mapper;

    @Override
    public int save(@FluentValid(groups = Add.class) ChildDTO r) {
    	logger.info("ChildServiceImpl.save param: r is {}", r);
        Child entity = new Child();
        BeanUtil.copy(r, entity);
        entity.setCreateTime(new Date());
        return mapper.insert(entity);
    }

    @Override
    public int delete(Integer id) {
    	logger.info("ChildServiceImpl.delete param: id is {}", id);
        return mapper.deleteById(id);
    }

    @Override
    public ChildVO get(Integer id) {
    	logger.info("ChildServiceImpl.get param: id is {}", id);
        return mapper.findById(id);
    }

    @Override
    public int update(@FluentValid(groups = Update.class) ChildDTO r) {
    	logger.info("ChildServiceImpl.update param: r is {}", r);
        Child entity = new Child();
        BeanUtil.copy(r, entity);
        return mapper.update(entity);
    }

    @Override
    public List<ChildVO> list(ChildSearchDTO r) {
    	logger.info("ChildServiceImpl.list param: r is {}", r);
        return mapper.list(r);
    }
}
