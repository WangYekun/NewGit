# PlatformTransactionManager:事务管理接口

```java

package org.springframework.transaction;

import org.springframework.lang.Nullable;

public interface PlatformTransactionManager {
    //获得事务
    TransactionStatus getTransaction(@Nullable TransactionDefinition var1) throws TransactionException;
    //提交事务
    void commit(TransactionStatus var1) throws TransactionException;
    //回滚事务
    void rollback(TransactionStatus var1) throws TransactionException;
}

```

# TransactionDefinition:事务属性

````java
package org.springframework.transaction;

import org.springframework.lang.Nullable;

public interface TransactionDefinition {
    int PROPAGATION_REQUIRED = 0;
    int PROPAGATION_SUPPORTS = 1;
    int PROPAGATION_MANDATORY = 2;
    int PROPAGATION_REQUIRES_NEW = 3;
    int PROPAGATION_NOT_SUPPORTED = 4;
    int PROPAGATION_NEVER = 5;
    int PROPAGATION_NESTED = 6;
    int ISOLATION_DEFAULT = -1;
    int ISOLATION_READ_UNCOMMITTED = 1;
    int ISOLATION_READ_COMMITTED = 2;
    int ISOLATION_REPEATABLE_READ = 4;
    int ISOLATION_SERIALIZABLE = 8;
    int TIMEOUT_DEFAULT = -1;
    // 返回事务的传播行为，默认值为 REQUIRED。
    int getPropagationBehavior();
    //返回事务的隔离级别，默认值是 DEFAULT
    int getIsolationLevel();
    // 返回事务的超时时间，默认值为-1。如果超过该时间限制但事务还没有完成，则自动回滚事务。
    int getTimeout();
    // 返回是否为只读事务，默认值为 false
    boolean isReadOnly();

    @Nullable
    String getName();
}
````

#  TransactionStatus:事务状态
```java

public interface TransactionStatus{
    boolean isNewTransaction(); // 是否是新的事物
    boolean hasSavepoint(); // 是否有恢复点
    void setRollbackOnly();  // 设置为只回滚
    boolean isRollbackOnly(); // 是否为只回滚
    boolean isCompleted; // 是否已完成
}
```

# TransactionDefinition: 事务传播属性 
````java

public interface TransactionDefinition {
    int PROPAGATION_REQUIRED = 0;
    int PROPAGATION_SUPPORTS = 1;
    int PROPAGATION_MANDATORY = 2;
    int PROPAGATION_REQUIRES_NEW = 3;
    int PROPAGATION_NOT_SUPPORTED = 4;
    int PROPAGATION_NEVER = 5;
    int PROPAGATION_NESTED = 6;
}
````

# 枚举传播属性: Propagation
```java
public enum Propagation {

 REQUIRED(TransactionDefinition.PROPAGATION_REQUIRED),

 SUPPORTS(TransactionDefinition.PROPAGATION_SUPPORTS),

 MANDATORY(TransactionDefinition.PROPAGATION_MANDATORY),

 REQUIRES_NEW(TransactionDefinition.PROPAGATION_REQUIRES_NEW),

 NOT_SUPPORTED(TransactionDefinition.PROPAGATION_NOT_SUPPORTED),

 NEVER(TransactionDefinition.PROPAGATION_NEVER),

 NESTED(TransactionDefinition.PROPAGATION_NESTED);


 private final int value;

 Propagation(int value) {
  this.value = value;
 }

 public int value() {
  return this.value;
 }

}

```

# @Transactional 注解使用详解

-  @Transactional 的作用范围
**方法 ：推荐将注解使用于方法上，不过需要注意的是：该注解只能应用到 public 方法上，否则不生效。**
**类 ：如果这个注解使用在类上的话，表明该注解对该类中所有的 public 方法都生效。**

# @Transactional 的常用配置参数总结

```
属性名	说明
propagation	事务的传播行为，默认值为 REQUIRED，可选的值在上面介绍过
isolation	事务的隔离级别，默认值采用 DEFAULT，可选的值在上面介绍过
timeout	        事务的超时时间，默认值为-1（不会超时）。如果超过该时间限制但事务还没有完成，则自动回滚事务。
readOnly	指定事务是否为只读事务，默认值为 false。
rollbackFor	用于指定能够触发事务回滚的异常类型，并且可以指定多个异常类型。

```

# @Transactional 的使用注意事项总结

```
1. @Transactional 注解只有作用到 public 方法上事务才生效，不推荐在接口上使用；
2. 避免同一个类中调用 @Transactional 注解的方法，这样会导致事务失效；
3. 正确的设置 @Transactional 的 rollbackFor 和 propagation 属性，否则事务可能会回滚失败
```