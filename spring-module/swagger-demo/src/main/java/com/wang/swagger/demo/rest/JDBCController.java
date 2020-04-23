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

    private final JdbcTemplate jdbcTemplate;

    public JDBCController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @ApiOperation(value = "JDBC添加操作", notes = "JDBC添加操作")
    @GetMapping(value = "/saveSqlByJDBC")
    public int saveSql() {
        String s = "INSERT INTO user(id, name, pwd) VALUES (1213,'1','7657')";
        return jdbcTemplate.update(s);
    }

    @ApiOperation(value = "JDBC删除操作", notes = "JDBC删除操作")
    @GetMapping(value = "/deleteSqlByJDBC/{id}")
    public int deleteSql(@PathVariable(value = "id") Integer id) {
        String s = "DELETE FROM user WHERE id =" + id;
        return jdbcTemplate.update(s);
    }

    @ApiOperation(value = "JDBC更新操作", notes = "JDBC更新操作")
    @GetMapping(value = "/editSqlByJDBC/{id}")
    public int editSql(@PathVariable(value = "id") Integer id) {
        String s = "UPDATE user SET name=?,pwd =? where id=" + id;
        Object[] objects = new Object[2];
        objects[0] = "小明2";
        objects[1] = "12873123";
        return jdbcTemplate.update(s, objects);
    }


    @ApiOperation(value = "JDBC查询操作", notes = "JDBC查询操作")
    @GetMapping(value = "/getSqlByJDBC")
    public List<Map<String, Object>> getSql() {
        String s = "SELECT * FROM student";
        return jdbcTemplate.queryForList(s);
    }

}
