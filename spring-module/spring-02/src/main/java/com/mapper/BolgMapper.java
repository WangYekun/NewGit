package com.mapper;

import com.domain.Bolg;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/11 13:50
 * @description ${description}
 */

public interface BolgMapper {
    int insert(Bolg record);

    int insertSelective(Bolg record);
}