package com.wind.boot.dao;

import com.wind.boot.config.persistence.annotation.SqlMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.wind.boot.entity.po.Order;
import com.wind.boot.entity.vo.OrderVO;
import com.wind.boot.entity.dto.OrderSearchDTO;

/**
 * child dao
 * @author wind
 * @date 2021/04/06 21:40:31
 * @version V1.0
 */
@SqlMapper
public interface OrderMapper {

    /**
     * 添加
     * @param r
     * @return
     */
    int insert(Order r);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteById(@Param("id") Integer id);

    /**
     * 单条记录查询
     * @param id
     * @return
     */
    OrderVO findById(@Param("id") Integer id);

    /**
     * 修改
     * @param r
     * @return
     */
    int update(Order r);

    /**
     * 删除
     * @param r
     * @return
     */
    int delete(Order r);

    /**
     * 列表查询
     * @param r
     * @return
     */
    List<OrderVO> list(OrderSearchDTO r);

}