package com.wind.boot.service;

import java.util.List;
import com.wind.boot.entity.po.Feedback;
import com.wind.boot.entity.vo.FeedbackVO;
import com.wind.boot.entity.dto.FeedbackDTO;
import com.wind.boot.entity.dto.FeedbackSearchDTO;

/**
 * 反馈 service
 * @author wind
 * @date 2021/04/06 21:40:31
 * @version V1.0
 */
public interface FeedbackService{

    /**
     * 添加
     * @param r
     * @return
     */
    int save(FeedbackDTO r);

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
    FeedbackVO get(Integer id);

    /**
     * 修改
     * @param r
     * @return
     */
    int update(FeedbackDTO r);

    /**
     * 批量查询记录
     * @param r
     * @return
     */
    List<FeedbackVO> list(FeedbackSearchDTO r);
}