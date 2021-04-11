package com.wind.boot.service;

import java.util.List;
import com.wind.boot.entity.po.Vaccine;
import com.wind.boot.entity.vo.VaccineVO;
import com.wind.boot.entity.dto.VaccineDTO;
import com.wind.boot.entity.dto.VaccineSearchDTO;

/**
 * 疫苗 service
 * @author wind
 * @date 2021/04/06 21:40:31
 * @version V1.0
 */
public interface VaccineService{

    /**
     * 添加
     * @param r
     * @return
     */
    int save(VaccineDTO r);

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
    VaccineVO get(Integer id);

    /**
     * 修改
     * @param r
     * @return
     */
    int update(VaccineDTO r);

    /**
     * 批量查询记录
     * @param r
     * @return
     */
    List<VaccineVO> list(VaccineSearchDTO r);
}