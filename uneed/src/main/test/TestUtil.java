import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.CharsetUtil;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import study10.Employee;
import study10.User;

/**
 * @author WangYeKun
 * @version 1.0
 * @date 2019/10/29 14:50
 * @description 测试(copy)
 */
public class TestUtil {
    @Test
    public void test() {
        Employee employee = new Employee("WangYeKun", 24, "copyProperties");
        User user = new User();

        // source=>employee | target=>user
        BeanUtils.copyProperties(employee, user);
        System.out.println(user);

        // 编码转换
        String a = "我不是乱码";
        //转换后result为乱码
        String result = Convert.convertCharset(a, CharsetUtil.UTF_8, CharsetUtil.ISO_8859_1);
        String raw = Convert.convertCharset(result, CharsetUtil.ISO_8859_1, "UTF-8");
        Assert.assertEquals(raw, a);
    }

}
