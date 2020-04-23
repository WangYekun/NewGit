package com.wang.swagger.demo.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/23 9:52
 * @description JDBC操作
 */
@Api(value = "JDBC操作", tags = "JDBC操作")
@RequestMapping(value = "jdbc")
@RestController
public class JDBCController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @ApiOperation(value = "JDBC添加操作", notes = "JDBC添加操作")
    @GetMapping(value = "/addSql")
    public int addSql() {
        String s = "INSERT INTO student.student(id, name, tid) VALUES (131,'1','7657')";
        return jdbcTemplate.update(s);
    }

    @ApiOperation(value = "JDBC删除操作", notes = "JDBC删除操作")
    @GetMapping(value = "/deleteSql/{id}")
    public int deleteSql(@PathVariable(value = "id") Integer id) {
        String s = "DELETE FROM student.student WHERE id =" + id;
        return jdbcTemplate.update(s);
    }

    @ApiOperation(value = "JDBC更新操作", notes = "JDBC更新操作")
    @GetMapping(value = "/editSql/{id}")
    public int editSql(@PathVariable(value = "id") Integer id) {
        String s = "UPDATE student.student SET name=?,tid =? where id=" + id;
        Object[] objects = new Object[2];
        objects[0] = "小明2";
        objects[1] = "12873123";
        return jdbcTemplate.update(s, objects);
    }


    @ApiOperation(value = "JDBC查询操作", notes = "JDBC查询操作")
    @GetMapping(value = "/getSql")
    public List<Map<String, Object>> getSql() {
        String s = "SELECT * FROM student";
        return jdbcTemplate.queryForList(s);
    }

}
