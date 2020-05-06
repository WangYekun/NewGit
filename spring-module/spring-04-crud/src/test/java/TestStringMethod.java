import org.junit.Test;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/5/6 17:34
 * @description 测试字符串的方法
 */
public class TestStringMethod {

    @Test
    public void containsTest() {
        String one = "a";
        String two = "abc";
        // false
        System.out.println(one.contains(two));
        // true
        System.out.println(two.contains(one));
    }

    @Test
    public void indexOfTest() {
        String one = "a";
        String two = "abc";
        // -1
        System.out.println(one.indexOf(two));
        // 0
        System.out.println(two.indexOf(one));
    }
}
