import cn.hutool.core.lang.Console;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import study.dao.Student;
import study.dao.StudentMapper;
import study.util.MyBatisUtil;

import java.sql.Connection;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/5/12 22:15
 * @description 测试Crud
 */
public class TestCrud {

    @Test
    public void testCrud() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        Connection connection = sqlSession.getConnection();
        Console.log(connection);
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectByPrimaryKey(1);
        Console.log(student);
        sqlSession.close();
    }
}
