package com.jc.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Integer id;
    private String username;
    private String password;
    private Employee employee;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
