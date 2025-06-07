package com.goutampersonal.springboot.Controller.AsyncFunctionality;

import com.goutampersonal.springboot.Components.AsyncComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(path="/async")
public class AsyncController {

    @Autowired
    AsyncComponent asyncComponent;

    @GetMapping(value="/path")
        public ResponseEntity<String> startAsyncHandlerFunction() throws ExecutionException, InterruptedException {
            asyncComponent.startAsyncFunctionWithThreadExecutorName();
            asyncComponent.startAsyncFunctionWithoutThreadExecutorName();
            CompletableFuture<Void> result=asyncComponent.returnException();
            System.out.println(result.get());
            return ResponseEntity.status(HttpStatus.FOUND).body("Return from async value");
        }
    @GetMapping(value="/runTransactionThenAsync")
        public void runTransactionThenAsync(){
        asyncComponent.runAsyncAfterTransaction();

        }
    @GetMapping(value="/runAsyncAndTransactionTogether")
        public void runAsyncAndTransactionTogether(){
        boolean isParentTransactionActive=TransactionSynchronizationManager.isActualTransactionActive();
        String parentTxnName=TransactionSynchronizationManager.getCurrentTransactionName();
        asyncComponent.runAsyncAndTransactionTogether(isParentTransactionActive,parentTxnName);
    }

    /**
     *
     * Don't use this for now as this is not working will fix this after learning more
     * TODO:Make this function workable with Async annotation on top of get mapping
     *
     */
    @GetMapping(value="/runTransactionWithinAsyncManual")
    public CompletableFuture<ResponseEntity<String>> runTransactionWithinAsyncManual(){
        return CompletableFuture.supplyAsync(() -> {
            boolean isParentTransactionActive = TransactionSynchronizationManager.isActualTransactionActive();
            String parentTxnName = TransactionSynchronizationManager.getCurrentTransactionName();

            try {
                asyncComponent.runAsyncMethodWrappedInTransaction(isParentTransactionActive, parentTxnName);
                return ResponseEntity.ok("Processing completed");
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Processing failed: " + e.getMessage());
            }
        });
    }

}
