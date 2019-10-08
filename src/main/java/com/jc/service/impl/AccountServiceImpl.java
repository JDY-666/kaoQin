package com.jc.service.impl;

import com.jc.dao.AccountMapper;
import com.jc.entity.Account;
import com.jc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper mapper;
    @Override
    public Account login(String username, String password) {
        return mapper.login(username,password);
    }

    @Override
    public Integer add(Account account) {
        return mapper.add(account);
    }

}
