package study.dao;

import java.util.Date;
import lombok.Data;

/**
 * @author Mark
 * @date  2020/4/15 0:44
 * @version 1.0
 * @description ${description}
 */

@Data
public class Bolg {
    /**
    * 博客id
    */
    private String id;

    /**
    * 博客标题
    */
    private String title;

    /**
    * 博客作者
    */
    private String author;

    /**
    * 创建时间
    */
    private Date creatTime;
}