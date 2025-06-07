package com.goutampersonal.springboot.Components;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.concurrent.CompletableFuture;

@Component
public class AsyncComponent {

    @Async
    public void startAsyncFunctionWithoutThreadExecutorName(){
        System.out.println("Async function started without using the thread executor name thread Name "+Thread.currentThread().getName());
    }
    @Async("newCustomThreadExecutor")
    public void startAsyncFunctionWithThreadExecutorName(){
        System.out.println("Async function started without using the thread executor Thread Name "+Thread.currentThread().getName());
    }
    @Async
    public CompletableFuture<Void> returnException(){
        int data=5/0;
        return CompletableFuture.completedFuture(null);
    }
    @Async
    /**
     * this is also not the correct way to be used with transaction as transaction context will not
     * be passed between threads and since the method is annotated with the @Async annotation
     * it will create its own thread
     * If there is no parent transaction then this method is correct
     */
    public void runAsyncAfterTransaction(){
        System.out.println("============================New Thread created================================");
        System.out.println("Working on thread name "+Thread.currentThread().getName());
        String currentTransactionName=TransactionSynchronizationManager.getCurrentTransactionName();
        boolean isTransactionActive=TransactionSynchronizationManager.isActualTransactionActive();
        System.out.println("Does current method has parent Transaction active "+isTransactionActive);
        System.out.println("Is any transaction is active "+isTransactionActive);
        System.out.println("Current Transaction Name "+currentTransactionName);
        System.out.println("========================Thread execution ended=================================");
    }
    @Async
    @Transactional
    /**
     * This is not correct method as if the parent method calling this async method has
     * a transaction of its own its context won't be passed here as this will create a
     * thread and run transactional there and transactional context cannot be between thread
     * If there is no parent transaction then this method is correct
     */
    public void runAsyncAndTransactionTogether(boolean isParentTxnActive,String parentTransactionName){
        System.out.println("============================New Thread created================================");
        System.out.println("Working on thread name "+Thread.currentThread().getName());
        String currentTransactionName=TransactionSynchronizationManager.getCurrentTransactionName();
        boolean isTransactionActive=TransactionSynchronizationManager.isActualTransactionActive();
        System.out.println("Does current method has parent Transaction active "+isParentTxnActive);
        System.out.println("Parent Transaction Name "+parentTransactionName);
        System.out.println("Is current method transaction active "+isTransactionActive);
        System.out.println("Current Transaction Name "+currentTransactionName);
        System.out.println("========================Thread execution ended=================================");
    }
    @Transactional
    /**
     * Since this is not annotated with @Async no new thread will be created
     * and parent transactional context if any will be applicable here if not overridden in current
     * transactional
     *
     * This is the correct way to use transaction with async
     * make the method itself async and call one/many transaction within the async method
     */
    public void runAsyncMethodWrappedInTransaction(
            boolean isParentTxnActive,
            String parentTransactionName){
        System.out.println("Working on thread name "+Thread.currentThread().getName());
        String currentTransactionName=TransactionSynchronizationManager.getCurrentTransactionName();
        boolean isTransactionActive=TransactionSynchronizationManager.isActualTransactionActive();
        System.out.println("Does current method has parent Transaction active "+isParentTxnActive);
        System.out.println("Parent Transaction Name "+parentTransactionName);
        System.out.println("Is current method transaction active "+isTransactionActive);
        System.out.println("Current Transaction Name "+currentTransactionName);
        System.out.println("========================Thread execution ended=================================");
    }
}
