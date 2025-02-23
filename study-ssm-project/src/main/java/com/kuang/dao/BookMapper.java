package com.kuang.dao;


import com.kuang.pojo.Books;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/8 22:16
 * @description 书籍持久层
 */
@Repository
public interface BookMapper {

    //增加一个Book
    int addBook(Books book);

    //根据id删除一个Book
    int deleteBookById(int id);

    //更新Book
    int updateBook(Books books);

    //根据id查询,返回一个Book
    Books queryBookById(int id);

    //查询全部Book,返回list集合
    List<Books> queryAllBook();

}