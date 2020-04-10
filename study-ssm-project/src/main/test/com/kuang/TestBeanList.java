package com.kuang;

import com.kuang.pojo.Books;
import com.kuang.pojo.Student;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/9 15:58
 * @description 测试beanList.xml
 */
public class TestBeanList {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestBeanList.class);

    @Test
    public void testTestBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanList.xml");
        LOGGER.info("this is book bean for IOC [{}]", context.getBean("book", Books.class));
        LOGGER.info("this is student bean for IOC [{}]", context.getBean("student", Student.class));
    }
}
