package com.wind.boot.dao;

import com.wind.boot.config.persistence.annotation.SqlMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.wind.boot.entity.po.Notice;
import com.wind.boot.entity.vo.NoticeVO;
import com.wind.boot.entity.dto.NoticeSearchDTO;

/**
 * 公告 dao
 * @author wind
 * @date 2021/04/06 21:40:31
 * @version V1.0
 */
@SqlMapper
public interface NoticeMapper {

    /**
     * 添加
     * @param r
     * @return
     */
    int insert(Notice r);

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
    NoticeVO findById(@Param("id") Integer id);

    /**
     * 修改
     * @param r
     * @return
     */
    int update(Notice r);

    /**
     * 删除
     * @param r
     * @return
     */
    int delete(Notice r);

    /**
     * 列表查询
     * @param r
     * @return
     */
    List<NoticeVO> list(NoticeSearchDTO r);

}