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
import com.wind.boot.dao.VaccineMapper;
import com.wind.boot.service.VaccineService;
import com.wind.boot.entity.po.Vaccine;
import com.wind.boot.entity.vo.VaccineVO;
import com.wind.boot.entity.dto.VaccineDTO;
import com.wind.boot.entity.dto.VaccineSearchDTO;
import com.baidu.unbiz.fluentvalidator.annotation.FluentValid;

/**
 * 疫苗 service
 * @author wind
 * @date 2021/04/06 21:40:31
 * @version V1.0
 */
@Service
public class VaccineServiceImpl implements VaccineService{

	private Logger logger = LoggerFactory.getLogger(VaccineServiceImpl.class);

    @Autowired
    private VaccineMapper mapper;

    @Override
    public int save(@FluentValid(groups = Add.class) VaccineDTO r) {
    	logger.info("VaccineServiceImpl.save param: r is {}", r);
        Vaccine entity = new Vaccine();
        BeanUtil.copy(r, entity);
        entity.setCreateTime(new Date());
        return mapper.insert(entity);
    }

    @Override
    public int delete(Integer id) {
    	logger.info("VaccineServiceImpl.delete param: id is {}", id);
        return mapper.deleteById(id);
    }

    @Override
    public VaccineVO get(Integer id) {
    	logger.info("VaccineServiceImpl.get param: id is {}", id);
        return mapper.findById(id);
    }

    @Override
    public int update(@FluentValid(groups = Update.class) VaccineDTO r) {
    	logger.info("VaccineServiceImpl.update param: r is {}", r);
        Vaccine entity = new Vaccine();
        BeanUtil.copy(r, entity);
        return mapper.update(entity);
    }

    @Override
    public List<VaccineVO> list(VaccineSearchDTO r) {
    	logger.info("VaccineServiceImpl.list param: r is {}", r);
        return mapper.list(r);
    }
}
