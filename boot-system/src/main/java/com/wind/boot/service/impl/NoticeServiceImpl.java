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
import com.wind.boot.dao.NoticeMapper;
import com.wind.boot.service.NoticeService;
import com.wind.boot.entity.po.Notice;
import com.wind.boot.entity.vo.NoticeVO;
import com.wind.boot.entity.dto.NoticeDTO;
import com.wind.boot.entity.dto.NoticeSearchDTO;
import com.baidu.unbiz.fluentvalidator.annotation.FluentValid;

/**
 * 公告 service
 * @author wind
 * @date 2021/04/06 21:40:31
 * @version V1.0
 */
@Service
public class NoticeServiceImpl implements NoticeService{

	private Logger logger = LoggerFactory.getLogger(NoticeServiceImpl.class);

    @Autowired
    private NoticeMapper mapper;

    @Override
    public int save(@FluentValid(groups = Add.class) NoticeDTO r) {
    	logger.info("NoticeServiceImpl.save param: r is {}", r);
        Notice entity = new Notice();
        BeanUtil.copy(r, entity);
        entity.setCreateTime(new Date());
        return mapper.insert(entity);
    }

    @Override
    public int delete(Integer id) {
    	logger.info("NoticeServiceImpl.delete param: id is {}", id);
        return mapper.deleteById(id);
    }

    @Override
    public NoticeVO get(Integer id) {
    	logger.info("NoticeServiceImpl.get param: id is {}", id);
        return mapper.findById(id);
    }

    @Override
    public int update(@FluentValid(groups = Update.class) NoticeDTO r) {
    	logger.info("NoticeServiceImpl.update param: r is {}", r);
        Notice entity = new Notice();
        BeanUtil.copy(r, entity);
        return mapper.update(entity);
    }

    @Override
    public List<NoticeVO> list(NoticeSearchDTO r) {
    	logger.info("NoticeServiceImpl.list param: r is {}", r);
        return mapper.list(r);
    }
}
