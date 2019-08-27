/*
 * Copyright (C) 2019 Liwei Wang, daveywang@live.com - All Rights Reserved
 */

package com.ascending.training.service;

import com.ascending.training.init.AppInitializer;
import com.ascending.training.model.Account;
import com.ascending.training.model.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= AppInitializer.class)
public class AccountServiceTest {
    @Autowired private AccountService accountService;
    @Autowired private Logger logger;

    @Before
    public void init() {
        //accountService = new AccountServiceImpl();
    }

    @Test
    public void getAccounts() {
        List<Account> accounts = accountService.getAccounts();
        int expectedNumOfDept = 5;
        accounts.forEach(acct -> logger.debug(acct.toString()));
        Assert.assertEquals(expectedNumOfDept, accounts.size());
    }

    @Test
    public void getEmployeeById() {
        int id = 2;
        Account account = accountService.getAccountById(id);
        Assert.assertEquals(id, account.getId());
        logger.debug(account.toString());
        Employee employee = account.getEmployee();
        logger.debug(employee.getEmail());
    }
}