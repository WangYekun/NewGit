package com.mapper;

import com.domain.Bolg;

/**
 * @author Mark
 * @date  2020/4/11 13:52
 * @version 1.0
 * @description ${description}
 */

public interface BolgMapper {
    int insert(Bolg record);

    int insertSelective(Bolg record);
}