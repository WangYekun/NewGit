package com.spring.wang.vo;

        import com.spring.wang.eneity.Bolg;
        import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/12 13:44
 * @description 转化时间
 */
public class BolgVo extends Bolg {

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String creatTimeStr;
}
