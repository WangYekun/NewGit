package com.spring.wang;

import com.spring.wang.eneity.Bolg;
import com.spring.wang.mapper.BolgMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class BootApplicationTests {

    @Autowired
    private BolgMapper bl;

    @Test
    void contextLoads() {

        Bolg bolg = new Bolg();
        bolg.setId("222");
        bolg.setAuthor("1");
        bolg.setTitle("111111111");
        bl.insertSelective(bolg);
    }


}
