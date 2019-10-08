package com.jc.service;

import com.jc.entity.Account;

public interface AccountService {
    Account login(String username,String password);
    Integer add(Account account);
}
