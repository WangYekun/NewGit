package study.dao;

import study.dao.Bolg;

/**
 * @author Mark
 * @date  2020/4/11 14:00
 * @version 1.0
 * @description ${description}
 */

public interface BolgMapper {
    int insert(Bolg record);

    int insertSelective(Bolg record);
}