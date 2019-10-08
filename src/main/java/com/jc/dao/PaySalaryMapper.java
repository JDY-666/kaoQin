package com.jc.dao;

import com.jc.entity.PaySalary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaySalaryMapper {
    List<PaySalary> list(@Param("page") Integer page, @Param("limit") Integer limit, @Param("username")String username);
    Integer count(String username);
    Integer add(PaySalary paySalary);
    Integer update(PaySalary paySalary);
    Integer delete(@Param("list")List<Integer> list);
    PaySalary findByNo(String payNo);
}
