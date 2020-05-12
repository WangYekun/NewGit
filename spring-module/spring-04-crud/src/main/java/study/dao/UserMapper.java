package study.dao;

import study.pojo.User;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/15 0:41
 * @description ${description}
 */

public interface UserMapper {

    /**
     * 删除
     *
     * @param id 主键id
     * @return 删除标志(int)
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增
     *
     * @param record 学生对象
     * @return 参数
     */
    int insert(User record);

    /**
     * 新增(属性为空也行)
     *
     * @param record 学生对象
     * @return int
     */
    int insertSelective(User record);

    /**
     * 查询
     *
     * @param id 主键id
     * @return User用户对象
     */
    User selectByPrimaryKey(Integer id);

    /**
     * 更新
     *
     * @param record 学生对象
     * @return 更新(1为成功, 0为失败)
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * 更新
     *
     * @param record 学生对象
     * @return 更新(1为成功, 0为失败)
     */
    int updateByPrimaryKey(User record);

}