import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.CharsetUtil;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import study10.Employee;
import study10.User;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

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

        /*  1. Spring的BeanUtils的CopyProperties方法需要对应的属性有getter和setter方法;
            2. 如果存在属性完全相同的内部类，但是不是同一个内部类，即分别属于各自的内部类，则spring会认为属性不同，不会copy;
            3. 泛型只在编译期起作用，不能依靠泛型来做运行期的限制;
            4. 最后，spring和apache的copy属性的方法源和目的参数的位置正好相反，所以导包和调用的时候都要注意一下。
        */

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
