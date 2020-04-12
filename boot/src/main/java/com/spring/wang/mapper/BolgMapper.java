package com.spring.wang.mapper;

import com.spring.wang.eneity.Bolg;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/12 13:02
 * @description ${description}
 */

@Repository
@Mapper
public interface BolgMapper {

    int insert(Bolg record);

    int insertSelective(Bolg record);
}