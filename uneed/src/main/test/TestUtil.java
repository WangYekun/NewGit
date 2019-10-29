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
    }
}
