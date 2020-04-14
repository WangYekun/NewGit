package study.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import study.dao.Bolg;
import study.dao.BolgMapper;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/11 14:00
 * @description ${description}
 */

@Service
public class BolgService {

    @Resource
    private BolgMapper bolgMapper;


    public int insert(Bolg record) {
        return bolgMapper.insert(record);
    }


    public int insertSelective(Bolg record) {
        return bolgMapper.insertSelective(record);
    }

}

