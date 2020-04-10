package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/8 22:09
 * @description 书籍实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {

    private int bookId;
    private String bookName;
    private int bookCounts;
    private String detail;

}