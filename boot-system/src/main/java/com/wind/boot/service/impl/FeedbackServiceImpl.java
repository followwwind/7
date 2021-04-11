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
import com.wind.boot.dao.FeedbackMapper;
import com.wind.boot.service.FeedbackService;
import com.wind.boot.entity.po.Feedback;
import com.wind.boot.entity.vo.FeedbackVO;
import com.wind.boot.entity.dto.FeedbackDTO;
import com.wind.boot.entity.dto.FeedbackSearchDTO;
import com.baidu.unbiz.fluentvalidator.annotation.FluentValid;

/**
 * 反馈 service
 * @author wind
 * @date 2021/04/06 21:40:31
 * @version V1.0
 */
@Service
public class FeedbackServiceImpl implements FeedbackService{

	private Logger logger = LoggerFactory.getLogger(FeedbackServiceImpl.class);

    @Autowired
    private FeedbackMapper mapper;

    @Override
    public int save(@FluentValid(groups = Add.class) FeedbackDTO r) {
    	logger.info("FeedbackServiceImpl.save param: r is {}", r);
        Feedback entity = new Feedback();
        BeanUtil.copy(r, entity);
        entity.setCreateTime(new Date());
        return mapper.insert(entity);
    }

    @Override
    public int delete(Integer id) {
    	logger.info("FeedbackServiceImpl.delete param: id is {}", id);
        return mapper.deleteById(id);
    }

    @Override
    public FeedbackVO get(Integer id) {
    	logger.info("FeedbackServiceImpl.get param: id is {}", id);
        return mapper.findById(id);
    }

    @Override
    public int update(@FluentValid(groups = Update.class) FeedbackDTO r) {
    	logger.info("FeedbackServiceImpl.update param: r is {}", r);
        Feedback entity = new Feedback();
        BeanUtil.copy(r, entity);
        return mapper.update(entity);
    }

    @Override
    public List<FeedbackVO> list(FeedbackSearchDTO r) {
    	logger.info("FeedbackServiceImpl.list param: r is {}", r);
        return mapper.list(r);
    }
}
