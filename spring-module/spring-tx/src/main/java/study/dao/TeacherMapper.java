package study.dao;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/15 0:44
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