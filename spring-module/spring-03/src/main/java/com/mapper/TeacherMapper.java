package com.mapper;

import com.domain.Teacher;

/**
 * @author Mark
 * @date  2020/4/11 13:52
 * @version 1.0
 * @description ${description}
 */

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
}