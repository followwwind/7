package com.wind.boot.dao;

import com.wind.boot.config.persistence.annotation.SqlMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.wind.boot.entity.po.Feedback;
import com.wind.boot.entity.vo.FeedbackVO;
import com.wind.boot.entity.dto.FeedbackSearchDTO;

/**
 * 反馈 dao
 * @author wind
 * @date 2021/04/06 21:40:31
 * @version V1.0
 */
@SqlMapper
public interface FeedbackMapper {

    /**
     * 添加
     * @param r
     * @return
     */
    int insert(Feedback r);

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
    FeedbackVO findById(@Param("id") Integer id);

    /**
     * 修改
     * @param r
     * @return
     */
    int update(Feedback r);

    /**
     * 删除
     * @param r
     * @return
     */
    int delete(Feedback r);

    /**
     * 列表查询
     * @param r
     * @return
     */
    List<FeedbackVO> list(FeedbackSearchDTO r);

}