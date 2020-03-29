package com.macky.springbootshardingjdbc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.macky.springbootshardingjdbc.entity.Book;

import java.util.List;

/**
 * @author Macky
 * @Title interface BookService
 * @date 2019/7/12 20:47
 */
public interface BookService extends IService<Book> {

    /**
     * 保存书籍信息
     *
     * @param book 书籍
     * @return 1or0
     */
    @Override
    boolean save(Book book);

    /**
     * 查询全部书籍信息
     *
     * @return List集合
     */
    List<Book> getBookList();
}
