package study.dao;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/15 0:44
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