package com.mapper;

import com.domain.Student;

/**
 * @author Mark
 * @date  2020/4/11 13:50
 * @version 1.0
 * @description ${description}
 */

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}