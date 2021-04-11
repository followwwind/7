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
import com.wind.boot.dao.OrderMapper;
import com.wind.boot.service.OrderService;
import com.wind.boot.entity.po.Order;
import com.wind.boot.entity.vo.OrderVO;
import com.wind.boot.entity.dto.OrderDTO;
import com.wind.boot.entity.dto.OrderSearchDTO;
import com.baidu.unbiz.fluentvalidator.annotation.FluentValid;

/**
 * child service
 * @author wind
 * @date 2021/04/06 21:40:31
 * @version V1.0
 */
@Service
public class OrderServiceImpl implements OrderService {

	private Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderMapper mapper;

    @Override
    public int save(@FluentValid(groups = Add.class) OrderDTO r) {
    	logger.info("ChildServiceImpl.save param: r is {}", r);
        Order entity = new Order();
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
    public OrderVO get(Integer id) {
    	logger.info("ChildServiceImpl.get param: id is {}", id);
        return mapper.findById(id);
    }

    @Override
    public int update(@FluentValid(groups = Update.class) OrderDTO r) {
    	logger.info("ChildServiceImpl.update param: r is {}", r);
        Order entity = new Order();
        BeanUtil.copy(r, entity);
        return mapper.update(entity);
    }

    @Override
    public List<OrderVO> list(OrderSearchDTO r) {
    	logger.info("ChildServiceImpl.list param: r is {}", r);
        return mapper.list(r);
    }
}
