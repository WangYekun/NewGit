package study.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import study.dao.Student;
import study.dao.StudentMapper;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/11 14:00
 * @description ${description}
 */

@Service
public class StudentService {

    @Resource
    private StudentMapper studentMapper;


    public int deleteByPrimaryKey(Integer id) {
        return studentMapper.deleteByPrimaryKey(id);
    }


    public int insert(Student record) {
        return studentMapper.insert(record);
    }


    public int insertSelective(Student record) {
        return studentMapper.insertSelective(record);
    }


    public Student selectByPrimaryKey(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }


    public int updateByPrimaryKeySelective(Student record) {
        return studentMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(Student record) {
        return studentMapper.updateByPrimaryKey(record);
    }

}

