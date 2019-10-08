package com.jc.service;

import com.jc.entity.PaySalary;

import java.util.List;

public interface PaySalaryService {
    List<PaySalary> list(Integer page,Integer limit,String username);
    Integer count(String username);
    Integer add(PaySalary paySalary);
    Integer update(PaySalary paySalary);
    Integer delete(List<Integer> list);
    PaySalary findByNo(String payNo);
}
