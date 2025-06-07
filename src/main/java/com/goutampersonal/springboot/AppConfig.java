package com.goutampersonal.springboot;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.concurrent.*;

@Configuration
/**
 * This is how async thread is being used in production level code
 */
public class AppConfig implements AsyncConfigurer {
    @Autowired
    private AsyncUncaughtExceptionHandler asyncUncaughtExceptionHandler;
    private ThreadPoolExecutor poolExecutor;

    @Bean(name = "newCustomThreadExecutor")
    public Executor newCustomThreadExecutor() {
        return getAsyncExecutor();
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return this.asyncUncaughtExceptionHandler;
    }


    @Override
    public synchronized Executor getAsyncExecutor() {
        if (poolExecutor == null) {
            int minPoolSize = 2;
            int maxPoolSize = 4;
            int queueSize = 3;

            poolExecutor = new ThreadPoolExecutor(
                    minPoolSize,
                    maxPoolSize,
                    1, TimeUnit.HOURS,
                    new ArrayBlockingQueue<>(queueSize),
                    newCustomThreadFactory()
            );
        }
        return poolExecutor;
    }

    /**
     *
     * We can use this thread factory method or just use executor.execute(() -> {
     *     System.out.println("Running in thread: " + Thread.currentThread().getName());
     * });
     * in poolExecutor object
     */
    private ThreadFactory newCustomThreadFactory() {
        return new ThreadFactory() {
            private int count = 1;

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "custom-executor-thread-" + count++);
            }
        };

    }
}

@Component
class DefaultAsyncExceptionalHandler implements  AsyncUncaughtExceptionHandler {
    @Override
    public void handleUncaughtException(Throwable exception, Method method, Object... params){
        System.out.println("Uncaught Async exceptional handler on " + method.getName() + " exception :" + exception.getMessage());
    }

}
