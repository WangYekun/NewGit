package com.wang.swagger.demo.mapper;

import com.wang.swagger.demo.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/22 9:48
 * @description ${description}
 */
@Mapper
@Repository
public interface StudentMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

}