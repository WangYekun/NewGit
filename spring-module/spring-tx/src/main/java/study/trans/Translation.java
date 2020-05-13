package study.trans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/5/13 15:30
 * @description 事务原理
 */
public class Translation {

    @Autowired
    private TransactionTemplate transactionTemplate;

    public void testTransaction01() {

        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {

                try {

                    // ....  业务代码
                } catch (Exception e) {
                    //回滚
                    transactionStatus.setRollbackOnly();
                }

            }
        });
    }

    @Autowired
    private PlatformTransactionManager transactionManager;

    public void testTransaction02() {

        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            // ....  业务代码
            transactionManager.commit(status);
        } catch (Exception e) {
            transactionManager.rollback(status);
        }
    }

/*    // 获取事务
    TransactionStatus getTransaction;

    // 提交事务
    void commit(TransactionStatus status);

    // 回滚事务
    void rollback(TransactionStatus status);*/

}
