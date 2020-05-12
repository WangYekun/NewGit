package study.service;

import org.springframework.stereotype.Service;
import study.dao.Bolg;
import study.dao.BolgMapper;

import javax.annotation.Resource;
/**
 * @author Mark
 * @date  2020/4/15 0:44
 * @version 1.0
 * @description ${description}
 */

@Service
public class BolgService{

    @Resource
    private BolgMapper bolgMapper;

    public int insert(Bolg record) {
        return bolgMapper.insert(record);
    }

    public int insertSelective(Bolg record) {
        return bolgMapper.insertSelective(record);
    }

}
