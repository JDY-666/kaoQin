package com.jc.dao;

import com.jc.entity.Account;
import org.apache.ibatis.annotations.Param;

public interface AccountMapper {
    Account login(@Param("username") String username, @Param("pwd") String password);
    Integer add(Account account);
}
