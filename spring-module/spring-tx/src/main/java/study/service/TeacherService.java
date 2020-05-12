package study.service;

import org.springframework.stereotype.Service;
import study.dao.Teacher;
import study.dao.TeacherMapper;

import javax.annotation.Resource;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/15 0:44
 * @description ${description}
 */

@Service
public class TeacherService {

    @Resource
    private TeacherMapper teacherMapper;

    public int deleteByPrimaryKey(Integer id) {
        return teacherMapper.deleteByPrimaryKey(id);
    }

    public int insert(Teacher record) {
        return teacherMapper.insert(record);
    }

    public int insertSelective(Teacher record) {
        return teacherMapper.insertSelective(record);
    }

    public Teacher selectByPrimaryKey(Integer id) {
        return teacherMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Teacher record) {
        return teacherMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Teacher record) {
        return teacherMapper.updateByPrimaryKey(record);
    }

}
