package com.wind.boot.service;

import java.util.List;

import com.wind.boot.entity.vo.OrderVO;
import com.wind.boot.entity.dto.OrderDTO;
import com.wind.boot.entity.dto.OrderSearchDTO;

/**
 * child service
 * @author wind
 * @date 2021/04/06 21:40:31
 * @version V1.0
 */
public interface OrderService {

    /**
     * 添加
     * @param r
     * @return
     */
    int save(OrderDTO r);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 单条记录查询
     * @param id
     * @return
     */
    OrderVO get(Integer id);

    /**
     * 修改
     * @param r
     * @return
     */
    int update(OrderDTO r);

    /**
     * 批量查询记录
     * @param r
     * @return
     */
    List<OrderVO> list(OrderSearchDTO r);
}