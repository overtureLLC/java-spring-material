/*
 * Copyright (C) 2019 Liwei Wang, daveywang@live.com - All Rights Reserved
 */

package com.ascending.training.repository;

import com.ascending.training.model.Account;

import java.util.List;

public interface AccountDao {
    boolean save(Account account, String employeeName);
    List<Account> getAccounts();
    Account getAccountById(int id);
}
