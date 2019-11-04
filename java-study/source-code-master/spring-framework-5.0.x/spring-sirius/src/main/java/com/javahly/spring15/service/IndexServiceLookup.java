package com.javahly.spring15.service;


import com.javahly.spring15.dao.IndexDao;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/7/8
 * @QQ :1136513099
 * @desc :
 */
@Component
public abstract class IndexServiceLookup {

    @Lookup
    public abstract IndexDao getIndexDao() ;

    public void service(){
        System.out.println("service:"+this.hashCode());
        System.out.println("dao:"+getIndexDao().hashCode());
    }
}
