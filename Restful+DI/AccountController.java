/*
 * Copyright (C) 2019 Liwei Wang, daveywang@live.com - All Rights Reserved
 */

package com.ascending.training.controller;

import com.ascending.training.model.Account;
import com.ascending.training.model.Employee;
import com.ascending.training.service.AccountService;
import com.ascending.training.service.EmployeeService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = {"/accounts"})
public class AccountController {
    @Autowired private AccountService accountService;
    @Autowired private EmployeeService employeeService;

    //@GetMapping(value = "", produces = "application/json")
    @RequestMapping(value = "", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Account> getAccounts() {
        return accountService.getAccounts();
    }

    @RequestMapping(value = "/{employeeId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Set<Account> getAccount(@PathVariable Long employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        if (employee != null) return employee.getAccounts();
        return null;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, params='name', produces = {MediaType.APPLICATION_JSON_VALUE})
    public Set<Account> getAccountByEmployeeName(@RequestParam(name="name") String employeeName) {
        Employee employee = employeeService.getEmployeeByName(employeeName);
        if (employee != null) return employee.getAccounts();
        return null;
    }

    //@PostMapping(value = "/{employeeId}", consumes = "application/json")
    @RequestMapping(value = "/{employeeId}", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String creatAccount(@PathVariable Long employeeId, @RequestBody Account account) {
        logger.debug(String.format("Employee Id: %d, account: %s", employeeId, account.toString()));
        String msg = "The account was created.";
        boolean isSuccess = accountService.save(account, employeeName);

        if (!isSuccess) msg = "The account was not created.";

        return msg;
    }
}