package com.goutampersonal.springboot.Helpers.DTO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Component
public class UserDAOTransactional {
    @Transactional(propagation = Propagation.REQUIRED)
    /*
     *Required is like if parent transaction is present use that or else create a new transction
     */
    public void method2(){
        boolean isTransactionActive= TransactionSynchronizationManager.isActualTransactionActive();
        String currentTransactionName=TransactionSynchronizationManager.getCurrentTransactionName();
        System.out.println("===============================Transaction==============================");
        System.out.println("Is Parent transaction active "+isTransactionActive);
        System.out.println("Current Transaction name "+currentTransactionName);

    }
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    /*
     *Required new is if parent transaction is present then suspend(not cancel) it
     * then create a new transaction finish it work then resume then parent transaction
     * If parent transaction is not present create a new transaction
     */
    public void requireNewTransaction(){
        boolean isParentTransactionActive=TransactionSynchronizationManager.isActualTransactionActive();
        String currentTransactionName=TransactionSynchronizationManager.getCurrentTransactionName();
        System.out.println("=================Transaction====================");
        System.out.println("Is Parent Transaction Active "+isParentTransactionActive);
        System.out.println("Current Transaction name for requireNewTransaction Method "+currentTransactionName);
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    /*
     *Support is if parent transaction is present then use it
     *else perform task without transaction
     */
    public void supportTransaction(){
        boolean isParentTransactionActive=TransactionSynchronizationManager.isActualTransactionActive();
        String currentTransactionName=TransactionSynchronizationManager.getCurrentTransactionName();
        System.out.println("=================Transaction====================");
        System.out.println("Is Parent Transaction Active "+isParentTransactionActive);
        System.out.println("Current Transaction name for support Method "+currentTransactionName);
    }
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    /*
     *Not Support is if parent transaction is present then suspend it
     * perform task without transaction then resume parent transaction
     * if parent transaction is not present then perform the task without transaction
     */
    public void notSupportedTransaction(){
        boolean isParentTransactionActive=TransactionSynchronizationManager.isActualTransactionActive();
        String currentTransactionName=TransactionSynchronizationManager.getCurrentTransactionName();
        System.out.println("=================Transaction====================");
        System.out.println("Is Parent Transaction Active "+isParentTransactionActive);
        System.out.println("Current Transaction name for not supported Method "+currentTransactionName);
    }
    @Transactional(propagation = Propagation.MANDATORY)
    /*
     *Mandatory is if parent transaction is present then use it
     * else throw exception
     */
    public void mandatoryTransaction(){
        boolean isParentTransactionActive=TransactionSynchronizationManager.isActualTransactionActive();
        String currentTransactionName=TransactionSynchronizationManager.getCurrentTransactionName();
        System.out.println("=================Transaction====================");
        System.out.println("Is Parent Transaction Active "+isParentTransactionActive);
        System.out.println("Current Transaction name for mandatory transaction Method "+currentTransactionName);
    }
    @Transactional(propagation = Propagation.NEVER)
    /*
     *never is if parent transaction is present then trow exception
     * else execute the method without transaction
     */
    public void neverTransaction(){
        boolean isParentTransactionActive=TransactionSynchronizationManager.isActualTransactionActive();
        String currentTransactionName=TransactionSynchronizationManager.getCurrentTransactionName();
        System.out.println("=================Transaction====================");
        System.out.println("Is Parent Transaction Active "+isParentTransactionActive);
        System.out.println("Current Transaction name for never transaction Method "+currentTransactionName);
    }
}
