package com.goutampersonal.springboot.Components;

import com.goutampersonal.springboot.Helpers.DTO.UserDAOTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Component
public class TransactionalUserService {

    @Autowired
    UserDAOTransactional userDAO;

    @Transactional
    public void method1(){
        String currentTransactionName= TransactionSynchronizationManager.getCurrentTransactionName();
        System.out.println("Current Transaction Name "+currentTransactionName);
        userDAO.method2();
        userDAO.requireNewTransaction();
        System.out.println("=======================Transaction ==============================");
    }

}
