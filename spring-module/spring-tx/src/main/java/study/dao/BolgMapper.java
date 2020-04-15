package study.dao;

import study.dao.Bolg;

/**
 * @author Mark
 * @date  2020/4/15 0:44
 * @version 1.0
 * @description ${description}
 */

public interface BolgMapper {
    int insert(Bolg record);

    int insertSelective(Bolg record);
}