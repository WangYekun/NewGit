package com.spring.wang.service;

import com.spring.wang.eneity.Bolg;
import com.spring.wang.mapper.BolgMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/12 1:51
 * @description ${description}
 */

@Service
public class BolgService {

    @Resource
    private BolgMapper bolgMapper;


    public int insert(Bolg record) {
        return bolgMapper.insert(record);
    }


    public int insertSelective(Bolg record) {
        return bolgMapper.insertSelective(record);
    }

}






