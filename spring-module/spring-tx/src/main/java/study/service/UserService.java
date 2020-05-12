package study.service;

import org.springframework.stereotype.Service;
import study.dao.User;
import study.dao.UserMapper;

import javax.annotation.Resource;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/15 0:44
 * @description ${description}
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;


    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }


    public int insert(User record) {
        return userMapper.insert(record);
    }


    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }


    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }


    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

}
