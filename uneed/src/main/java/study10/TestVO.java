package study10;

import lombok.Data;

/**
 * @author WangYeKun
 * @version 1.0
 * @date 2019/10/31 9:19
 * @description 测试springcopy
 */
@Data
public class TestVO {

    private Integer age;
    private String name;
    private TestEntity.Inner inner;


    @Data
    public static class Inner {
        private Integer a;

        public Inner(Integer a) {
            this.a = a;
        }
    }

}
