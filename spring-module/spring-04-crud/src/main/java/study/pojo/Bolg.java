package study.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/15 0:41
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