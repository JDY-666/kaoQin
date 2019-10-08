package com.jc.controller;

import com.jc.entity.Account;
import com.jc.service.AccountService;
import com.jc.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService service;
    @RequestMapping("/login")
    @ResponseBody
    public ResultMap login(HttpServletRequest request,Account account){
        System.out.println(account.getUsername());
        Account login = service.login(account.getUsername(), account.getPassword());
        request.getSession().setAttribute("userAccount",account);
        return ResultMap.ok(login);
    }
}
