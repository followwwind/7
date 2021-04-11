package com.wind.boot.dao;

import com.wind.boot.config.persistence.annotation.SqlMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.wind.boot.entity.po.Child;
import com.wind.boot.entity.vo.ChildVO;
import com.wind.boot.entity.dto.ChildSearchDTO;

/**
 * child dao
 * @author wind
 * @date 2021/04/11 16:20:22
 * @version V1.0
 */
@SqlMapper
public interface ChildMapper {

    /**
     * 添加
     * @param r
     * @return
     */
    int insert(Child r);

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
    ChildVO findById(@Param("id") Integer id);

    /**
     * 修改
     * @param r
     * @return
     */
    int update(Child r);

    /**
     * 删除
     * @param r
     * @return
     */
    int delete(Child r);

    /**
     * 列表查询
     * @param r
     * @return
     */
    List<ChildVO> list(ChildSearchDTO r);

}