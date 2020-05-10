package study.dao;

import study.pojo.User;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/15 0:41
 * @description ${description}
 */

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}