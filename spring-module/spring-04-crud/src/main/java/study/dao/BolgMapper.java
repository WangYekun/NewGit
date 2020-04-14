package study.dao;

import study.dao.Bolg;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/15 0:41
 * @description ${description}
 */

public interface BolgMapper {
    int insert(Bolg record);

    int insertSelective(Bolg record);
}