package com.wind.boot.service;

import java.util.List;
import com.wind.boot.entity.po.Child;
import com.wind.boot.entity.vo.ChildVO;
import com.wind.boot.entity.dto.ChildDTO;
import com.wind.boot.entity.dto.ChildSearchDTO;

/**
 * child service
 * @author wind
 * @date 2021/04/11 16:20:22
 * @version V1.0
 */
public interface ChildService{

    /**
     * 添加
     * @param r
     * @return
     */
    int save(ChildDTO r);

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
    ChildVO get(Integer id);

    /**
     * 修改
     * @param r
     * @return
     */
    int update(ChildDTO r);

    /**
     * 批量查询记录
     * @param r
     * @return
     */
    List<ChildVO> list(ChildSearchDTO r);
}