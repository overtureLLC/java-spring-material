/*
 * Copyright (C) 2019 Liwei Wang, daveywang@live.com - All Rights Reserved
 */

package com.ascending.training.service;

import com.ascending.training.model.Account;
import com.ascending.training.repository.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired private AccountDao accountDao;

    public boolean save(Account account, String employeeName) {
        return accountDao.save(account, employeeName);
    }

    public List<Account> getAccounts() {
        return accountDao.getAccounts();
    }

    public Account getAccountById(int id) {
        return accountDao.getAccountById(id);
    }
}
