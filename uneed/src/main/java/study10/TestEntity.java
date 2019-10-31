package study10;

import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @author WangYeKun
 * @version 1.0
 * @date 2019/10/31 9:18
 * @description 测试spring.copy
 */
@Data
public class TestEntity {

    private Integer age;
    private String name;
    private Inner inner;

    @Data
    public static class Inner {
        private Integer a;

        public Inner(Integer a) {
            this.a = a;
        }
    }

    public static void main(String[] args) {
        TestEntity entity = new TestEntity();
        entity.setAge(1);
        entity.setName("hehe");
        entity.setInner(new TestEntity.Inner(1));

        TestVO vo = new TestVO();
        BeanUtils.copyProperties(entity, vo);
        System.out.println(vo.toString());

    }
}

