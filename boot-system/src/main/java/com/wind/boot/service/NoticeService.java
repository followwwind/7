package com.wind.boot.service;

import java.util.List;
import com.wind.boot.entity.po.Notice;
import com.wind.boot.entity.vo.NoticeVO;
import com.wind.boot.entity.dto.NoticeDTO;
import com.wind.boot.entity.dto.NoticeSearchDTO;

/**
 * 公告 service
 * @author wind
 * @date 2021/04/06 21:40:31
 * @version V1.0
 */
public interface NoticeService{

    /**
     * 添加
     * @param r
     * @return
     */
    int save(NoticeDTO r);

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
    NoticeVO get(Integer id);

    /**
     * 修改
     * @param r
     * @return
     */
    int update(NoticeDTO r);

    /**
     * 批量查询记录
     * @param r
     * @return
     */
    List<NoticeVO> list(NoticeSearchDTO r);
}